import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String args[]) {

        City iasi= new City("Iasi",10.0,20.0,80);
        City dacia= new City("Dacia",10.0,20.0,100);
        GasStation rompetrol= new GasStation("Rompetrol",11.0,19.0,8.0);
        Airports aeroport= new Airports("Aeroportul international Iasi",40, 60,4);
        City hanuAncutei= new City("Hanu  Ancutei",28, 47,200);

        Problem pb = new Problem();
        pb.addLocation(iasi);
        pb.addLocation(dacia);
        pb.addLocation(rompetrol);
        pb.addLocation(aeroport);
         pb.addLocation(hanuAncutei);

        pb.Graph(pb.contorLocatii);
        Road dn1 = new Road(50, ClasaRoad.NATIONAL,2,iasi,dacia);// daca pun 1 da eroare, din cauza distantei euclidiane
        Road izvor = new Road(90, ClasaRoad.AUTOSTRADA,50,dacia,aeroport);
        Road soseauaNationala = new Road(70, ClasaRoad.EXPRES,60,aeroport,rompetrol);
        pb.addRoad(dn1);
        pb.addRoad(izvor);
        pb.addRoad(soseauaNationala);

        pb.dfs(iasi,hanuAncutei,pb.locations);




    }
}