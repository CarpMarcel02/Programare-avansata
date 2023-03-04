public class GasStation extends Location{

    double gasPrice;

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        gasPrice = gasPrice;
    }

    public GasStation( String name, double coordX, double coordY,double gasPrice) {
        super( name, coordX, coordY);
        this.getGasPrice();
    }
}
