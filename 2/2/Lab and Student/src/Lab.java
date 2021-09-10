/**
 * The Lab class represents a Laboratory.
 * It holds the information of a Laboratory.
 *
 * @author Mahdi Hejrati
 * @version 1.0
 * @since 2020/3/8
 */
public class Lab {

    // the students’ information.
    private Student[] students;

    // the average of the students grade.
    private int avg;

    // the day that lab hold.
    private String day;

    // the capacity of Lab
    private int capacity;

    // the number of enrolled students.
    private int currentSize;

    /**
     * Create a new laboratory with a given capacity and day that it hold.
     *
     * @param cap capacity of lab
     * @param d day that lab hold.
     */
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
        currentSize = 0;
        avg = 0;
        students = new Student[capacity];
    }

    /**
     * add student into lab
     *
     * @param std student that enroll in lab
     */
    public void enrollStudent (Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize ++;
        } else {
            System.out.println("Lab is full");
        }
    }

    /**
     * Print the students’ information and the grade average to the output terminal.
     */
    public void print() {
        System.out.println();
        System.out.println("Lab info:");
        for (int i = 0; i < currentSize; i++)
            students[i].print();
        System.out.println("the average grade of students is:" + getAvg());
    }

    /**
     * get the student’s information.
     *
     * @return students field
     */
    public Student[] getStudents() {
        return students;
    }

    /**set the student’s information.
     *
     * @param students field
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * get average
     *
     * @return avg average
     */
    public int getAvg() {
        calculateAvg();
        return avg;
    }

    /**
     * calculate average grade of students in lab
     *
     */
    public void calculateAvg() {
        avg = 0;
        for (int i = 0; i < currentSize; i++)
            avg += students[i].getGrade();
        avg = avg / currentSize;
    }

    /**
     * get day in which class hold
     *
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day set day in which class hold
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * get capacity of lab
     *
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param cap set capacity of lab
     */
    public void setCapacity(int cap) {
        capacity = cap;
    }
}