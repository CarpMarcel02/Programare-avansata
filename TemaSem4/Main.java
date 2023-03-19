package org.Sem4;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.*;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.ObjectUtils;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        /**
         * Put all the students in a LinkedList
         */
        List<Student> students = Arrays.asList(
                new Student("George",new ArrayList<>(),0, null),
                new Student("Mihai",new ArrayList<>(),0,null),
                new Student("Dorian",new ArrayList<>(),0,null),
                new Student("Popa",new ArrayList<>(),0,null),
                new Student("Marcel",new ArrayList<>(),0,null)
        );
    /**
    * Put all the projects in a TreeSet
    */
        TreeSet<Project> projects = new TreeSet<>(Arrays.asList(
                new Project("Proiect 1",0,0),
                new Project("Proiect 2",0,0),
                new Project("Proiect 3",0,0),
                new Project("Proiect 4",0,0),
                new Project("Proiect 5",0,0)
        ));

        /**
         * am adaugat pentru fiecare student in lista lui de proiecte anumite proiecte
         */
        Project proiectDeAdaugat ;
        for(Student student : students) {
            if (student.getName().equals("George")) {
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 1")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 2")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 3")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
            }
            if (student.getName().equals("Mihai")) {
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 2")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 3")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 4")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 5")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
            }
            if (student.getName().equals("Dorian")) {
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 4")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 5")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 2")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
            }
            if (student.getName().equals("Popa")) {
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 1")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
            }
            if (student.getName().equals("Marcel")) {
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 2")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
                proiectDeAdaugat = projects.stream().filter(p -> p.getName().equals("Proiect 3")).findFirst().orElse(null);
                student.addElementToList(proiectDeAdaugat);
            }
        }
        /**
         * creez o problema random
         */
        Problem problema = new Problem(0);
        /**
         * adaug in problema datele, studentii cu proiectele lor
         */
        problema.adaugareDateInProblema(students);
        /**
         * verifica daca problema este valida
         */
        //problema.esteProblemavalida( projects );
        /**
         * Using Java Stream API, write a query that display all the students that have a number of preferences lower than the average number of preferences.
         */
        // problema.noOfPreference();
        /**
         * Rezolvarea Problemei in sine
         */
        problema.alegereProiect();


/**
 *        Use a third-party library in order to generate random fake names for students and projects.
 */
    for (int i=1;i<=10;i++) {
        Faker faker = new Faker();
        Student martin = new Student(faker.name().fullName(), new ArrayList<>(), 0,null);
         System.out.println(martin.getName());
                }

     for (int i=1;i<=10;i++) {
            Faker faker = new Faker();
            Project proiect = new Project(faker.book().title(), 0,0);
            System.out.println(proiect.getName());
        }






    }
}