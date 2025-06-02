package com.dsa2025.learn.lld.designPatterns.factory;

// Product interface
interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Creator (Factory)
abstract class ShapeFactory {
    // Factory Method
    public abstract Shape createShape();
}

// Concrete Factory A
class CircleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

// Concrete Factory B
class SquareFactory extends ShapeFactory {
    public Shape createShape() {
        return new Square();
    }
}

// Client
public class MethodFactory {
    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory();  // or new SquareFactory();
        Shape shape = factory.createShape();
        shape.draw();  // Output: Drawing Circle
    }
}

