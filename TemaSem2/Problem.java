import java.util.Arrays;
import java.util.*;


public class Problem {

    public Location[] locations;
    private Road[] roads;

    private LinkedList<Integer> adjLists[];//pentru algoritmul DFS
    private boolean visited[];//pentru algoritmul DFS

    int contorLocatii;

    int contorStrazi;


    public  Problem()
    {

        this.locations=new Location[7];
        this.roads=new Road[7];
        contorLocatii=0;
        contorStrazi=0;

    }

    /**
     * Aceasta functie imi adauga locatiile intr-un vector si verifica prin functia predefinita equals daca nu exista deja acea locatie
     * @param location
     */
    public void addLocation(Location location) {
        for (int i = 0; i < contorLocatii; i++) {
            if (this.locations[i].equals(location)) {
                System.out.println("Location already exists.");
                return;
            }
            if (this.locations[i].getName().equals(location.getName())) {
                System.out.println("Location with the same name already exists.");
                return;
            }
        }
        this.locations[contorLocatii++] = location;
    }

    /**
     * Aceasta functie imi adauga strazile intr-un vector si verifica prin functia predefinita equals daca nu exista deja acea strada
     * @param road
     */
    public void addRoad(Road road) {
        for (int i = 0; i < contorStrazi; i++) {
            if (this.roads[i].equals(road)) {
                System.out.println("Road already exists.");
                return;
            }
        }
       addEdge(road);
        this.roads[contorStrazi++] = road;

    }

    /**
     * Aceasta functie ma ajuta sa imi afiseze frumos toate metodele din clasa
     * @return afiseaza toate informatiile despre problema
     */
    @Override
    public String toString() {

        return "Problem{" +
                "locations=" + Arrays.toString(locations) +
                ", roads=" + Arrays.toString(roads) +
                ", contorLocatii=" + contorLocatii +
                ", contorStrazi=" + contorStrazi +
                '}';
    }

    /**
     * Verifica daca problema este valida si returneaza un mesaj cu rapsunsul
     */
    public void valid()
    {
        if(contorStrazi>=1 && contorLocatii>=2)
            System.out.println("Problema este valida");
            else
            System.err.println("Problema nu este valida");

    }

    /**
     * functie ajutatoare pentru algoritmul DFS pentru a vedea daca exista drum de la o locatie la alta
     * @param contorLocatii
     */
     void Graph(int contorLocatii) {
        adjLists = new LinkedList[contorLocatii];
        visited = new boolean[contorLocatii];

        for (int i = 0; i < contorLocatii; i++)
        {adjLists[i] = new LinkedList<Integer>();
        visited[i]=false;}

    }

    /**
     * Adauga strazile intr-o lista de adiacenta pentru fiecare locatie
     * @param strada
     */

    public void addEdge(Road strada) {

         int srcIndex = strada.numarLocatiePornire;
        int destIndex = strada.numarLocatieSosire;

        // Add the edge from the source location to the destination location

        adjLists[srcIndex].add(destIndex);

    }

    /**
     * Am aplicat functia DFS pentru a vedea daca exista drum de la o locatie sau alta
     * @param start
     * @param end
     * @param locations
     */
    void dfs(Location start, Location end, Location[] locations) {
        int startIndex = start.indexLocatie;

        if (visited == null) {
            visited = new boolean[locations.length];
        }

        visited[startIndex] = true;
        System.out.print(start.getName() + " ");

        if (startIndex == end.indexLocatie) {
            System.out.println("\nFound " + end.getName());
            return;
        }

        Iterator<Integer> ite = adjLists[startIndex].listIterator();
        while (ite.hasNext()) {
            int adjIndex = ite.next();
            if (!visited[adjIndex]) {
                Location adj = locations[adjIndex];
                dfs(adj, end, locations);
            }
        }
        System.out.println("\n Not Found ");
    }



}
