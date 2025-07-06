package com.dsa2025.learn.lld.questions.designParkingLot.strategy.cost;

import com.dsa2025.learn.lld.questions.parkingLot.dto.Ticket;

public interface CostComputation {

        double costComputation(Ticket ticket);
}
