package com.dsa2025.learn.lld.questions.parkingLot.strategy.cost;


import com.dsa2025.learn.lld.questions.parkingLot.models.ticket.Ticket;

public interface CostComputation {

        double costComputation(Ticket ticket);
}
