package com.dsa2025.learn.lld.designPatterns.mediator;

public interface Colleague {

    void placeBid(int bidAmount);
    void receiveBidNotification(int bidAmount);
    String getName();
}
