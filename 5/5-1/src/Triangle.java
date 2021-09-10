/**
 * this class save information of a triangle.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.9
 */

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.Math.sqrt;

public class Triangle {

    private ArrayList<Integer> sides;

    /**
     * constructor for triangle
     */
    public Triangle(int firstSide, int secondSide, int thirdSide) {
        sides = new ArrayList<>();
        sides.add(firstSide);
        sides.add(secondSide);
        sides.add(thirdSide);
    }

    /**
     * getter for sides
     * @return sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
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

    /**
     * calculate perimeter of triangle
     * @return perimeter
     */
    public double calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    /**
     * calculate area of triangle
     * @return area
     */
    public double calculateArea() {
        double perimeter = calculatePerimeter();
        double area2 = perimeter * (perimeter - sides.get(0)) * (perimeter - sides.get(1)) * (perimeter - sides.get(2));
        return sqrt(area2);
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
     * get two triangle and check if they are equal or not
     * @param triangle triangle to check
     * @return true if equal and false if not
     */
    public boolean equals(Triangle triangle) {
        Collections.sort(sides);
        Collections.sort(triangle.sides);
        for (int i = 0; i < 3; i++) {
            if (!triangle.sides.get(i).equals(sides.get(i)))
                return false;
        }
        return true;
    }

    /**
     * convert information to list and return them
     * @return name and sides of triangle
     */
    public String toString() {
        return "Shape: " + this.getClass().getName() +
                "\t sides: " + sides;
    }
}