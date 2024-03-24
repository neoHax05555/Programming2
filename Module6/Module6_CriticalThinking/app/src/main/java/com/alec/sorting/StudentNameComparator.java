package com.alec.sorting;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student0, Student student1) {
        /* returns positive if first student0 is greater than student1, negative if student0 is less than student1, or
         * 0 if equal. */
        return student0.name.compareTo(student1.name);
    }
}
