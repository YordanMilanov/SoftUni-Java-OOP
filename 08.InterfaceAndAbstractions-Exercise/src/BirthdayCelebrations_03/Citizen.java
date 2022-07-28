package BirthdayCelebrations_03;

public class Citizen implements Person, Birthable, Identifiable {

    private String name;
    private int age;
    private String Id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        Id = id;
        this.birthDate = birthDate;
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
}
