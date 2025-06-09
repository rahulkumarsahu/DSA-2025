package com.dsa2025.learn.lld.designPatterns.mediator;

public interface AuctionMediator {
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int bidAmount);
}
