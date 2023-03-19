package org.Sem4;
import java.util.*;

public class Student implements Comparable<Student> {
    /**
     * Create an object-oriented model of the problem. Students and projects have names. Make sure the objects of these classes are comparable.
     */

    private String name;

    public List<Project> proiecteAccesibile;

    private Project proiectAles;

    private int proiecteAsignate;

    public int getProiecteAsignate() {
        return proiecteAsignate;
    }


    public Project getProiectAles() {
        return proiectAles;
    }

    public void setProiectAles(Project proiectAles) {
        this.proiectAles = proiectAles;
    }

    public String getName() {
        return name;
    }




    public Student(String name,List<Project> proiecteAccesibile,int proiecteAsignate, Project proiect) {
        this.name = name;
        this.proiecteAccesibile=proiecteAccesibile;
        proiecteAsignate=0;
        this.proiectAles=proiect;

    }

    /**
     * adauga proiectele in lista de proiecte facuta special pentru student, de asemenea cand aduag in proiect, el va fi contorizat
     * pentru numarul de persoane caruia proiectul respectiv a fost asignat si se contorizeaza de asemenea si nr de proiecte a studentului
     * @param proiect
     */
    public void addElementToList(Project proiect) {
        proiecteAccesibile.add(proiect);
        int nrPersoaneAsignare = proiect.getNrPersoaneAsignare();
        nrPersoaneAsignare++;
        proiecteAsignate++;
        proiect.setNrPersoaneAsignare(nrPersoaneAsignare);


    }
    @Override
    public String toString() {
        return name;
    }


    public int compareTo(Student other) {
        return Integer.compare(this.proiecteAsignate, other.proiecteAsignate);
    }
}