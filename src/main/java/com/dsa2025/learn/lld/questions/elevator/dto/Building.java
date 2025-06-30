package com.dsa2025.learn.lld.questions.elevator.dto;

import java.util.List;

/**
 * Building class represents the entire building structure
 * Contains all floors and provides methods to access them
 *
 * @param floors List of all floors in the building
 */
public record Building(List<Floor> floors) {

    /**
     * Constructor to initialize building with floors
     *
     * @param floors List of Floor objects
     */
    public Building {
        // Store reference to a floor list
    }

    /**
     * Getter method to access all floors
     *
     * @return List of all floors
     */
    @Override
    public List<Floor> floors() {
        return floors;  // Return floors list
    }

    /**
     * Method to get a specific floor by floor number
     *
     * @param floorNumber Floor number to retrieve
     * @return Floor object if found, null otherwise
     */
    public Floor getFloor(int floorNumber) {
        // Search through a floor list to find matching floor number
        return floors.stream()
                .filter(floor -> floor.getFloorId() == floorNumber)  // Filter by floor ID
                .findFirst()                                         // Get first match
                .orElse(null);                                      // Return null if not found
    }
}

