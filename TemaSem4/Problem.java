package org.Sem4;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Problem {
    Map<Student, List<Project>> prefMap = new HashMap<>();

    int validate;

    /**
     * aici introduc in problema datele problemei(practic introduc in Map ca primu element key- Studentul iar ca valoare va fi lista cu proiecte asociata studentului
     * @param students
     */
    public void adaugareDateInProblema(List<Student> students)
    {
        for(Student student : students)
        {
            prefMap.put(student, student.proiecteAccesibile);
        }


    }

    /**
     * verifica daca problema este valida, in principal vede daca fiecare student are cel putin 1 proiect in lista sa de proiecte
     * iar pentru fiecare proiect vede daca a fost asignat la macar un student
     * @param proiecte
     */
    public void esteProblemavalida(TreeSet<Project> proiecte)
    {
        for (Map.Entry<Student, List<Project>> entry : prefMap.entrySet()) {
            Student student = entry.getKey();
            List<Project> projects = entry.getValue();
            if(student.getProiecteAsignate()!=0) {
                validate = 1;
                System.out.println(student.getName() + " are " + student.getProiecteAsignate());
            }
                else
            {
                System.out.println(student.getProiecteAsignate());
                validate=0;
                System.err.println("Problema nu este valida asfavanga ");

            }
            for (Project project : proiecte) {
                if(project.getNrPersoaneAsignare()==0)
                {
                    System.out.println(project.getName());

                    validate=0;
                    System.err.println("Problema nu este valida " + project.getName());

                }
                else
                    validate=1;

            }

        }

        if(validate==1)
            System.out.println("Problema este valida");
    }

    /**
     * constructorul
     * @param validate
     */
    public Problem(int validate) {
        this.validate = validate;
    }

    /**
     * problema verifica studentii care au ca nr de proiecte un numar mai mic decat media de proiecte per persoana
     */
    public void noOfPreference()
    {
        List<List<Project>> allStudentPrefs = new ArrayList<>(prefMap.values());
        double avgNumOfPreferences = allStudentPrefs.stream()
                .mapToInt(List::size)
                .average()
                .orElse(0.0);
        List<Student> filteredStudents = prefMap.keySet().stream()
                .filter(student -> prefMap.get(student).size() < avgNumOfPreferences)
                .collect(Collectors.toList());
        filteredStudents.forEach(System.out::println);

    }

    /**
     * Algoritmul de rezolvare a problemei, sorteaza fiecare student in ordine crescatoare dupa nr de prroiecte disponibile,
     * iar dupa parcurge lista iar primul student va lua proiectul care are cele mai multe asignari din toate celelalte din lista studentului
     */
    public void alegereProiect() {
        List<Student> eligibleStudents = prefMap.keySet().stream()
                .filter(student -> student.getProiecteAsignate() > 0)
                .sorted(Comparator.comparingInt(Student::getProiecteAsignate))
                .collect(Collectors.toList());

        for (Student student : eligibleStudents) {
            int max=0;
            Project prototip= new Project(null,0,0);
            for (Project project : student.proiecteAccesibile) {//deci tre sa vad cum fac ca proiectu sa fie deja asignat am facut variabila tre sa mut si ala setproiect ales
                if(project.getNrPersoaneAsignare()>max && project.getaFostAsignat()==0) {
                    max = project.getNrPersoaneAsignare();
                     prototip= project;
                }
                student.setProiectAles(prototip);
                prototip.setaFostAsignat(1);
            }
            System.out.println("studentul " + student.getName() + " a ales proiectul " + student.getProiectAles());
        }
    }
    @Override
    public String toString() {
        return "Problem{" +
                "prefMap=" + prefMap +
                ", validate=" + validate +
                '}';
    }
}
