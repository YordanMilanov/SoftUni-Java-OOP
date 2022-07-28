package FoodShortage_04;

public class Citizen implements Person, Birthable, Identifiable, Buyer {

    private String name;
    private int age;
    private String Id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.Id = id;
        this.birthDate = birthDate;
        this.food = 0;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public String getId() {
        return Id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }


}
