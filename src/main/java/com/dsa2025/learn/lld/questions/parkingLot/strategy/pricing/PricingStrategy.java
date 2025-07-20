package com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing;

import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;

public interface PricingStrategy {

    double calculatePrice(Ticket ticket);
}
