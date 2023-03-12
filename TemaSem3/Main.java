import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        List<Node> nume =new ArrayList<Node>();

        nume.add(new Programmer ("DorianPopa", LocalDate.of(2002, 2, 9),new String[]{"C++","Java","C#"}));
        nume.add(new Programmer ("Iraphahell", LocalDate.of(2005, 10, 12),new String[]{"C++","C#"}));
        nume.add(new Programmer ("Xslayder", LocalDate.of(1999, 12, 20),new String[]{"C++","Java"}));
        nume.add(new Programmer ("Bercea", LocalDate.of(1989, 5, 5),new String[]{"Rust","Phyton","C#"}));
        nume.add(new Designer("VirgilAbloh",LocalDate.of(1980, 9, 30),"Off-White"));
        nume.add(new Designer("DonatellaVersace",LocalDate.of(1955, 5, 2),"Versace"));

         Programmer programator =new Programmer("Iraphahell", LocalDate.of(2005, 10, 12),new String[]{"C++","C#"});
         Designer tatalNostru = new Designer("Dumnezeu",LocalDate.of(0,1,1),"Pamantul");
         Person  mitica= new Person("MiticaConstantin",LocalDate.of(1976,04,28));

         Company emag=new Company("Emag");
         Company altex=new Company("Altex");


        /**
         * Aici am realizat compararea obiectelor
         */
        Collections.sort(nume,Comparator.comparing(Node::getName));
        for(Node c: nume)
        {
            System.out.println(c);
        }
        System.out.println();

        tatalNostru.addRelationship(programator,  "Stapanul Lui");
        tatalNostru.addRelationship(mitica ,  "Seful Lui");
        tatalNostru.addRelationship(emag,"CEO");



        programator.addRelationship(mitica,  " fiul lui ");
        programator.addRelationship(emag,"lucrator");

        mitica.addRelationship(programator,  " tatal lui ");
        mitica.addRelationship(emag,"paznic");

        emag.addRelationship(altex,"rivali");


        Network network = new Network();

        network.addNode(tatalNostru);
        network.addNode(mitica);
        network.addNode(programator);
        network.addNode(emag);
        network.addNode(altex);

        System.out.println(network.getNodeImportance(tatalNostru));




        network.printNetworkByImportance();
    }
}