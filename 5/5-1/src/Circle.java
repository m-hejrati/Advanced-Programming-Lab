/**
 * this class save information of a circle.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.9
 */

import static java.lang.Math.PI;

public class Circle {

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
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    /**
     * calculate area of circle
     * @return area
     */
    public double calculateArea() {
        return PI * radius * radius;
    }

    /**
     * print name of the shape, perimeter and area
     */
    public void draw() {
        System.out.println("Shape: " + this.getClass().getName() +
                "\t Perimeter: " + calculatePerimeter() +
                "\t Area: " + calculateArea());
    }

    /**
     * get two circle and check if they are equal or not
     * @param circle circle to check
     * @return true if equal and false if not
     */
    public boolean equals(Circle circle) {
        return radius == circle.getRadius();
    }

    /**
     * convert information to list and return them
     * @return name and radius of circle
     */
    public String toString() {
        return "Shape: " + this.getClass().getName() +
                "\t radius: " + radius;
    }
}