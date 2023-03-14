package org.example;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.LinkedList;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("George"),
                new Student("Mihai"),
                new Student("Dorian"),
                new Student("Popa"),
                new Student("Marcel")
        );
    /**
    * Put all the projects in a TreeSet and print them sorted by their names.
    */
        TreeSet<Project> projects = new TreeSet<>(Arrays.asList(
                new Project("Proiect 1"),
                new Project("Proiect 2"),
                new Project("Proiect 3"),
                new Project("Proiect 4"),
                new Project("Proiect 5")
        ));
    /**
    * Put all the students in a LinkedList and print them sorted by their names. Aici am folosit si stream-urile.
    */
        LinkedList<Student> sortedStudents = students.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        sortedStudents.forEach(student -> System.out.println(student.getName()));

        for (Project project : projects) {
            System.out.println(project.getName());
        }

    }
}