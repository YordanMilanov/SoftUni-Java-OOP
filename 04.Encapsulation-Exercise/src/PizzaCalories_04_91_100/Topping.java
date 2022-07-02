package PizzaCalories_04_91_100;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") ||
                toppingType.equals("Veggies") ||
                toppingType.equals("Cheese") ||
                toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
        throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
        this.weight = weight;
        } else {
        throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.toppingType));
        }
    }

    public double calculateCalories() {
        double toppingValue = 0;
        if (this.toppingType.equals("Meat")) {
            toppingValue = 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            toppingValue = 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            toppingValue = 1.1;
        } else if (this.toppingType.equals("Sauce ")) {
            toppingValue = 0.9;
        }
        return 2 * this.weight * toppingValue;
    }
}
