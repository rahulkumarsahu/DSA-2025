package com.dsa2025.learn.lld.solid;

// If class B is a subtype of class A, then we should be able to replace an object of A
// with B without breaking the behavior of the program
// Ex. Class A (Parent) -> class B (child)
// so I have an code jo ki object A ko accept kar raha aur code execute ho raha hai with A
// but agar mein A ke place mein B kar du to it should not break the code.
//Subclass should extend the capability of the parent class, not narrow it down.

interface Bike {
    void turnOnEngine();
    void accelerate();
}

class MotorCycle implements Bike {
    boolean isEngine;
    int speed;

    @Override
    public void turnOnEngine() {
        isEngine = true;
    }

    @Override
    public void accelerate() {
        speed = speed + 10;
    }
}

class Bicycle implements Bike {

    @Override
    public void turnOnEngine() {
        throw new AssertionError("there is no engine");
    }

    @Override
    public void accelerate() {
        // do something
    }
}

// here what we have done is suppose I have code written already using Bike object
// jisko Motorcycle ki object aa rahi thi and code already understand ki turnOnEngine karunga to
// mera engine turn on ho jayega but maine kya kiya usko Bicycle ka object de diya...
// to kya hoga isme Bicycle mein engine hai hi nahi to wo kaam nahi karega to child is narrowing down or
// not completely replaceable.