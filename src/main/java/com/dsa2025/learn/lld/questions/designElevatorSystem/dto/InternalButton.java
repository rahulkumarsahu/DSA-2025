package com.dsa2025.learn.lld.questions.designElevatorSystem.dto;

import com.dsa2025.learn.lld.questions.designElevatorSystem.controller.Elevator;
/**
 * InternalButton represents the button panel inside elevator
 * Handles floor selection requests from passengers inside elevator
 */
public class InternalButton {
    private final InternalButtonDispatcher dispatcher = new InternalButtonDispatcher();  // Dispatcher for internal requests

    /**
     * Method called when passenger presses floor button inside elevator
     * @param destination Target floor number
     * @param elevator Reference to elevator containing this button panel
     */
    public void pressButton(int destination, Elevator elevator) {
        System.out.println("Internal button " + destination +
                " pressed in elevator " + elevator.getElevatorId());  // Log button press
        dispatcher.submitInternalRequest(destination, elevator);  // Submit internal request
    }
}
