/**
 * this class holds voter information
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.03.21
 */

public class Person {

    private String firstName;
    private String lastName;

    /**
     * constructor for this class
     * @param firstName first name of voter
     * @param lastName last name of voter
     */
    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * getter for first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getter for last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }
}