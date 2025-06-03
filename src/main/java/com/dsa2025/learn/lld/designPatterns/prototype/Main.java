package com.dsa2025.learn.lld.designPatterns.prototype;

public class Main {

    public static void main(String[] args) {
        Circle original = new Circle(10, "Blue");
        Circle copy = (Circle) original.clone();

        original.display();  // Output: Circle: radius = 10, color = Blue
        copy.display();      // Output: Circle: radius = 10, color = Blue
    }

}
