public class Company implements Node, Comparable<Company>
{
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
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
        //what if the name is null?
    }

    public Company(String name) {
        this.name = name;
    }
}