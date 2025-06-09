package com.dsa2025.learn.lld.designPatterns.visitor;

public interface RoomVisitor {

    void visit(SingleRoom singleRoomObj);
    void visit(DoubleRoom doubleRoomObj);
    void visit(DeluxeRoom deluxeRoomObj);
}
