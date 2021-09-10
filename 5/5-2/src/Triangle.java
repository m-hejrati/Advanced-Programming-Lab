/**
 * this class save information of a triangle.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.10
 */

import static java.lang.Math.sqrt;

public class Triangle extends Polygon {

    /**
     * constructor for triangle
     */
    public Triangle(int... args) {
        super(args);
    }

    /**
     * calculate perimeter of triangle
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    /**
     * calculate area of triangle
     * @return area
     */
    @Override
    public double calculateArea() {
        double perimeter = calculatePerimeter();
        double area2 = perimeter * (perimeter - sides.get(0)) * (perimeter - sides.get(1)) * (perimeter - sides.get(2));
        return sqrt(area2);
    }

    /**
     * print name of the shape, perimeter and area
     */
    @Override
    public void draw() {
        System.out.println("Shape: " + this.getClass().getName() +
                "\t Perimeter: " + calculatePerimeter() +
                "\t Area: " + calculateArea());
    }

    /**
     * check if the triangle is equilateral or not
     * @return true if it is Equilateral or false if not
     */
    public boolean isEquilateral() {
        if (sides.get(0).equals(sides.get(1)))
            return sides.get(1).equals(sides.get(2));
        return false;
    }
}
