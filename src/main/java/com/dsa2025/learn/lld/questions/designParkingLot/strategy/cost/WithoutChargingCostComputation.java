package com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost;

import com.dsa2025.learn.lld.questions.designParkingLot.models.ticket.Ticket;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.PricingStrategy;


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
