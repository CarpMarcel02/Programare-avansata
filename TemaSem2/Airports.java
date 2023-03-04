public class Airports extends Location{
    int numberOfTerminals;

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        numberOfTerminals = numberOfTerminals;
    }

    public Airports( String name, double coordX, double coordY, int numberOfTerminals) {
        super( name, coordX, coordY);
        this.numberOfTerminals=numberOfTerminals;
    }
}
