package SOLIDresources.products;

public class Lemonade extends Drink implements Product{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    private static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        super(milliliters, DENSITY);
    }

    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * (this.getMilliliters() * DENSITY);;
    }
}
