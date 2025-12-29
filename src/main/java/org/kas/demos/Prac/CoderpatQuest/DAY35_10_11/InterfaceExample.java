package org.kas.demos.Prac.CoderpatQuest.DAY35_10_11;

// Define an interface named 'Shape'
interface Shape {
    // Declare abstract methods (implicitly public and abstract)
    void draw();
    double getArea();
}

// Implement the 'Shape' interface in a class named 'Circle'
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Implement the 'Shape' interface in a class named 'Rectangle'
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length " + length + " and width " + width);
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

// Main class to demonstrate the usage of the interface
public class InterfaceExample {
    public static void main(String[] args) {
        // Create objects of classes implementing the interface
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Call methods defined in the interface
        circle.draw();
        System.out.println("Area of circle: " + circle.getArea());

        rectangle.draw();
        System.out.println("Area of rectangle: " + rectangle.getArea());
    }
}