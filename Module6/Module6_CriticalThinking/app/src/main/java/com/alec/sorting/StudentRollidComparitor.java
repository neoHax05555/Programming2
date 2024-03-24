package com.alec.sorting;

import java.util.Comparator;

public class StudentRollidComparitor implements Comparator<Student> {

    @Override
    public int compare(Student student0, Student student1) {
        /* returns positive if first student0 is greater than student1, negative if student0 is less than student1, or
         * 0 if equal. For int value would be the same as the String compare if we just take the difference. */
        return student0.rollno - student1.rollno;
    }
}
