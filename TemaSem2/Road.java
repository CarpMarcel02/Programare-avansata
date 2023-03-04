import java.util.Objects;

public class Road {
    //The location and road types will be implemented as enums.
    // Roads may be highways, express, country, etc.

    ///Each road has a type, length and a speed limit.

    private int speedLimit;
    private ClasaRoad type_drum;
    private double length;


    public Location punctPornire;
    public Location punctSosire;

    public int numarLocatiePornire;
    public int numarLocatieSosire;

    int indexStrada;

    // Each class should have appropriate constructors,
    public Road(int speed_limit, ClasaRoad type_drum, double length, Location punctPornire, Location punctPlecare) {

        numarLocatiePornire=punctPornire.indexLocatie;
        numarLocatieSosire=punctPlecare.indexLocatie;
        indexStrada++;
        this.speedLimit = speed_limit;
        this.type_drum = type_drum;
        setLength(length,punctPornire,punctPlecare );
        this.punctPornire = punctPornire;
        this.punctSosire = punctPlecare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road)) return false;
        Road road = (Road) o;
        return speedLimit == road.speedLimit && Double.compare(road.length, length) == 0
                && type_drum == road.type_drum
                && Objects.equals(punctPornire, road.punctPornire)
                && Objects.equals(punctSosire, road.punctSosire);
    }




    public int getSpeed_limit() {
        return speedLimit;
    }

    public void setSpeed_limit(int speed_limit) {
        this.speedLimit = speed_limit;
    }

    public ClasaRoad getType_drum() {
        return type_drum;
    }

    public void setType_drum(ClasaRoad type_drum) {
        this.type_drum = type_drum;
    }

    public double getLength() {
        return length;
    }
    //The length of a road should not be less than the euclidian distance between the location coordinates.

    /**
     * Seteaza lungimea dar mai intai verifica sa vada daca lungimea este mai mica decat lungimea euclidiana
     * @param length
     * @param PunctPornire
     * @param PunctPlecare
     */
    public void setLength(double length, Location PunctPornire,Location PunctPlecare) {

        boolean b1 = length < Math.sqrt(((PunctPlecare.getcoordY() - PunctPornire.getcoordY()) * (PunctPlecare.getcoordY() - PunctPornire.getcoordY()))
                + ((PunctPlecare.getcoordX() - PunctPornire.getcoordX()) * (PunctPlecare.getcoordX() - PunctPornire.getcoordX())));
        System.out.println();
        if(b1==false)
            this.length=length;
        else
            System.err.println("Problema nu este valida");

    }
    //The toString method form the Object class must be properly overridden for all the classes.
    @Override
    public String toString() {

        return "Road{" +
                "speed_limit=" + speedLimit +
                ", type_drum=" + type_drum +
                ", length=" + length +
                ", PunctPornire=" + punctPornire +
                ", PunctPlecare=" + punctSosire +
                '}';
    }}