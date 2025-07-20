package com.dsa2025.learn.lld.questions.parkingLot.service;

import com.dsa2025.learn.lld.questions.parkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.parkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.models.spots.manager.ParkingSpotManager;
import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;

import java.time.LocalDateTime;
import java.util.Optional;

public class ParkingLotEntryService {

    private final ParkingSpotManager parkingSpotManager;

    public ParkingLotEntryService(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }

    /**
     * This method will be used to find the parking Space based onVehicleType from spot Manager based on parking Strategy.
     * @return ParkingSpot
     */
    public Optional<ParkingSpot> findParkingSpace() {
        return parkingSpotManager.findParkingSpot();
    }

    /**
     * This method will be used to book the parking Spot so it will find the parking spot and book it
     * @param vehicle vehicle
     * @return Optional<ParkingSpot>
     */
    public Optional<ParkingSpot> bookSpot(Vehicle vehicle) {

        Optional<ParkingSpot> parkingSpot = findParkingSpace();
        Boolean status = Boolean.FALSE;

        if (parkingSpot.isPresent()) {
            status = parkingSpotManager.requestParkVehicle(parkingSpot.get(), vehicle);
        }

        if (status) {
            System.out.println("Your Spot is booked");
        } else {
            System.out.println("Your Spot is not booked");
        }

        return parkingSpot;
    }

    /**
     * This method will be used to generate the Ticket
     * @param vehicle vehicle
     * @return Optional<Ticket>
     */
    public Optional<Ticket> ticketIssuer(Vehicle vehicle) {
        Optional<ParkingSpot> bookedSpot = bookSpot(vehicle);

        return bookedSpot.map(parkingSpot -> new Ticket(
                LocalDateTime.now(),
                vehicle,
                parkingSpot
        ));
    }

}
