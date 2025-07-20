package com.dsa2025.learn.lld.questions.elevatorSystem.controller;

import com.dsa2025.learn.lld.questions.elevatorSystem.constant.Direction;
import com.dsa2025.learn.lld.questions.elevatorSystem.constant.ElevatorState;
import com.dsa2025.learn.lld.questions.elevatorSystem.dto.ElevatorDisplay;
import com.dsa2025.learn.lld.questions.elevatorSystem.dto.ElevatorDoor;
import com.dsa2025.learn.lld.questions.elevatorSystem.dto.InternalButton;

/**
 * Elevator class represents a single elevator car with its all components
 * this the main entity which handles the elevator movement
 */
public class Elevator {
    // Immutable properties these do not change after elevator creation
    private final int elevatorId; // Unique Identifier for this elevator
    private final ElevatorDisplay elevatorDisplay; // Display of elevator showing the current floor and direction
    private final InternalButton internalButton; // Button panel inside elevator
    private final ElevatorDoor elevatorDoor; // Door mechanism

    private int currentFloor; // current floor where the elevator is located
    private ElevatorState elevatorState; // shows current state of elevator
    private Direction elevatorDirection; // current direction of elevator

    /**
     * Constructor to initialize elevator with all required components
     * @param elevatorId Unique ID for the elevator
     * @param elevatorDisplay Display component
     * @param currentFloor Starting floor
     * @param elevatorState Initial state
     * @param elevatorDirection Initial direction
     * @param internalButton Button panel component
     * @param elevatorDoor Door component
     */

    public Elevator(int elevatorId, ElevatorDisplay elevatorDisplay, int currentFloor,
                    ElevatorState elevatorState, Direction elevatorDirection, InternalButton internalButton,
                    ElevatorDoor elevatorDoor) {
        this.elevatorDisplay = elevatorDisplay;
        this.currentFloor = currentFloor;
        this.elevatorState = elevatorState;
        this.elevatorDirection = elevatorDirection;
        this.internalButton = internalButton;
        this.elevatorId = elevatorId;
        this.elevatorDoor = elevatorDoor;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public Direction getElevatorDirection() {
        return elevatorDirection;
    }

    public void setElevatorDirection(Direction elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }

    /**
     * So when someone inside an elevator, he will call the pressButton in elevator
     * @param destination Target floor number
     */
    public void pressButton(int destination) {

        internalButton.pressButton(destination, this); // delegate to internal button handler
    }

    /**
     * This method will update the display in each floor
     * and show the current status called whenever a new floor comes
     */
    private void updateDisplay() {
        elevatorDisplay.setDisplay(this.currentFloor, this.elevatorDirection); // Update display with the current floor and direction
        elevatorDisplay.showDisplay(); // Show the updated display
    }

    /**
     * This method will be used to move the elevator from the current floor to a destination floor
     *
     * @param destinationFloor Target floor to reach
     * @param direction        direction of the movement
     */
    public void moveElevator(int destinationFloor, Direction direction) {

        // If already at a destination floor, open the door and close the door

        if (this.currentFloor == destinationFloor) {
            openAndCloseDoor(); // open the door, wait, close
            return; // movement successful
        }

        // set elevator state to moving and update direction
        this.elevatorState = ElevatorState.MOVING; // change state idle to moving
        setElevatorDirection(direction); // set the movement direction

        //calculate the step increment +1 for UP, -1 for Down
        int step = (direction == Direction.UP) ? 1 : -1;

        // Move elevator floor by floor until it reaches its destination
        while (currentFloor != destinationFloor) {
            currentFloor += step; // Move to the next floor up or down
            updateDisplay(); // update and show display
            simulateMovementDelay(); // wait to simulate real elevator movement
        }

        // Elevator has reached destination
        setElevatorState(ElevatorState.IDLE);    // Change state back to IDLE
        openAndCloseDoor();              // Open door for passengers
    }

    /**
     Private method to handle door operations at a floor
     * Opens door, waits for passengers, then closes door
     */
    private void openAndCloseDoor() {
        elevatorDoor.openDoor();         // Open the elevator door
        simulateDelay(2000);             // Wait 2 seconds for passengers to enter/exit
        elevatorDoor.closeDoor();        // Close the elevator door
    }

    /**
     * Private method to simulate time taken to move between floors
     */
    private void simulateMovementDelay() {
        simulateDelay(1000);             // Wait 1 second to simulate floor-to-floor movement
    }

    /**
     * Private utility method to create delays in execution
     * @param milliseconds Time to wait in milliseconds
     */
    private void simulateDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);  // Pause execution for specified time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle interruption gracefully
        }
    }
}
