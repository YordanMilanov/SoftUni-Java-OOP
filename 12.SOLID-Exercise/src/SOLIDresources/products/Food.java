package SOLIDresources.products;

public abstract class Food {
    private final double grams;

    public Food(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    double getFoodAmountInKilograms() {
        return this.getGrams() / 1000;
    }
}
