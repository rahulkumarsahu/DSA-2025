package com.dsa2025.learn.lld.questions.elevatorSystem.dto;

import com.dsa2025.learn.lld.questions.elevatorSystem.constant.Direction;
import com.dsa2025.learn.lld.questions.elevatorSystem.constant.DispatchingAlgorithm;

/**
 * Floor class represents a single floor in the building
 * Contains external buttons for calling elevators
 */
public class Floor {
    private final int floorId;                              // Unique identifier for this floor
    private final ExternalButtonDispatcher dispatcher;     // Dispatcher to handle elevator requests

    /**
     * Constructor with default dispatching algorithm
     * @param floorId Floor number/identifier
     */
    public Floor(int floorId) {
        this.floorId = floorId;                            // Set floor identifier
        this.dispatcher = new ExternalButtonDispatcher();  // Create dispatcher with default algorithm
    }

    /**
     * Constructor with specified dispatching algorithm
     * @param floorId Floor number/identifier
     * @param algorithm Dispatching algorithm to use
     */
    public Floor(int floorId, DispatchingAlgorithm algorithm) {
        this.floorId = floorId;                            // Set floor identifier
        this.dispatcher = new ExternalButtonDispatcher(algorithm);  // Create dispatcher with specified algorithm
    }

    /**
     * Method called when external elevator button is pressed on this floor
     * @param direction Direction requested (UP or DOWN)
     */
    public void pressButton(Direction direction) {
        System.out.println("External " + direction + " button pressed on floor " + floorId);  // Log button press
        dispatcher.submitExternalRequest(floorId, direction);  // Submit request through dispatcher
    }

    /**
     * Method to change dispatching algorithm for this floor
     * @param algorithm New algorithm to use
     */
    public void setDispatchingAlgorithm(DispatchingAlgorithm algorithm) {
        dispatcher.setDispatchingAlgorithm(algorithm);  // Update dispatcher algorithm
    }

    /**
     * Getter method for floor ID
     * @return Floor identifier
     */
    public int getFloorId() {
        return floorId;  // Return floor ID
    }
}