package com.dsa2025.learn.lld.questions.parkingLot.strategy.pricing;

import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();

        long hours = ChronoUnit.HOURS.between(entryTime, exitTime);
        if (hours == 0) hours = 1; // Minimum 1-hour charge

        return (int) (hours * ticket.getParkingSpot().getBasePrice());
    }
}
