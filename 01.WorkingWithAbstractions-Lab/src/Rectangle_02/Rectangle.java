package Rectangle_02;

public class Rectangle {

    Point bottomLeft;
    Point topRight;

    //  private int xBottomleft;
    //  private int yBottomleft;
    //  private int xTopleft;
    //  private int yTopleft;
    // За да не пишем координатите два пъти можем просто да използваме класа Point


    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean containsOnX = point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
        boolean containsOnY = point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
       // if (containsOnX && containsOnY) {
       //     return true;
       // } else {
       //     return false;
       // }
        // тази проврека можем да я направим директно в return-a
        return containsOnX && containsOnY;
    }
}
