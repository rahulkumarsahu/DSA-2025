package com.dsa2025.learn.lld.questions.parkingLot.service;

import com.dsa2025.learn.lld.questions.parkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.parkingLot.models.spots.manager.ParkingSpotManager;
import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.cost.CostComputation;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.payment.PaymentStrategy;

import java.util.Optional;

public class ParkingLotExitService {

    private final ParkingSpotManager parkingSpotManager;
    private final CostComputation costComputation;
    private final PaymentStrategy paymentStrategy;

    public ParkingLotExitService(ParkingSpotManager parkingSpotManager,
                                 CostComputation costComputation, PaymentStrategy paymentStrategy) {
        this.parkingSpotManager = parkingSpotManager;
        this.costComputation = costComputation;
        this.paymentStrategy = paymentStrategy;
    }

    public void processVehicleExit(Ticket ticket) {
        // First request removal of the vehicle...
        Optional<Vehicle> vehicle = parkingSpotManager.requestRemoveVehicle(
                ticket.getVehicle().getVehicleRegistrationNumber());

        if (vehicle.isPresent()) {
            System.out.println("Exit Vehicle no. is: " + vehicle.get().getVehicleRegistrationNumber());
        } else {
            System.out.println("Error.....................");
        }

        double amount = costComputation.costComputation(ticket);

        paymentStrategy.pay(amount);
    }
}
