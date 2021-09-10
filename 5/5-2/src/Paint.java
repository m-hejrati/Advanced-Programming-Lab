/**
 * this class save all the shape.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.10
 */

import java.util.ArrayList;

public class Paint {

    ArrayList<Shape> shapes;

    /**
     * constructor for paint
     */
    public Paint() {
        shapes = new ArrayList<>();
    }

    /**
     * get a shape and it to list
     * @param shape circle to add
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * iterate all the list and print shapes that have equal sides
     */
    public void describeEqualSides() {
        System.out.println("Equal sides:");
        for (Shape shape : shapes)
            if (shape instanceof Triangle) {
                Triangle tr = (Triangle) shape;
                if (tr.isEquilateral())
                    System.out.println(shape.toString());
            } else if (shape instanceof Rectangle) {
                Rectangle rec = (Rectangle) shape;
                if (((Rectangle) shape).isSquare())
                    System.out.println(shape.toString());
            }
    }

    /**
     * draw all the saved shapes.
     */
    public void drawAll() {
        for (Shape shape : shapes)
            shape.draw();
    }

    /**
     * print all the saved shapes.
     */
    public void printAll() {
        for (Shape shape : shapes)
            System.out.println(shape.toString());
    }
}
