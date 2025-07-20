package com.dsa2025.learn.lld.questions.elevatorSystem.controller;

import com.dsa2025.learn.lld.questions.elevatorSystem.constant.Direction;
import com.dsa2025.learn.lld.questions.elevatorSystem.constant.ElevatorState;
import com.dsa2025.learn.lld.questions.elevatorSystem.dto.ElevatorDisplay;
import com.dsa2025.learn.lld.questions.elevatorSystem.dto.ElevatorDoor;
import com.dsa2025.learn.lld.questions.elevatorSystem.dto.InternalButton;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    // Static list to hold all elevator controllers in the system
    public static final List<ElevatorController> elevatorControllerList = new ArrayList<>();

    // Static block executes when class is first loaded
    static {
        // Create two elevators for the building
        for (int i = 1; i <= 2; i++) {
            // Create elevator with all required components
            Elevator elevator = new Elevator(
                    i,                          // Elevator ID (1, 2)
                    new ElevatorDisplay(),      // Display component for showing floor and direction
                    0,                          // Start at a first floor (floor 0)
                    ElevatorState.IDLE,         // Initial state is IDLE
                    Direction.UP,               // Default initial direction is UP
                    new InternalButton(),       // Internal button panel
                    new ElevatorDoor()         // Door mechanism
            );
            // Create controller for this elevator and add to the list
            elevatorControllerList.add(new ElevatorController(elevator));
        }
    }

}
