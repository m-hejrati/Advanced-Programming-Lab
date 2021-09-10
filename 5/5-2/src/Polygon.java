/**
 * this class save information of all shapes that have sides.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.04.10
 */

import java.util.ArrayList;

public abstract class Polygon extends Shape {

    protected ArrayList<Integer> sides;

    /**
     * constructor for polygon
     */
    public Polygon (int... args){
        sides = new ArrayList<>();
        for (int arg : args) {
            sides.add(arg);
        }
    }

    /**
     * getter for sidea
     * @return sides
     */
    public ArrayList<Integer> getSides(){
        return sides;
    }

    /**
     * convert information to list and return them
     * @return name and sides of polygon
     */
    @Override
    public String toString() {
        return "Polygon: sides = " + sides ;
    }

    /**
     * get two shape and check if they are equal or not
     * @param o shape to check
     * @return true if equal and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygon)) return false;

        Polygon polygon = (Polygon) o;

        return getSides().equals(polygon.getSides());
    }

    @Override
    public int hashCode() {
        return getSides().hashCode();
    }
}
