package PizzaCalories_04_100_100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInput = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInput[1];
        int numberOfToppings = Integer.parseInt(pizzaInput[2]);
        Pizza pizza = null;
        if (pizzaInput[0].equals("Pizza")) {
            pizza = new Pizza(pizzaName, numberOfToppings);
        }

        String[] doughInput = scanner.nextLine().split("\\s+");

        String doughType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double doughGrams = Double.parseDouble(doughInput[3]);

        Dough dough = null;
        if (doughInput[0].equals("Dough")) {
            dough = new Dough(doughType, bakingTechnique, doughGrams);
        }

        pizza.setDough(dough);

        String[] toppingInput = scanner.nextLine().split("\\s+");

        while (!toppingInput[0].equals("END")) {

            String toppingType = toppingInput[1];
            double toppingGrams = Double.parseDouble(toppingInput[2]);

            Topping topping = null;

            if (toppingInput[0].equals("Topping")) {
                topping = new Topping(toppingType, toppingGrams);
            }

            pizza.addTopping(topping);

            toppingInput = scanner.nextLine().split("\\s+");
        }
        System.out.println(pizza);
    }
}
