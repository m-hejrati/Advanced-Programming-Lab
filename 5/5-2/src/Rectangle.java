/**
 * this class save information of a rectangle.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.10
 */

public class Rectangle extends Polygon {

    /**
     * constructor for rectangle
     */
    public Rectangle(int... args) {
        super(args);
    }

    /**
     * calculate perimeter of rectangle
     * @return perimeter
     */
    @Override
    public double calculatePerimeter(){
        return 2 * (sides.get(0) + sides.get(1));
    }


    /**
     * calculate area of rectangle
     * @return area
     */
    @Override
    public double calculateArea(){
        return sides.get(0) * sides.get(1);
    }

    /**
     * print name of the shape, perimeter and area
     */
    @Override
    public void draw (){
        System.out.println("Shape: " + this.getClass().getName() +
                "\t Perimeter: " + calculatePerimeter() +
                "\t Area: " + calculateArea());
    }

    /**
     * check if the rectangle is square or not
     * @return true if it is Equilateral or false if not
     */
    public boolean isSquare (){
        return (sides.get(0).equals(sides.get(1)));
    }
}
