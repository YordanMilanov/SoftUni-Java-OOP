package WildFarm_03;

public class Tiger extends Feline{


    public Tiger(String animalName, Double weight, String livingRegion) {
        super(animalName,"Tiger", weight, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
            return;
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }
}
