package Animals_03;

public class Dog extends Animal{
    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return  String.format("%n%s DJAAF",super.explainSelf());
    }
}
