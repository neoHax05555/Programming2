package com.alec.sorting;

public class Student {
    final int rollno;
    final String name, address;

    Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{rollno=" + rollno + ", name='" + name + "'" + ", address='" + address + "'}";
    }
}
