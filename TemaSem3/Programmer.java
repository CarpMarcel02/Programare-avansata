import java.time.LocalDate;
import java.util.Arrays;

public class Programmer extends Person {

    String languages[] =new String[10];
    public Programmer(String name, LocalDate dateOfBirth, String languages[])
    {

        super(name,dateOfBirth);
        this.languages=languages;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", dateOfBirth= " + getDateOfBirth() +
                " Programmer{" +
                " languages=" + Arrays.toString(languages) +
                '}';
    }
}


