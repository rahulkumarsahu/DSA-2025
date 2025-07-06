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
    }

    /**
     * Method to demonstrate different dispatching algorithms
     * @param building Building instance to test with
     */
    private static void runAlgorithmDemo(Building building) {
        // Demo 1: CLOSEST_CAR Algorithm (Default)
        System.out.println("=== DEMO 1: CLOSEST_CAR Algorithm ===");
        demonstrateClosestCarAlgorithm(building);
        waitForCompletion(3000);  // Wait for requests to complete

        // Demo 2: FIXED_FLOOR Algorithm
        System.out.println("\n=== DEMO 2: FIXED_FLOOR Algorithm ===");
        demonstrateFixedFloorAlgorithm(building);
        waitForCompletion(3000);  // Wait for requests to complete

        // Demo 3: ODD_EVEN Algorithm
        System.out.println("\n=== DEMO 3: ODD_EVEN Algorithm ===");
        demonstrateOddEvenAlgorithm(building);
        waitForCompletion(3000);  // Wait for requests to complete

        // Demo 4: Mixed scenario with internal requests
        System.out.println("\n=== DEMO 4: Mixed Internal and External Requests ===");
        demonstrateMixedRequests(building);
        waitForCompletion(5000);  // Wait longer for a complex scenario

        System.out.println("\n=== All Demonstrations Complete ===");
    }

    /**
     * Demonstrate CLOSEST_CAR algorithm with various scenarios
     * @param building Building instance
     */
    private static void demonstrateClosestCarAlgorithm(Building building) {
        System.out.println("Testing CLOSEST_CAR algorithm - elevators dispatch to closest available car");

        // Set all floors to use CLOSEST_CAR algorithm
        for (Floor floor : building.floors()) {
            floor.setDispatchingAlgorithm(DispatchingAlgorithm.CLOSEST_CAR);
        }

        // Test scenarios
        System.out.println("\nScenario: Multiple requests from different floors");
        building.getFloor(3).pressButton(Direction.UP);    // Floor 3 going up
        building.getFloor(7).pressButton(Direction.DOWN);  // Floor 7 going down
        building.getFloor(1).pressButton(Direction.UP);    // Floor 1 going up
        building.getFloor(9).pressButton(Direction.UP);    // Floor 9 going up
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
     * Demonstrate ODD_EVEN algorithm
     * @param building Building instance
     */
    private static void demonstrateOddEvenAlgorithm(Building building) {
        System.out.println("Testing ODD_EVEN algorithm - Odd elevators serve odd floors, even elevators serve even floors");

        // Set floors to use ODD_EVEN algorithm
        for (Floor floor : building.floors()) {
            floor.setDispatchingAlgorithm(DispatchingAlgorithm.ODD_EVEN);
        }

        // Test scenarios
        System.out.println("\nScenario: Requests from odd and even floors");
        building.getFloor(1).pressButton(Direction.UP);    // Odd floor - should go to Elevator 1 (odd)
        building.getFloor(2).pressButton(Direction.UP);    // Even floor - should go to Elevator 2 (even)
        building.getFloor(5).pressButton(Direction.DOWN);  // Odd floor - should go to Elevator 1 (odd)
        building.getFloor(8).pressButton(Direction.DOWN);  // Even floor - should go to Elevator 2 (even)
    }

    /**
     * Demonstrate mixed internal and external requests
     * @param building Building instance
     */
    private static void demonstrateMixedRequests(Building building) {
        System.out.println("Testing mixed internal and external requests with CLOSEST_CAR algorithm");

        // Reset to CLOSEST_CAR for mixed demo
        for (Floor floor : building.floors()) {
            floor.setDispatchingAlgorithm(DispatchingAlgorithm.CLOSEST_CAR);
        }

        // External requests
        System.out.println("\nExternal requests:");
        building.getFloor(5).pressButton(Direction.UP);    // External request from floor 5
        building.getFloor(3).pressButton(Direction.DOWN);  // External request from floor 3

        // Simulate internal requests (from inside elevators)
        System.out.println("\nInternal requests:");
        // Get first elevator and make internal requests
        if (!ElevatorCreator.elevatorControllerList.isEmpty()) {
            var elevator1 = ElevatorCreator.elevatorControllerList.get(0).getElevator();
            var elevator2 = ElevatorCreator.elevatorControllerList.get(1).getElevator();

            // Simulate passenger inside elevator pressing buttons
            elevator1.pressButton(7);  // Internal request to floor 7
            elevator2.pressButton(2);  // Internal request to floor 2
        }
    }

    /**
     * Utility method to wait for elevator operations to complete
     * @param milliseconds Time to wait in milliseconds
     */
    private static void waitForCompletion(int milliseconds) {
        try {
            System.out.println("Waiting for elevator operations to complete...");
            Thread.sleep(milliseconds);  // Wait for operations to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Demo interrupted");
        }
    }

}