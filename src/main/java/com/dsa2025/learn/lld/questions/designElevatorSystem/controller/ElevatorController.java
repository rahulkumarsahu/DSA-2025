package com.dsa2025.learn.lld.questions.designElevatorSystem.controller;

import com.dsa2025.learn.lld.questions.designElevatorSystem.constant.Direction;
import com.dsa2025.learn.lld.questions.designElevatorSystem.constant.ElevatorState;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * ElevatorController manages the operation of a single elevator
 * It handles request queue and control elevator movement
 */
public class ElevatorController {

    private final Elevator elevator;// the elevator this controller manages
    // This is to store when lift is going down from up floor 10 to 0, and it got request for 5 it will fulfill the request
    private final PriorityQueue<Integer> downQueue; //  Queue for downward floor request (max-heap)
    // This is to store when lift is going from down to up
    private final PriorityQueue<Integer> upQueue; // Queue for upward floor request (min-heap)
    private final AtomicBoolean isRunning;             // Thread-safe flag for controller state

    /**
     * Constructor to initialize controller with an elevator
     *
     * @param elevator The elevator to be controlled
     */
    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;                       // Store reference to elevator
        this.upQueue = new PriorityQueue<>();          // Min heap: serves lower floors first when going up
        this.downQueue = new PriorityQueue<>((a, b) -> b - a); // Max heap: serves higher floors first when going down
        this.isRunning = new AtomicBoolean(false);     // Initially controller is not running
    }

    /**
     * Getter method to access the elevator
     *
     * @return The elevator managed by this controller
     */
    public Elevator getElevator() {
        return elevator;
    }

    /**
     * Method to handle external requests (from floor buttons outside elevator)
     *
     * @param floor     floor for which request is made
     * @param direction direction is up or down
     */
    public synchronized void submitExternalRequest(int floor, Direction direction) {
        addToQueue(floor, direction); // Add request to appropriate queue
        startControllerIfNeeded(); // start controller thread if not running
    }

    /**
     * Method to handle internal requests (from buttons inside elevator)
     * @param floor Destination floor requested from inside elevator
     */
    public synchronized void submitInternalRequest(int floor) {
        // Determine a direction based on current floor vs. a requested floor
        Direction requestDirection = (floor > elevator.getCurrentFloor()) ? Direction.UP : Direction.DOWN;
        addToQueue(floor, requestDirection);  // Add to the appropriate queue
        startControllerIfNeeded();            // Start controller if needed
    }


    /**
     * Private method to start controller thread if not already running
     * Uses atomic compare-and-set for thread safety
     */
    private void startControllerIfNeeded() {
        // Start controller only if it's not already running
        if (isRunning.compareAndSet(false, true)) {
            // Background thread for processing requests
            Thread controllerThread = new Thread(this::controlElevator); // Create new thread
            controllerThread.start();                             // Start the thread
        }
    }

    /**
     * ElevatorSystem control loop that runs in background thread
     * Processes requests from queues and moves elevator accordingly
     */
    private void controlElevator() {
        // Continue processing while controller is running and thread is not interrupted
        while (isRunning.get() && !Thread.currentThread().isInterrupted()) {
            // Only process requests when elevator is idle
            if (elevator.getElevatorState() == ElevatorState.IDLE) {
                Integer nextFloor = getNextFloor();  // Get the next floor to visit

                // If no more requests, stop the controller
                if (nextFloor == null) {
                    stopController();    // Stop controller thread
                    break;              // Exit the loop
                }

                // Move elevator only if not already at the requested floor
                if (nextFloor != elevator.getCurrentFloor()) {
                    // Determine a direction to move
                    Direction moveDirection = (nextFloor > elevator.getCurrentFloor()) ?
                            Direction.UP : Direction.DOWN;

                    // Log elevator movement
                    System.out.println("Elevator " + elevator.getElevatorId() +
                            " moving " + moveDirection + " to floor " + nextFloor);
                    // Move elevator to a requested floor
                    elevator.moveElevator(nextFloor, moveDirection);
                }
            }

            // Short pause to prevent busy waiting and allow other threads to run
            try {
                Thread.sleep(100);       // Sleep for 100 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interruption
                break;                   // Exit the loop
            }
        }
    }

    /**
     * Private method to get next floor to visit based on the current direction and available requests
     * Implements SCAN algorithm: continue in current direction, then reverse
     * @return Next floor number to visit, or null if no requests
     */
    private synchronized Integer getNextFloor() {
        // Prioritize current direction first (SCAN algorithm)
        if (elevator.getElevatorDirection() == Direction.UP && !upQueue.isEmpty()) {
            return upQueue.poll();       // Get the next upward request
        } else if (elevator.getElevatorDirection() == Direction.DOWN && !downQueue.isEmpty()) {
            return downQueue.poll();     // Get the next downward request
        } else if (!upQueue.isEmpty()) {
            return upQueue.poll();       // No current direction requests, try upward
        } else if (!downQueue.isEmpty()) {
            return downQueue.poll();     // Try downward requests
        }
        return null;                     // No requests available
    }


    /**
     * This method will be used to add floor request in proper queue
     * @param floor floor number to add
     * @param direction direction of the request
     */
    private void addToQueue(int floor, Direction direction) {

        if (direction == Direction.UP) {
            upQueue.offer(floor);
        } else {
            downQueue.offer(floor);
        }
    }

    /**
     * Private method to stop controller when no more requests
     */
    private void stopController() {
        isRunning.set(false);           // Set running flag to false
        System.out.println("Elevator " + elevator.getElevatorId() +
                " controller stopped - no requests"); // Log controller stop
    }

}
