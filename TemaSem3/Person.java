import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class Person implements Node, Comparable<Person> {

    private String name;
    private LocalDate dateOfBirth;
    private Map<Node, String> relationships = new HashMap<>();

    /**
     * adauga obiectul in HashMap-ul relationships
     * @param node
     * @param value
     */
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }
    @Override
    public String getName() {
        return name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    @Override
    public int getId() {
        return 0;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * compara numele fiecarui obiect si le pune in ordine in lista creata
     * @param other
     * @return
     */
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    public Person(String name,LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth=dateOfBirth;

    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", relationships=" + relationships +
                '}';
    }


}