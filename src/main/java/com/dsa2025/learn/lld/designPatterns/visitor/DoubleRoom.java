package com.dsa2025.learn.lld.designPatterns.visitor;

public class DoubleRoom implements RoomElement {

    public int roomPrice = 0;

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
