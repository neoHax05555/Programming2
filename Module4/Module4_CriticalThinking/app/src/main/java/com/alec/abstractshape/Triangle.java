package com.alec.abstractshape;

/**
 * This class defines a 2D {@link Triangle} of type {@link Shape}. It is defined as a shape with 3 lengths.
 */
public class Triangle extends Shape {
    private final double lengthSide1, lengthSide2, lengthSide3;

    Triangle(double lengthSide1, double lengthSide2, double lengthSide3) {
        this.lengthSide1 = lengthSide1;
        this.lengthSide2 = lengthSide2;
        this.lengthSide3 = lengthSide3;
    }

    @Override
    public double area() {
        // S = (a + b + c)/2
        // A = sqrt(s(s-a)(s-b)(s-c)
        double s = this.perimeter() / 2;
        return Math.sqrt(s * (s - this.lengthSide1) * (s - this.lengthSide2) * (s - this.lengthSide3));
    }

    @Override
    public double perimeter() {
        // P = (a + b + c)
        return (this.lengthSide1 + this.lengthSide2 + this.lengthSide3);
    }
}
