package org.example;
import java.util.*;
public class Project implements Comparable<Project>{
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

    public Project(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.getName());
    }
}