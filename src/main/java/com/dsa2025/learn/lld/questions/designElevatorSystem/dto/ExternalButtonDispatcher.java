package com.dsa2025.learn.lld.questions.designElevatorSystem.dto;

import com.dsa2025.learn.lld.questions.designElevatorSystem.constant.Direction;
import com.dsa2025.learn.lld.questions.designElevatorSystem.constant.DispatchingAlgorithm;
import com.dsa2025.learn.lld.questions.designElevatorSystem.controller.ElevatorController;
import com.dsa2025.learn.lld.questions.designElevatorSystem.controller.ElevatorCreator;

import java.util.List;

/**
 * ExternalButtonDispatcher handles dispatching of external elevator requests
 * Supports multiple dispatching algorithms: FIXED_FLOOR, ODD_EVEN, CLOSEST_CAR
 */
public class ExternalButtonDispatcher {
    private static final List<ElevatorController> elevatorControllers = ElevatorCreator.elevatorControllerList;  // Reference to all elevators
    private DispatchingAlgorithm algorithm;  // Current dispatching algorithm to use

    /**
     * Constructor with default algorithm
     * Defaults to CLOSEST_CAR algorithm
     */
    public ExternalButtonDispatcher() {
        this.algorithm = DispatchingAlgorithm.CLOSEST_CAR;  // Default algorithm
    }

    /**
     * Constructor with specified algorithm
     * @param algorithm Dispatching algorithm to use
     */
    public ExternalButtonDispatcher(DispatchingAlgorithm algorithm) {
        this.algorithm = algorithm;  // Set specified algorithm
    }

    /**
     * Method to set dispatching algorithm
     * @param algorithm New algorithm to use
     */
    public void setDispatchingAlgorithm(DispatchingAlgorithm algorithm) {
        this.algorithm = algorithm;  // Update current algorithm
        System.out.println("Dispatching algorithm changed to: " + algorithm);  // Log algorithm change
    }

    /**
     * The Main method to submit external elevator request
     * Uses configured algorithm to determine which elevator to dispatch
     * @param floor Floor from which request is made
     * @param direction Direction requested (UP or DOWN)
     */
    public void submitExternalRequest(int floor, Direction direction) {
        ElevatorController selectedController = switch (algorithm) {
            case FIXED_FLOOR -> useFixedFloorAlgorithm(floor);  // Use fixed floor assignment
            case ODD_EVEN -> useOddEvenAlgorithm(floor);     // Use odd/even assignment
            case CLOSEST_CAR -> useClosestCarAlgorithm(floor, direction);  // Use the closest car
        };  // Controller to handle the request

        // Select elevator based on configured algorithm

        // If elevator found, submit request
        if (selectedController != null) {
            System.out.println("Request dispatched using " + algorithm + " algorithm: Floor " +
                    floor + " " + direction + " -> Elevator " +
                    selectedController.getElevator().getElevatorId());
            selectedController.submitExternalRequest(floor, direction);  // Submit request to selected elevator
        } else {
            System.out.println("No suitable elevator found for floor " + floor);  // Log if no elevator available
        }
    }

    /**
     * FIXED_FLOOR Algorithm: Each elevator serves specific floor ranges
     * Elevator 1: Floors 0-5, Elevator 2: Floors 6-10
     * @param floor Requested floor
     * @return ElevatorController for the floor range, or null if no elevator available
     */
    private ElevatorController useFixedFloorAlgorithm(int floor) {
        for (ElevatorController controller : elevatorControllers) {
            int elevatorId = controller.getElevator().getElevatorId();  // Get elevator ID

            // Elevator 1 serves floors 0-5
            if (elevatorId == 1 && floor >= 0 && floor <= 5) {
                return controller;  // Return elevator 1 controller
            }
            // Elevator 2 serves floors 6-10
            else if (elevatorId == 2 && floor >= 6 && floor <= 10) {
                return controller;  // Return elevator 2 controller
            }
        }
        return null;  // No elevator assigned to this floor range
    }

    /**
     * ODD_EVEN Algorithm: Odd elevators serve odd floors, even elevators serve even floors
     * @param floor Requested floor
     * @return ElevatorController based on odd/even matching, or null if no match
     */
    private ElevatorController useOddEvenAlgorithm(int floor) {
        for (ElevatorController controller : elevatorControllers) {
            int elevatorId = controller.getElevator().getElevatorId();  // Get elevator ID

            // Odd elevator for odd floor
            if (elevatorId % 2 == 1 && floor % 2 == 1) {
                return controller;  // Return odd elevator for an odd floor
            }
            // Even elevator for an even floor
            else if (elevatorId % 2 == 0 && floor % 2 == 0) {
                return controller;  // Return even elevator for an even floor
            }
        }
        return null;  // No matching odd/even elevator found
    }

    /**
     * CLOSEST_CAR Algorithm: Find the closest available elevator considering direction and proximity
     * @param floor Requested floor
     * @param direction Requested direction
     * @return ElevatorController of closest suitable elevator
     */
    private ElevatorController useClosestCarAlgorithm(int floor, Direction direction) {
        ElevatorController best = null;      // Best elevator found so far
        int minDistance = Integer.MAX_VALUE; // Minimum distance found so far

        // First pass: Find elevator moving in the same direction or idle
        for (ElevatorController controller : elevatorControllers) {
            int elevatorFloor = controller.getElevator().getCurrentFloor();  // Current elevator floor
            int distance = Math.abs(floor - elevatorFloor);                  // Distance to a requested floor

            // Check if elevator is moving in the same direction or is idle
            boolean sameDirection = controller.getElevator().getElevatorDirection() == direction;
            boolean isIdle = controller.getElevator().getElevatorState() ==
                    com.dsa2025.learn.lld.questions.designElevatorSystem.constant.ElevatorState.IDLE;

            // Prefer elevator with the same direction or idle, and closer distance
            if ((sameDirection || isIdle) && distance < minDistance) {
                minDistance = distance;  // Update minimum distance
                best = controller;       // Update best elevator
            }
        }

        // Second pass: If no optimal elevator found, use the closest one regardless of direction
        if (best == null && !elevatorControllers.isEmpty()) {
            best = elevatorControllers.getFirst();  // Start with first elevator
            minDistance = Math.abs(floor - best.getElevator().getCurrentFloor());  // Calculate initial distance

            // Find elevator with minimum distance
            for (ElevatorController controller : elevatorControllers) {
                int distance = Math.abs(floor - controller.getElevator().getCurrentFloor());  // Calculate distance
                if (distance < minDistance) {
                    minDistance = distance;  // Update minimum distance
                    best = controller;       // Update best elevator
                }
            }
        }

        return best;  // Return the best elevator found
    }
}
