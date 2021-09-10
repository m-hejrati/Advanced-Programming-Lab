/**
 * this class save all the shape.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.9
 */

import java.util.ArrayList;

public class Paint {
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    /**
     * constructor for paint
     */
    public Paint (){
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * get a circle and it to list
     * @param circle circle to add
     */
    public void addCircle (Circle circle) {
        circles.add(circle);
    }

    /**
     * get a triangle and add it to list
     * @param triangle triangle to add
     */
    public void addTriangle (Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * get a rectangle and it to list
     * @param rectangle rectangle to add
     */
    public void addRectangle (Rectangle rectangle){
        rectangles.add(rectangle);
    }

    /**
     * draw all the saved shapes.
     */
    public void drawAll (){
        for(Circle circle : circles)
            circle.draw();

        for (Triangle triangle : triangles)
            triangle.draw();

        for (Rectangle rectangle : rectangles)
            rectangle.draw();
    }

    /**
     * print all the saved shapes.
     */
    public void printAll (){
        for(Circle circle : circles)
            System.out.print(circle.toString());

        for (Triangle triangle : triangles)
            System.out.println(triangle.toString());

        for (Rectangle rectangle : rectangles)
            System.out.println(rectangle.toString());
    }
}