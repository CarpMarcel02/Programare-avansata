public class Person implements Node, Comparable<Person> {

    private String name;

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
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
        //what if the name is null?
    }

    public Person(String name) {
        this.name = name;
    }
}