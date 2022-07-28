package Animals_06;

public class Kitten extends Cat{
    //kittens are female

    public Kitten(String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound () {
        return "Meow";
    }
}