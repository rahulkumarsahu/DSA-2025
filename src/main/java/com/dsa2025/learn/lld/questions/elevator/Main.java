package com.dsa2025.learn.lld.questions.elevator;

import com.dsa2025.learn.lld.questions.elevator.constant.Direction;
import com.dsa2025.learn.lld.questions.elevator.constant.DispatchingAlgorithm;
import com.dsa2025.learn.lld.questions.elevator.controller.ElevatorCreator;
import com.dsa2025.learn.lld.questions.elevator.dto.Building;
import com.dsa2025.learn.lld.questions.elevator.dto.Floor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class to demonstrate an elevator system with different dispatching algorithms
 * Shows how different algorithms work in practice
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
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

        // Demonstrate different dispatching algorithms
        runAlgorithmDemo(building);
    }

    /**
     * Method to demonstrate different dispatching algorithms
     *
     * @param building Building instance to test with
     */
    private static void runAlgorithmDemo(Building building) throws InterruptedException {
        System.out.println("\n--- Demo 1: CLOSEST_CAR Algorithm (default) ---");
        building.getFloor(2).pressButton(Direction.UP);       // Request from floor 2 to go up
        building.getFloor(7).pressButton(Direction.DOWN);     // Request from floor 7 to go down
        Thread.sleep(5000);  // Allow elevator time to process

        System.out.println("\n--- Demo 2: Switching to FIXED_FLOOR Algorithm ---");
        for (Floor floor : building.floors()) {
            floor.setDispatchingAlgorithm(DispatchingAlgorithm.FIXED_FLOOR);
        }
        building.getFloor(3).pressButton(Direction.UP);       // Should go to elevator 1 (floor 0–5)
        building.getFloor(8).pressButton(Direction.DOWN);     // Should go to elevator 2 (floor 6–10)
        Thread.sleep(5000);  // Allow elevator time to process

        System.out.println("\n--- Demo 3: Switching to ODD_EVEN Algorithm ---");
        for (Floor floor : building.floors()) {
            floor.setDispatchingAlgorithm(DispatchingAlgorithm.ODD_EVEN);
        }
        building.getFloor(5).pressButton(Direction.DOWN);     // Should go to elevator 1 (odd)
        building.getFloor(4).pressButton(Direction.UP);       // Should go to elevator 2 (even)
        Thread.sleep(5000);  // Allow elevator time to process

        System.out.println("\n=== Demo Completed ===");

    }
}