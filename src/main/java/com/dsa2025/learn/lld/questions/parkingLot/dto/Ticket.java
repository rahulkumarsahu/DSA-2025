package com.dsa2025.learn.lld.questions.parkingLot.dto;

import com.dsa2025.learn.lld.questions.parkingLot.constant.PricingStrategyEnum;
import com.dsa2025.learn.lld.questions.parkingLot.spots.ParkingSpot;

import java.time.LocalDateTime;

/**
 * This class will be used to create a ticket which should have property of ticketId, entry time of vehicle,
 * vehicle details and ticket issued for which parking spot.
 *
 * @param ticketId
 * @param entryTime
 * @param vehicle
 * @param parkingSpot
 */
public record Ticket(String ticketId, LocalDateTime entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {

}
