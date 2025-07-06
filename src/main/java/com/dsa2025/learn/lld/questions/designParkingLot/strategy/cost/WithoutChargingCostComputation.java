package com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost;

import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.PricingStrategy;
import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

public class WithoutChargingCostComputation implements CostComputation {

    public PricingStrategy pricingStrategy;

    public WithoutChargingCostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public double costComputation(Ticket ticket) {
        return pricingStrategy.calculatePrice(ticket);
    }
}
