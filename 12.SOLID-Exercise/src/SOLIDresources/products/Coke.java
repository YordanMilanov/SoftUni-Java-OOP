package SOLIDresources.products;

public class Coke extends Drink implements Product {

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    private static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        super(milliliters, DENSITY);
    }


    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * (this.getMilliliters() * DENSITY);
    }
}
