package WildFarm_03;

public class Mouse extends Mammal{
    public Mouse(String animalName, Double weight, String livingRegion) {
        super(animalName, "Mouse", weight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
            return;
        } else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
}
