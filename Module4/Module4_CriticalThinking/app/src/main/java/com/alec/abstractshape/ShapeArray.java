package com.alec.abstractshape;

/**
 * Class to store an array of pre-defined shapes, and then print them out.
 */
public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapeArray = {new Triangle(5, 5, 5), new Circle(5), new Rectangle(5, 5)};
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}
