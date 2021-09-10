/**
 * this class save information of a rectangle.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.9
 */

import java.util.ArrayList;
import java.util.Collections;

public class Rectangle {
    private ArrayList<Integer> sides;

    /**
     * constructor for rectangle
     */
    public Rectangle(int firstSide, int secondSide) {
        sides = new ArrayList<>();
        sides.add(firstSide);
        sides.add(secondSide);
    }

    /**
     * getter for sides
     * @return sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * check if the rectangle is square or not
     * @return true if it is Equilateral or false if not
     */
    public boolean isSquare (){
        return (sides.get(0).equals(sides.get(1)));
    }

    /**
     * calculate perimeter of rectangle
     * @return perimeter
     */
    public double calculatePerimeter(){
        return 2 * (sides.get(0) + sides.get(1));
    }

    /**
     * calculate area of rectangle
     * @return area
     */
    public double calculateArea(){
        return sides.get(0) * sides.get(1);
    }

    /**
     * print name of the shape, perimeter and area
     */
    public void draw (){
        System.out.println("Shape: " + this.getClass().getName() +
                "\t Perimeter: " + calculatePerimeter() +
                "\t Area: " + calculateArea());
    }

    /**
     * get two rectangle and check if they are equal or not
     * @param rectangle triangle to check
     * @return true if equal and false if not
     */
    public boolean equals(Rectangle rectangle) {
        Collections.sort(sides);
        Collections.sort(rectangle.sides);
        for (int i = 0; i < 2; i++) {
            if (!rectangle.sides.get(i).equals(sides.get(i)))
                return false;
        }
        return true;
    }

    /**
     * convert information to list and return them
     * @return name and sides of rectangle
     */
    public String toString() {
        return "Shape: " + this.getClass().getName() +
                "\tsides: " + sides;
    }

}
