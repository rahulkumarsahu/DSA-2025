package com.dsa2025.learn.lld.designPatterns.prototype;

public class Circle implements Prototype {

    int radius;
    String color;

    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public Prototype clone() {
        return new Circle(this.radius, this.color);
    }

    public void display() {
        System.out.println("Circle: radius = " + radius + ", color = " + color);
    }
}
