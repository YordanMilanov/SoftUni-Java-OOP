package WildFarm_03;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;
    private DecimalFormat df = new DecimalFormat("#.##");

    public Mammal(String animalName, String animalType, Double weight, String livingRegion) {
        super(animalName, animalType, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                df.format(getAnimalWeight()),
                livingRegion,
                getFoodEaten());
    }

    public DecimalFormat getDf() {
        return df;
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
