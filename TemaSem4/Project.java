package org.Sem4;
import java.util.*;
public class Project implements Comparable<Project>{
    /**
     * Create an object-oriented model of the problem. Students and projects have names. Make sure the objects of these classes are comparable.
     */
    private String name;

    private int nrPersoaneAsignare;

    private int aFostAsignat;

    public int getaFostAsignat() {
        return aFostAsignat;
    }

    public void setaFostAsignat(int aFostAsignat) {
        this.aFostAsignat = aFostAsignat;
    }

    public String getName() {
        return name;
    }

    public int getNrPersoaneAsignare() {
        return nrPersoaneAsignare;
    }

    public void setNrPersoaneAsignare(int nrPersoaneasignare) {
        this.nrPersoaneAsignare = nrPersoaneasignare;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project(String name, int nrPersoaneasignare,int aFostAsignat) {
        this.name = name;
        this.nrPersoaneAsignare=nrPersoaneasignare;
        this.aFostAsignat=aFostAsignat;

    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.getName());
    }
}