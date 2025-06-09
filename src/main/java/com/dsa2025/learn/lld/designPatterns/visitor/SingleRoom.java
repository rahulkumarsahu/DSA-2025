package com.dsa2025.learn.lld.designPatterns.visitor;

public class SingleRoom implements RoomElement {

    public int roomPrice = 0;

    // room visitor is a interface implemented by multiple operations...
    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
