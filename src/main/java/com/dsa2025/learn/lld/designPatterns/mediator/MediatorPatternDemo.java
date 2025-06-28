package com.dsa2025.learn.lld.designPatterns.mediator;

public class MediatorPatternDemo {

    public static void main(String[] args) {
        AuctionMediator carMediator = new Auction(); // 1,2
        AuctionMediator bikeMediator = new Auction(); // 3,4
        AuctionMediator houseMediator = new Auction(); //5,6

        Colleague bidder1 = new Bidder("A", carMediator);
        Colleague bidder2 = new Bidder("B", carMediator);
        Colleague bidder7 = new Bidder("M", carMediator);

        Colleague bidder3 = new Bidder("C", bikeMediator);
        Colleague bidder4 = new Bidder("D", bikeMediator);

        Colleague bidder5 = new Bidder("E", houseMediator);
        Colleague bidder6 = new Bidder("F", houseMediator);

        bidder1.placeBid(2000);
        bidder2.placeBid(3000);
        bidder7.placeBid(3001);

        bidder3.placeBid(5000);
        bidder4.placeBid(6000);
        bidder3.placeBid(1001);

        bidder5.placeBid(8000);
        bidder6.placeBid(9000);
        bidder5.placeBid(10001);
    }
}
