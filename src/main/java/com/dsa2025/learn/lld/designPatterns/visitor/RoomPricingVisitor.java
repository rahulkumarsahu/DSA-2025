package com.dsa2025.learn.lld.designPatterns.visitor;

public class RoomPricingVisitor implements RoomVisitor {

    @Override
    public void visit(SingleRoom singleRoomObj) {
        singleRoomObj.roomPrice = 1000;
        System.out.println("Pricing computation logic of SingleRoom");
    }

    @Override
    public void visit(DoubleRoom doubleRoomObj) {
        doubleRoomObj.roomPrice = 2000;
        System.out.println("Pricing computation logic of DoubleRoom");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoomObj) {
        deluxeRoomObj.roomPrice = 3000;
        System.out.println("Pricing computation logic of DeluxeRoom");
    }
}
