package com.dsa2025.learn.lld.questions.parkingLot;

import com.dsa2025.learn.lld.questions.parkingLot.constant.ParkingStrategyType;
import com.dsa2025.learn.lld.questions.parkingLot.constant.PaymentModeEnum;
import com.dsa2025.learn.lld.questions.parkingLot.constant.PricingStrategyEnum;
import com.dsa2025.learn.lld.questions.parkingLot.constant.VehicleType;
import com.dsa2025.learn.lld.questions.parkingLot.cost.CostCalculation;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Vehicle;
import com.dsa2025.learn.lld.questions.parkingLot.entrance.EntranceGate;
import com.dsa2025.learn.lld.questions.parkingLot.exit.ExitGate;
import com.dsa2025.learn.lld.questions.parkingLot.factory.CostComputationFactory;
import com.dsa2025.learn.lld.questions.parkingLot.factory.ParkingStrategyFactory;
import com.dsa2025.learn.lld.questions.parkingLot.factory.PricingFactory;
import com.dsa2025.learn.lld.questions.parkingLot.spots.*;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.ParkingStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ParkingSpotMain {

    private static final List<ParkingSpot> twoWheelerParkingSpotList = new ArrayList<>();
    private static final List<ParkingSpot> fourWheelerParkingSpotList = new ArrayList<>();


    public static void main(String[] args) {


        generateParkingSpot();

        ParkingStrategy randomStrategy = ParkingStrategyFactory.getParkingStrategy(ParkingStrategyType.RANDOM);
        ParkingStrategy nearToEntranceStrategy = ParkingStrategyFactory.getParkingStrategy(ParkingStrategyType.NEAR_TO_ENTRANCE);
        ParkingStrategy nearToEntranceElevatorStrategy = ParkingStrategyFactory.getParkingStrategy(ParkingStrategyType.NEAR_TO_ENTRANCE_AND_ELEVATOR);

        ParkingSpotManager twoWheelerParkingSpotManager1 = new TwoWheelerSpotManager(twoWheelerParkingSpotList, randomStrategy);
        ParkingSpotManager twoWheelerParkingSpotManager2 = new TwoWheelerSpotManager(twoWheelerParkingSpotList, nearToEntranceStrategy);
        ParkingSpotManager twoWheelerParkingSpotManager3 = new TwoWheelerSpotManager(twoWheelerParkingSpotList, nearToEntranceElevatorStrategy);

        //
        ParkingSpotManager fourWheelerParkingSpotManager1 = new FourWheelerSpotManager(fourWheelerParkingSpotList, randomStrategy);
        ParkingSpotManager fourWheelerParkingSpotManager2 = new FourWheelerSpotManager(fourWheelerParkingSpotList, nearToEntranceStrategy);
        ParkingSpotManager fourWheelerParkingSpotManager3 = new FourWheelerSpotManager(fourWheelerParkingSpotList, nearToEntranceElevatorStrategy);


        // First Vehicle comes to entrance Gate
        EntranceGate twoWheelerEntranceGate1 = new EntranceGate(twoWheelerParkingSpotManager1);
        EntranceGate twoWheelerEntranceGate2 = new EntranceGate(twoWheelerParkingSpotManager2);
        EntranceGate twoWheelerEntranceGate3 = new EntranceGate(twoWheelerParkingSpotManager3);

        EntranceGate fourWheelerEntranceGate1 = new EntranceGate(fourWheelerParkingSpotManager1);
        EntranceGate fourWheelerEntranceGate2 = new EntranceGate(fourWheelerParkingSpotManager2);
        EntranceGate fourWheelerEntranceGate3 = new EntranceGate(fourWheelerParkingSpotManager3);

        Vehicle twoWheelerVehicle1 = new Vehicle("KA123456", VehicleType.TWO_WHEELER);
        Vehicle twoWheelerVehicle2 = new Vehicle("KA374889", VehicleType.TWO_WHEELER);
        Vehicle twoWheelerVehicle3 = new Vehicle("KA864321", VehicleType.TWO_WHEELER);

        Vehicle fourWheelerVehicle1 = new Vehicle("KA65432", VehicleType.FOUR_WHEELER);
        Vehicle fourWheelerVehicle2 = new Vehicle("KA54321", VehicleType.FOUR_WHEELER);
        Vehicle fourWheelerVehicle3 = new Vehicle("KA98670", VehicleType.FOUR_WHEELER);

        Optional<Ticket> twoWheelerTicket1 = twoWheelerEntranceGate1.generateTicket(twoWheelerVehicle1);
        Optional<Ticket> twoWheelerTicket2 = twoWheelerEntranceGate2.generateTicket(twoWheelerVehicle2);
        Optional<Ticket> twoWheelerTicket3 = twoWheelerEntranceGate3.generateTicket(twoWheelerVehicle3);

        Optional<Ticket> fourWheelerTicket1 =  fourWheelerEntranceGate1.generateTicket(fourWheelerVehicle1);
        Optional<Ticket> fourWheelerTicket2 = fourWheelerEntranceGate2.generateTicket(fourWheelerVehicle2);
        Optional<Ticket> fourWheelerTicket3 = fourWheelerEntranceGate3.generateTicket(fourWheelerVehicle3);

        PricingStrategy hourPricingStrategy = PricingFactory.getPricingStrategy(PricingStrategyEnum.HOURLY);
        PricingStrategy minutePricingStrategy = PricingFactory.getPricingStrategy(PricingStrategyEnum.MINUTE);
        PricingStrategy defaultPricingStrategy = PricingFactory.getPricingStrategy(PricingStrategyEnum.DEFAULT);

        CostCalculation twoWheelerCostCalculation1 = CostComputationFactory.getCostCalculator(VehicleType.TWO_WHEELER, hourPricingStrategy);
        CostCalculation twoWheelerCostCalculation2 = CostComputationFactory.getCostCalculator(VehicleType.TWO_WHEELER, minutePricingStrategy);
        CostCalculation twoWheelerCostCalculation3 = CostComputationFactory.getCostCalculator(VehicleType.TWO_WHEELER, defaultPricingStrategy);

        CostCalculation fourWheelerCostCalculation1 = CostComputationFactory.getCostCalculator(VehicleType.FOUR_WHEELER, hourPricingStrategy);
        CostCalculation fourWheelerCostCalculation2 = CostComputationFactory.getCostCalculator(VehicleType.FOUR_WHEELER, minutePricingStrategy);
        CostCalculation fourWheelerCostCalculation3 = CostComputationFactory.getCostCalculator(VehicleType.FOUR_WHEELER, defaultPricingStrategy);

        ExitGate exitGate1 = new ExitGate(twoWheelerParkingSpotManager1, twoWheelerCostCalculation1);
        ExitGate exitGate2 = new ExitGate(twoWheelerParkingSpotManager1, twoWheelerCostCalculation2);
        ExitGate exitGate3 = new ExitGate(twoWheelerParkingSpotManager1, twoWheelerCostCalculation3);

        ExitGate exitGate4 = new ExitGate(twoWheelerParkingSpotManager1, fourWheelerCostCalculation1);
        ExitGate exitGate5 = new ExitGate(twoWheelerParkingSpotManager1, fourWheelerCostCalculation2);
        ExitGate exitGate6 = new ExitGate(twoWheelerParkingSpotManager1, fourWheelerCostCalculation3);

        if (twoWheelerTicket1.isPresent()) {
            Boolean status = exitGate1.makePayment(twoWheelerTicket1.get(), PaymentModeEnum.UPI.name());
            printStatus(status);
        }

        if (twoWheelerTicket2.isPresent()) {
            Boolean status = exitGate2.makePayment(twoWheelerTicket2.get(), PaymentModeEnum.UPI.name());
            printStatus(status);
        }

        if (twoWheelerTicket3.isPresent()) {
            Boolean status = exitGate3.makePayment(twoWheelerTicket3.get(), PaymentModeEnum.UPI.name());
            printStatus(status);
        }

        if (fourWheelerTicket1.isPresent()) {
            Boolean status = exitGate4.makePayment(fourWheelerTicket1.get(), PaymentModeEnum.UPI.name());
            printStatus(status);
        }

        if (fourWheelerTicket2.isPresent()) {
            Boolean status = exitGate5.makePayment(fourWheelerTicket2.get(), PaymentModeEnum.UPI.name());
            printStatus(status);
        }

        if (fourWheelerTicket3.isPresent()) {
            Boolean status = exitGate6.makePayment(fourWheelerTicket3.get(), PaymentModeEnum.UPI.name());
            printStatus(status);
        }

    }

    private static void printStatus(Boolean status) {

        if (status) {
            System.out.println("Vehicle Exit");
        } else {
            System.out.println("Some Issue in code");
        }
    }

    private static void generateParkingSpot() {

        for (int i = 0; i < 100; i++) {
            ParkingStrategyType strategy;
            if (i < 10) {
                strategy = ParkingStrategyType.NEAR_TO_ENTRANCE;
            } else if (i < 20) {
                strategy = ParkingStrategyType.NEAR_TO_ENTRANCE_AND_ELEVATOR;
            } else {
                strategy = ParkingStrategyType.RANDOM;
            }
            twoWheelerParkingSpotList.add(new TwoWheelerSpot(UUID.randomUUID().toString(), strategy));
            fourWheelerParkingSpotList.add(new FourWheelerSpot(UUID.randomUUID().toString(), strategy));
        }

    }

}
