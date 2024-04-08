package com.alec.portfolioproject;

public class Student {
    private final String name, address;
    private final double gpa;

    public Student(String name, String address, double gpa) {
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + ", address='" + address + ", gpa=" + gpa + "}";
    }
}
