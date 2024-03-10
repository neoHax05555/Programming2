package com.alec.abstractshape;

/**
 * This class defines a 2D {@link Rectangle} of type {@link Shape}. It is defined as a shape with 2 lengths, one to
 * represent length and one to represent width.
 */
public class Rectangle extends Shape {
    private final double width, length;

    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    @Override
    public double area() {
        return this.length * this.width;
    }

    @Override
    public double perimeter() {
        return (this.length * 2) + (this.width * 2);
    }
}
