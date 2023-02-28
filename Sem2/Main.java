public class Main {
    public static void main(String args[]) {
//Create and print on the screen various objects of the two classes.

        Location c1 = new Location(Location.Locatii.Oras, "Iasi", 10.0, 20.0);
        System.out.println(c1);
        Location c2 = new Location(Location.Locatii.Benzinarie,"Rompetrol",11.0,19.0);
        System.out.println(c2);
        Road r1= new Road(50, Road.Drumuri.National,2,c1,c2);// daca pun 1 da eroare, din cauza distantei euclidiane
        System.out.println(r1);
        Location c3= new Location(Location.Locatii.Aeroport,"Aeroportul international Iasi",40, 60);
        System.out.println(c3);
        Road r2 =new Road(90, Road.Drumuri.Autostrada,50,c3,c1);
        System.out.println(r2);
        Road r3 =new Road(70, Road.Drumuri.Expres,60,c3,c2);



    }
}