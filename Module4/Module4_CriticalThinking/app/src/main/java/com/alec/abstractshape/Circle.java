package com.alec.abstractshape;

/**
 * This class defines a 2D {@link Circle} of type {@link Shape}. It is defined as a shape with a radius.
 */
public class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        // A = Pi R ^ 2
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double perimeter() {
        // C = 2 Pi R
        return 2 * Math.PI * this.radius;
    }
}
