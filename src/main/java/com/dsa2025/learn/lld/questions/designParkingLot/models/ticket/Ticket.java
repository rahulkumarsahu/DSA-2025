package com.dsa2025.learn.lld.questions.designParkingLot.models.ticket;

import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;


import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private final String ticketId;
    private final LocalDateTime entryTime;
    private Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public Ticket(LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", entryTime=" + entryTime +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
