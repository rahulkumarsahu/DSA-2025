package com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost;

import com.dsa2025.learn.lld.questions.designParkingLot.models.ticket.Ticket;
import com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing.PricingStrategy;

public class WithChargingCostComputation implements CostComputation {

    public PricingStrategy pricingStrategy;

    public WithChargingCostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public double costComputation(Ticket ticket) {
        // here can have some diff. parameter for
        return pricingStrategy.calculatePrice(ticket);
    }
}
