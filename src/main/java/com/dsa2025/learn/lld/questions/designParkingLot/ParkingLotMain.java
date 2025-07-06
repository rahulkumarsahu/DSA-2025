package com.dsa2025.learn.lld.questions.designParkingLot;

import com.dsa2025.learn.lld.questions.designParkingLot.factories.*;
import com.dsa2025.learn.lld.questions.designParkingLot.models.constant.*;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Bike;
import com.dsa2025.learn.lld.questions.designParkingLot.models.mobility.Vehicle;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.ParkingSpot;
import com.dsa2025.learn.lld.questions.designParkingLot.models.spots.manager.ParkingSpotManager;
import com.dsa2025.learn.lld.questions.designParkingLot.models.ticket.Ticket;
import com.dsa2025.learn.lld.questions.designParkingLot.service.ParkingLotEntryService;
import com.dsa2025.learn.lld.questions.designParkingLot.service.ParkingLotExitService;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost.CostComputation;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.parking.ParkingStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.payment.PaymentStrategy;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.PricingStrategy;

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

        PricingStrategy pricingStrategy = PricingStrategyFactory.getPricingStrategy(PricingType.HOURLY);

        CostComputation costComputation = CostComputationFactory.getCostCalculator(
                CostCalculationType.WITHOUT_CHARGING, pricingStrategy);

        ParkingLotExitService parkingLotExitService =
                new ParkingLotExitService(parkingSpotManager, costComputation, paymentStrategy);

        parkingLotExitService.processVehicleExit(ticket.get());

    }
}
