package com.dsa2025.learn.lld.questions.parkingLot.exit;

import com.dsa2025.learn.lld.questions.parkingLot.cost.CostCalculation;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Vehicle;
import com.dsa2025.learn.lld.questions.parkingLot.factory.PaymentProcessor;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpotManager;

import java.util.Optional;


public class ExitGate {

    private Ticket ticket;
    private final CostCalculation costCalculation;
    private final ParkingSpotManager parkingSpotManager;


    public ExitGate(ParkingSpotManager parkingSpotManager, CostCalculation costCalculation) {
        this.costCalculation = costCalculation;
        this.parkingSpotManager = parkingSpotManager;
    }
    /**
     * This method will be used to remove the vehicle which is leaving the parking spot
     * @return Boolean
     */
    public Boolean removeVehicle(Ticket ticket) {
        Optional<Vehicle> vehicle = parkingSpotManager.removeVehicle(ticket.vehicle().vehicleNo());
        return vehicle.isPresent();
    }



    /**
     * This method will be used to calculate the price
     * @param ticket ticket
     * @return int
     */
    public int calculatePrice(Ticket ticket) {
        return costCalculation.calculatePrice(ticket);
    }

    /**
     * This method will be used to make payment
     * @param ticket ticket
     */
    public Boolean makePayment(Ticket ticket, String paymentMode) {

        int price = calculatePrice(ticket);
        return PaymentProcessor.processPayment(price, paymentMode, ticket);
    }

    public Ticket getTicket() {
        return ticket;
    }

}
