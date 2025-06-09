package com.dsa2025.learn.lld.designPatterns.visitor;

public class Visitor {

    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        RoomVisitor maintenanceVisitor = new RoomMaintenanceVisitor();
        RoomVisitor pricingVisitor = new RoomPricingVisitor();

        System.out.println("== Maintenance Visitor ==");
        singleRoom.accept(maintenanceVisitor);
        doubleRoom.accept(maintenanceVisitor);
        deluxeRoom.accept(maintenanceVisitor);

        System.out.println("\n== Pricing Visitor ==");
        singleRoom.accept(pricingVisitor);
        doubleRoom.accept(pricingVisitor);
        deluxeRoom.accept(pricingVisitor);
    }
}
