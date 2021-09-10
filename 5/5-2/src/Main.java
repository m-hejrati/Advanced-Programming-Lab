/**
 * this class test all other classes and methods.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.10
 */

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(19);
        Circle circle2 = new Circle(3);

        Rectangle rect1 = new Rectangle(1, 4);
        Rectangle rect2 = new Rectangle(8, 5);
        Rectangle rect3 = new Rectangle(4, 1);

        Triangle tri1 = new Triangle(2, 2, 2);
        Triangle tri2 = new Triangle(4, 4, 6);

        Paint paint = new Paint();

        paint.addShape(circle1);
        paint.addShape(circle2);

        paint.addShape(rect1);
        paint.addShape(rect2);
        paint.addShape(rect3);

        paint.addShape(tri1);
        paint.addShape(tri2);

        paint.drawAll();
        paint.printAll();

        System.out.println();

        // show all the shapes that have equal sides
        paint.describeEqualSides();

        System.out.println();

        System.out.println("Is equal: " + circle1.equals(circle2));
        System.out.println("Is equal: " + rect1.equals(rect3));
        System.out.println("Is equal: " + tri1.equals(tri2));

        System.out.println();

        System.out.println("Is equilateral: " + tri1.isEquilateral());
        System.out.println("Is Square: " + rect1.isSquare());

    }
}