import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Company implements Node, Comparable<Company>
{
    private String name;
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
    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getId() {
        return 0;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * compara numele fiecarui obiect si le pune in ordine in lista creata
     * @param other
     * @return
     */
    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
        //what if the name is null?
    }
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", relationships=" + relationships +
                '}';
    }public Company(String name) {
        this.name = name;
    }
}