/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 *
 * @author Mahdi Hejrati
 * @version 1.0
 * @since 2020/3/7
 */
public class Student {

    // the student’s first name
    private String firstName;

    // the student’s last name
    private String lastName;

    // the student ID
    private String id;

    // the grade
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lName last name of student
     * @param sID   student ID
     */
    public Student(String fName, String lName, String sID) {
        firstName = fName;
        lastName = lName;
        id = sID;
        grade = 0;
    }

    /**
     * get the first name of student
     *
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param fName set first name of a student
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * @param sGrade set grade of a student
     */
    public void setGrade (int sGrade){
        grade = sGrade;
    }

    /**
     * Print the student’s last name and ID number to the output terminal.
     */
    public void print() {
        System.out.println(lastName + ", student ID: " + id + ", grade: " + grade);
    }
    /**
     * get the grade a student
     *
     * @return grade field
     */
    public int getGrade() {
        return grade;
    }
}
