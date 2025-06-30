package com.dsa2025.learn.lld.questions.elevator.dto;

import com.dsa2025.learn.lld.questions.elevator.constant.Direction;

/**
 * ElevatorDisplay handles the display inside the elevator
 * Shows the current floor and direction to passengers
 */
public class ElevatorDisplay {

    private int floor;              // Current floor to display
    private Direction direction;    // Current direction to display

    /**
     * Method to update display with the current floor and direction
     * @param floor Current floor number
     * @param direction Current direction of movement
     */
    public void setDisplay(int floor, Direction direction) {
        this.floor = floor;          // Update floor display
        this.direction = direction;  // Update direction display
    }

    /**
     * Method to show the current display information
     * Prints floor and direction to console (simulates LED display)
     */
    public void showDisplay() {
        System.out.println("Floor: " + floor + " | Direction: " + direction);  // Display current status
    }

}
