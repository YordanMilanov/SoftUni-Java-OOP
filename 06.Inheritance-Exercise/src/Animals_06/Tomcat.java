package Animals_06;

public class Tomcat extends Cat{
    //Tomcats are male

    public Tomcat(String name, int age) {
        super(name, age, "Male");
    }

    @Override
    public String produceSound () {
        return "MEOW";
    }
}
