package com.dsa2025.learn.lld.designPatterns.mediator;

public class MediatorPatternDemo {

    public static void main(String[] args) {
        AuctionMediator auctionMediatorObj = new Auction();

        Colleague bidder1 = new Bidder("A", auctionMediatorObj);
        Colleague bidder2 = new Bidder("B", auctionMediatorObj);

        bidder1.placeBid(2000);
        bidder2.placeBid(3000);
        bidder1.placeBid(3001);
    }
}
