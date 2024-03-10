package com.alec.abstractshape;

/**
 * This Shape class is the base class for all of our shapes. It creates a contract that every 2D shape that we extend
 * from this class must have a custom implementation to calculate the area and perimeter.
 */
public abstract class Shape {
    /**
     * Abstract class to define the custom implementation of an area for given shape child class.
     *
     * @return double value for area of given shape.
     */
    public abstract double area();

    /**
     * Abstract class to define the custom implementation of a perimeter for given shape child class.
     *
     * @return double value for perimeter of given shape.
     */
    public abstract double perimeter();

    /**
     * Defined here for all child classes.
     *
     * @return Will return the name of child class with area and perimeter.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{Area: " + this.area() + " Perimeter: " + this.perimeter() + "}";
    }
}
