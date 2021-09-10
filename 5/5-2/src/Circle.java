/**
 * this class save information of a circle.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.10
 */

import static java.lang.Math.PI;

public class Circle extends Shape{

    private int radius;

    /**
     * constructor for circle
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * getter for radius
     * @return radius of circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * calculate perimeter of circle
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    /**
     * calculate area of circle
     * @return area
     */
    @Override
    public double calculateArea() {
        return PI * radius * radius;
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
     * convert information to list and return them
     * @return name and radius of circle
     */
    @Override
    public String toString() {
        return "Shape: " + this.getClass().getName() +
                "\t radius: " + radius;
    }

    /**
     * get two shape and check if they are equal or not
     * @param o shape to check
     * @return true if equal and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return getRadius() == circle.getRadius();
    }

    @Override
    public int hashCode() {
        return getRadius();
    }
}
