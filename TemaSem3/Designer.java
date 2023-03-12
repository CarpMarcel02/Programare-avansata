import java.time.LocalDate;
import java.util.Arrays;

public class Designer extends Person{

    private String whatHeDesigns;

    public Designer(String name, LocalDate dateOfBirth, String whatHeDesigns) {

        super(name,dateOfBirth);
        this.whatHeDesigns=whatHeDesigns;

    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", dateOfBirth= " + getDateOfBirth() +
                "Designer{" +
                " whatHeDesigns='" + whatHeDesigns + '\'' +
                '}';
    }

}
