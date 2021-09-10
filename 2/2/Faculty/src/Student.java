/**
 * the student class hold student’s information.
 * @author Mahdi hejrati
 * @version 1.0
 * @since 2020/3/8
 */
public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private int[] grades;
    private int average;
    private Course[] courses;
    private int currentSize;


    /**
     * Create a new student with a given name, last name and ID number.
     * @param fName student’s first name
     * @param lName student’s last name
     * @param sID   student ID
     * @param max maximum courses that this student can enroll
     */
    public Student(String fName, String lName, String sID, int max) {
        firstName = fName;
        lastName = lName;
        id = sID;
        grades = new int [max];
        grades [0] = 0;
        average = 0;
        courses = new Course[max];
        currentSize = 0;
    }

    /**
     * get the student’s first name
     * @return first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * get the student’s last name
     * @return last name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * get the student’s id
     * @return id
     */
    public String getId(){
        return id;
    }

    /**
     * get the student’s grades
     * @return grades
     */
    public int[] getGrades(){
        return grades;
    }

    /**
     * calculate the average of student’s grade
     */
    public void calculateAverage(){
        average = 0;
        int i;
        for (i = 0 ; i < currentSize; i++)
            average += grades[i];
        average = average / currentSize;
    }

    /**
     * get average of student’s grade
     * @return average
     */
    public int getAverage(){
        return average;
    }

    /**
     * print information
     */
    public void print (){
//        System.out.println("Student class:");
        System.out.println("last name:" + lastName);
        System.out.println("average:" + average);
    }
}
