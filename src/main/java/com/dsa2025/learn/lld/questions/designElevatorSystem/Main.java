package com.dsa2025.learn.lld.questions.designElevatorSystem;

import com.dsa2025.learn.lld.questions.designElevatorSystem.constant.Direction;
import com.dsa2025.learn.lld.questions.designElevatorSystem.constant.DispatchingAlgorithm;
import com.dsa2025.learn.lld.questions.designElevatorSystem.controller.ElevatorCreator;
import com.dsa2025.learn.lld.questions.designElevatorSystem.dto.Building;
import com.dsa2025.learn.lld.questions.designElevatorSystem.dto.Floor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class to demonstrate an elevator system with different dispatching algorithms
 * Shows how different algorithms work in practice
 */
public class Main {

    public static void main(String[] args) {
        // Initialize building with floors 0-10
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            floors.add(new Floor(i));  // Create a floor with default algorithm
        }

        Building building = new Building(floors);  // Create building with floors

        // Print system initialization information
        System.out.println("=== Elevator System Started ===");
        System.out.println("Building: " + floors.size() + " floors (0-10)");  // Show floor count
        System.out.println("Elevators: " + ElevatorCreator.elevatorControllerList.size());  // Show elevator count
        System.out.println();

        // Demonstrate different dispatching algorithms
        runAlgorithmDemo(building);

        System.out.println("=== Elevator System Ended ===");
    }

    /**
     * Method to demonstrate different dispatching algorithms
     * @param building Building instance to test with
     */
    private static void runAlgorithmDemo(Building building) {

        // Demo 2: FIXED_FLOOR Algorithm
        System.out.println("\n=== DEMO 2: FIXED_FLOOR Algorithm ===");
        demonstrateFixedFloorAlgorithm(building);
        waitForCompletion();  // Wait for requests to complete

        System.out.println("\n=== All Demonstrations Complete ===");
    }



    /**
     * Demonstrate FIXED_FLOOR algorithm
     * @param building Building instance
     */
    private static void demonstrateFixedFloorAlgorithm(Building building) {
        System.out.println("Testing FIXED_FLOOR algorithm - Elevator 1 serves floors 0-5, Elevator 2 serves floors 6-10");

        // Set floors to use FIXED_FLOOR algorithm
        for (Floor floor : building.floors()) {
            floor.setDispatchingAlgorithm(DispatchingAlgorithm.FIXED_FLOOR);
        }

        // Test scenarios
        System.out.println("\nScenario: Requests from different floor ranges");
        building.getFloor(2).pressButton(Direction.UP);    // Should go to Elevator 1 (floors 0-5)
        building.getFloor(8).pressButton(Direction.DOWN);  // Should go to Elevator 2 (floors 6-10)
        building.getFloor(4).pressButton(Direction.UP);    // Should go to Elevator 1 (floors 0-5)
        building.getFloor(10).pressButton(Direction.DOWN); // Should go to Elevator 2 (floors 6-10)
    }

    /**
     * Utility method to wait for elevator operations to complete
     */
    private static void waitForCompletion() {
        try {
            System.out.println("Waiting for elevator operations to complete...");
            Thread.sleep(3000);  // Wait for operations to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Demo interrupted");
        }
    }

}