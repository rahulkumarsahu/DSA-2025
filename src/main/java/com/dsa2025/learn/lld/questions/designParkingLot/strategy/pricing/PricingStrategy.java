package com.dsa2025.learn.lld.questions.designParkingLot.strategy.pricing;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

public interface PricingStrategy {

    double calculatePrice(Ticket ticket);
}
