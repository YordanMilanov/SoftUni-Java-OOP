package SOLIDresources.products;

public abstract class Drink {

    private final double density;
    private final double milliliters;

    public Drink(double milliliters,double density) {
        this.density = density;
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public double getDensity() {
        return density;
    }

    double getDrinkAmountInLiters() {
        return (this.getMilliliters() / 100) * this.getDensity();
    }
}
