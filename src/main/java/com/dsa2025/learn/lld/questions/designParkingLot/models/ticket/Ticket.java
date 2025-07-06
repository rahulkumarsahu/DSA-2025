package com.dsa2025.learn.lld.questions.designParkingLot.models.ticket;

import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.PricingStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Vehicle;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private PricingStrategy pricingStrategy;

    public Ticket(String ticketId, LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot,
                  PricingStrategy pricingStrategy) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.pricingStrategy = pricingStrategy;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
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

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
