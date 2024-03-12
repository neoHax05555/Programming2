package com.alec.recursiveproduct;

import java.util.Scanner;

/**
 * Here is a simple program where we collect the next 5 numeric inputs from a user, stores them in an Object that uses a
 * linked list like pattern, and recursively calculates the product(multiplication) of the items in the list.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NumberList numberList = null;
        int input;
        String in;

        // Take an validate 5 user inputs.
        for (int i = 0; i< 5; i++) {
            try {
                System.out.println("Please enter the " + (i + 1) + " numeric value: ");
                in = scan.nextLine();
                System.out.println("You entered: " + in);
                input = Integer.parseInt(in);
                if (null != numberList) {
                    numberList.add(input);
                } else {
                    numberList = new NumberList(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: please enter a numeric value.");
                // Decrement if invalid input, to garuntee we get 5 inputs.
                i--;
            }
        }
        scan.close();

        // print results.
        System.out.println("The product of: " + numberList.toString());
        System.out.println("is: " + numberList.calculateProduct());
    }

    /**
     * Special number list that uses a linked list pattern to store numbers. We included recursive public methods to add
     * a number, , and take the product of them.
     */
    private static class NumberList {
        /** The number that belongs to the present node. */
        private final int number;
        /** The next item in the list. */
        private NumberList next;

        /**
         * Constructor to init this object, set number as final to this node Object.
         *
         * @param number The number to store into this node.
         */
        NumberList(int number) {
            this.number = number;
            next = null;
        }

        /**
         * Returns the number belonging to this node instance.
         *
         * @return int - the number belonging to this node instance.
         */
        private int getNumber() {
            return this.number;
        }

        /**
         * Returns the next node linked to this object.
         *
         * @return {@link NumberList} - The next node linked to this object.
         */
        private NumberList getNext() {
            return this.next;
        }

        /**
         * Set the next {@link NumberList} node attached to this {@link NumberList} node.
         *
         * @param list {@link NumberList} Object to store in this Object.
         */
        private void setNext(NumberList list) {
            this.next = list;
        }

        /**
         * Recursively checks for a null node reference to create a new {@link NumberList} to sore a number in.
         *
         * @param number - The int value to add to this list.
         */
        public void add(int number) {
            if (hasNext()) {
                getNext().add(number);
            } else {
                setNext(new NumberList(number));
            }
        }

        /**
         * Recursively searches for the last node, then appends all values together to return a string representation
         * of this list.
         *
         * @return String - A String representation of this list.
         */
        @Override
        public String toString() {
            if (hasNext()) {
                return this.getNumber() + ", " + getNext().toString();
            } else {
                return this.getNumber() + ";";
            }
        }

        /**
         * Recursively calculates the product of all numbers in this {@link NumberList}.
         *
         * @return int - The product of all numbers in this list.
         */
        public int calculateProduct() {
            if (hasNext()) {
                return this.getNumber() * this.getNext().calculateProduct();
            } else {
                return this.getNumber();
            }
        }

        /**
         * Checks and returns whether the next node is available.
         *
         * @return true  - If next node is taken.
         *     <br>false - If next node is null.
         */
        private boolean hasNext() {
            return (null != next);
        }
    }
}
