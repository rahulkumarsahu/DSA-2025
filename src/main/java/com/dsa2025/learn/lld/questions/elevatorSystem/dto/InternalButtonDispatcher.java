package com.dsa2025.learn.lld.questions.elevatorSystem.dto;

import com.dsa2025.learn.lld.questions.elevatorSystem.controller.Elevator;
import com.dsa2025.learn.lld.questions.elevatorSystem.controller.ElevatorCreator;

/**
 * InternalButtonDispatcher handles internal elevator requests
 * Routes requests to the appropriate elevator controller
 */
public class InternalButtonDispatcher {
    /**
     * Method to submit internal request to appropriate elevator controller
     * @param floor Destination floor requested
     * @param elevator Elevator from which request originated
     */
    public void submitInternalRequest(int floor, Elevator elevator) {
        // Find controller for the specific elevator and submit request
        ElevatorCreator.elevatorControllerList.stream()
                .filter(controller -> controller.getElevator().getElevatorId() == elevator.getElevatorId())  // Find matching elevator
                .findFirst()                                                                                 // Get first match
                .ifPresent(controller -> controller.submitInternalRequest(floor));                          // Submit request if found
    }
}

