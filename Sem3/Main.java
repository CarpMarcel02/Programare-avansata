import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nume =new ArrayList<Node>();
        nume.add(new Person("DorianPopa"));
        nume.add(new Person("Iraphahell"));
        nume.add(new Person("Xslayder"));
        nume.add(new Person("Bercea"));
        //nume.add(new Company("Dormeo"));

        /**
         * Aici am realizat compararea obiectelor
         */
        Collections.sort(nume,Comparator.comparing(Node::getName));
        for(Node c: nume)
        {
            System.out.println(c.getName());
        }


    }
}