package com.dsa2025.learn.lld.designPatterns.visitor;

// this is the object from where we are removing the operation.
public interface RoomElement {

    void accept(RoomVisitor visitor);
}
