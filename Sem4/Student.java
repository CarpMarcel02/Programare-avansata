package org.example;
import java.util.*;

public class Student implements Comparable<Student> {
    /**
     * Create an object-oriented model of the problem. Students and projects have names. Make sure the objects of these classes are comparable.
     */

    private String name;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}