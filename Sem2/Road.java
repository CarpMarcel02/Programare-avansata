public class Road {
   //The location and road types will be implemented as enums.
    // Roads may be highways, express, country, etc.
    enum Drumuri{
        Autostrada,
        Expres,
        National,

    }
    ///Each road has a type, length and a speed limit.
    private int speed_limit;
    private Drumuri type_drum;
    private double length;

    public Location a;
    public Location b;
   // Each class should have appropriate constructors,
    public Road(int speed_limit, Drumuri type_drum, double length, Location a, Location b) {
        this.speed_limit = speed_limit;
        this.type_drum = type_drum;
        setLength(length,a,b );
        this.a = a;
        this.b = b;
    }


    public int getSpeed_limit() {
        return speed_limit;
    }

    public void setSpeed_limit(int speed_limit) {
        this.speed_limit = speed_limit;
    }

    public Drumuri getType_drum() {
        return type_drum;
    }

    public void setType_drum(Drumuri type_drum) {
        this.type_drum = type_drum;
    }

    public double getLength() {
        return length;
    }
//The length of a road should not be less than the euclidian distance between the location coordinates.
    public void setLength(double length, Location a,Location b) {


        boolean b1 = length < Math.sqrt(((b.getCoord_y() - a.getCoord_y()) * (b.getCoord_y() - a.getCoord_y()))
                + ((b.getCoord_x() - a.getCoord_x()) * (b.getCoord_x() - a.getCoord_x())));
        System.out.println();
        if(b1==false)
            this.length=length;
        else
            System.err.println("drumul nu are voie sa fie mai mic decat distanta euclidiana dintre locatii");

    }
//The toString method form the Object class must be properly overridden for all the classes.
    @Override
    public String toString() {

        return "Road{" +
                "speed_limit=" + speed_limit +
                ", type_drum=" + type_drum +
                ", length=" + length +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}