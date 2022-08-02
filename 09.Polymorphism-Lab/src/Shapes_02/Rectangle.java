package Shapes_02;

public class Rectangle extends Shape{

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * this.height + 2 * this.width;
    }

    @Override
    public Double calculateArea() {
        return this.height * this.width;
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }
}
