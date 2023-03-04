import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Location {
    //Locations may be cities, airports, gas stations, etc.
    //The location and road types will be implemented as enums.

    ///Each location has a name, type and x, y coordinates
    private double coordX;

    private double coordY;

    private String name;
    int indexLocatie;


    // Each class should have appropriate  getters and setters.
    ///////////////////////////////////////////


    public double getcoordX() {
        return coordX;
    }

    public void setcoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getcoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public  String getName()  {
        return name;
    }

    /**
     * functia equals ma ajuta in clasa Problem pentru a verifica daca am locatii cu accelasi nume
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Location)) return false;
        Location locatie = (Location) o;
        return this.name.equals(locatie.name);
    }
    public void setName(String name) {
        this.name = name;
    }
    ///////////////////////////////////////////
    // Each class should have appropriate constructors,
    public Location( String name, double coordX, double coordY) {


        this.coordX = coordX;
        this.coordY = coordY;
        this.name = name;
        indexLocatie++;

    }
    //The toString method form the Object class must be properly overridden for all the classes.

    /**
     * Functia ma ajuta sa afisez intr-un mod frumos
     * @return toate detaliile despre locatie
     */
    @Override
    public String toString() {
        return "Location{" +
                ", coord_x=" + coordX +
                ", coord_y=" + coordY +
                ", name='" + name + '\'' +
                '}';

    }
}