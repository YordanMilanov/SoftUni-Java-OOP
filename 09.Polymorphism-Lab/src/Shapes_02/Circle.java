package Shapes_02;

public class Circle extends Shape{

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }

    public final Double getRadius() {
        return radius;
    }
}