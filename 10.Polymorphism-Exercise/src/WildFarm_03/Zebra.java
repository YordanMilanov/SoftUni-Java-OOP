package WildFarm_03;

public class Zebra extends Mammal{

    public Zebra(String animalName, Double weight, String livingRegion) {
        super(animalName, "Zebra", weight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
            return;
        } else {
            System.out.println("Zebras are not eating that type of food!");
        }
    }
}
