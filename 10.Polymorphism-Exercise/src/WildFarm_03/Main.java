package WildFarm_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] animalTokens = input.split("\\s+");
            if (animalTokens[0].equals("Cat")) {
                Animal cat = new Cat(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3], animalTokens[4]);
                animals.add(cat);
            } else if (animalTokens[0].equals("Mouse")) {
                Animal mouse = new Mouse(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animals.add(mouse);
            } else if (animalTokens[0].equals("Tiger")) {
                Animal tiger = new Tiger(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animals.add(tiger);
            } else if (animalTokens[0].equals("Zebra")) {
                Animal zebra = new Zebra(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                animals.add(zebra);
            }

            input = scanner.nextLine();
            String[] foodTokens = input.split("\\s+");
            if (foodTokens[0].equals("Vegetable")) {
                Food vegetable = new Vegetable(Integer.parseInt(foodTokens[1]));
                foods.add(vegetable);
            } else if (foodTokens[0].equals("Meat")) {
                Food meat = new Meat(Integer.parseInt(foodTokens[1]));
                foods.add(meat);
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            Food food = foods.get(i);

            animal.makeSound();
            animal.eat(food);
        }


        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }
}
