package com.dsa2025.learn.lld.questions.parkingLot;

import com.dsa2025.learn.lld.questions.parkingLot.factories.*;
import com.dsa2025.learn.lld.questions.parkingLot.models.constant.*;
import com.dsa2025.learn.lld.questions.parkingLot.models.mobility.Bike;
import com.dsa2025.learn.lld.questions.parkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.parkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.parkingLot.models.spots.manager.ParkingSpotManager;
import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.service.ParkingLotEntryService;
import com.dsa2025.learn.lld.questions.parkingLot.service.ParkingLotExitService;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.cost.CostComputation;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.parking.ParkingStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.payment.PaymentStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing.PricingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ParkingLotMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Parking Lot");
        List<ParkingSpot> parkingSpots = new ArrayList<>();

        ParkingSpot twoWheelerParkingSpot = ParkingSpotFactory.getParkingSpot(ParkingSpotType.TWO_WHEELER,
                ParkingLotConstants.BIKE_SPOT_HOUR_PRICE, PricingType.HOURLY);
        parkingSpots.add(twoWheelerParkingSpot);

        Vehicle vehicle = new Bike(UUID.randomUUID().toString(), "KA123456");

        ParkingStrategy parkingStrategy = ParkingStrategyFactory.getParkingStrategy(
                ParkingStrategyType.RANDOM_SPOT, vehicle);


        ParkingSpotManager parkingSpotManager = ParkingSpotManagerFactory.getParkingSpotManager(
                ParkingSpotType.TWO_WHEELER, parkingStrategy, parkingSpots);

        ParkingLotEntryService parkingLotEntryService = new
                ParkingLotEntryService(parkingSpotManager);

        Optional<Ticket> ticket = parkingLotEntryService.ticketIssuer(vehicle);

        PaymentStrategy paymentStrategy = PaymentFactory.getPaymentStrategy(PaymentType.UPI);

        PricingStrategy pricingStrategy = PricingStrategyFactory.
                getPricingStrategy(ticket.get().getParkingSpot().getPricingType());

        CostComputation costComputation = CostComputationFactory.getCostCalculator(
                CostCalculationType.WITHOUT_CHARGING, pricingStrategy);

        ParkingLotExitService parkingLotExitService =
                new ParkingLotExitService(parkingSpotManager, costComputation, paymentStrategy);

        parkingLotExitService.processVehicleExit(ticket.get());

    }
}
