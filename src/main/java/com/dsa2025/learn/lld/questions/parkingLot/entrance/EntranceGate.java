package com.dsa2025.learn.lld.questions.parkingLot.entrance;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Vehicle;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpotManager;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


public class EntranceGate {

    private Ticket ticket;
    private final ParkingSpotManager parkingSpotManager;
    private ParkingSpot parkingSpot;

    public EntranceGate(ParkingSpotManager parkingSpotManager) {
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
            status = parkingSpotManager.parkVehicle(parkingSpot.get(), vehicle);
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
    public Optional<Ticket> generateTicket(Vehicle vehicle) {

        Optional<ParkingSpot> bookedSpot = bookSpot(vehicle);

        if (bookedSpot.isPresent()) {
            String ticketId = UUID.randomUUID().toString();
            Ticket ticket = new Ticket(
                    ticketId,
                    LocalDateTime.now(),
                    vehicle,
                    bookedSpot.get()
            );
            return Optional.of(ticket);
        }

        return Optional.empty();
    }

    public Ticket getTicket() {
        return ticket;
    }

}
