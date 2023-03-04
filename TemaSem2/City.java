public class City extends Location {

    int nrPopulatie;

    public int getNrPopulatie() {
        return nrPopulatie;
    }

    public void SetNrPopulatie(int nrPopulatie) {
        nrPopulatie = nrPopulatie;
    }

    public City( String name, double coordX, double coordY, int nrPopulatie) {
        super( name, coordX, coordY);
        this.nrPopulatie=nrPopulatie;
    }
}
