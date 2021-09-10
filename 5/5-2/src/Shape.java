/**
 * this is the parent class of polygon and circle
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.10
 */

public abstract class Shape {

    public abstract double calculatePerimeter();
    public abstract double calculateArea();
    public abstract void draw ();
    public abstract String toString ();
    public abstract boolean equals(Object object);
}
