public class Location {
    //Locations may be cities, airports, gas stations, etc.
    //The location and road types will be implemented as enums.

    enum Locatii{
        Oras,
        Aeroport,
        Benzinarie,
        ;


    }
///Each location has a name, type and x, y coordinates
    private Locatii type;
    private double coord_x;

    private double coord_y;

    private String name;

   // Each class should have appropriate  getters and setters.
    ///////////////////////////////////////////
    public Locatii getLocatii() {
        return type;
    }

    public void setLocatii(Locatii locatii) {
        this.type = locatii;
    }

    public double getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(double coord_x) {
        this.coord_x = coord_x;
    }

    public double getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(double coord_y) {
        this.coord_y = coord_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    ///////////////////////////////////////////
    // Each class should have appropriate constructors,
    public Location(Locatii locatii, String name, double coord_x, double coord_y) {

        this.type= locatii;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.name = name;
    }
//The toString method form the Object class must be properly overridden for all the classes.
    @Override
    public String toString() {
        return "Location{" +
                "type=" + type +
                ", coord_x=" + coord_x +
                ", coord_y=" + coord_y +
                ", name='" + name + '\'' +
                '}';

    }
}