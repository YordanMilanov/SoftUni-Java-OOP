package WildFarm_03;

import java.text.DecimalFormat;

public class Cat extends Feline{
    private String bread;

    public Cat(String animalName, Double weight, String livingRegion, String bread) {
        super(animalName, "Cat", weight, livingRegion);
        this.bread = bread;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        setFoodEaten(getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                bread,
                getDf().format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }
}
