/**
 * the Lab class holds information of laboratory.
 * @author Mahdi hejrati
 * @version 1.0
 * @since 2020/3/8
 */
public class Lab {

    private Course course;
    private String TA;
    private String day;
    private Student[] students;
    private int currentSize;
    private int capacity;

    /**
     * create new lab with a given information.
     * @param TA teacher assistant of lab
     * @param day day that lab hold.
     * @param course the major class
     * @param capacity capacity of lab
     */
    public Lab(String TA, String day, Course course, int capacity){
        this.TA = TA;
        this.day = day;
        this.course = course;
        this.capacity = capacity;
        students = new Student[capacity];
        currentSize = 0;
    }

    /**
     * set teacher assistant
     * @param TA teacher assistant
     */
    public void setTA(String TA){
        this.TA = TA;
    }

    /**
     * get teacher assistant
     * @return teacher assistant
     */
    public String getTA(){
        return TA;
    }

    /**
     * set day that lab hold.
     * @param day week day
     */
    public void setDay(String day){
        this.day = day;
    }

    /**
     * get day that lab hold.
     * @return week day
     */
    public String getDay(){
        return day;
    }

    /**
     * set students of lab
     * @param students members of lab
     */
    public void setStudents(Student[] students){
        this.students = students;
    }

    /**
     * get students of lab
     * @return students
     */
    public Student[] getStudents(){
        return students;
    }

    /**
     * check if lab has capacity or not
     * @return 1 if has, and 0 if not
     */
    public boolean hasCapacity(){
        if (currentSize < capacity)
            return true;
        else
            return false;
    }

    /**
     * enroll student in lab if has capacity
     * @param student student that want to have this lab
     */
    public void enrollStudent(Student student){
        if (hasCapacity())
            students [currentSize] = student;
        else
            System.out.println("Lab is full");
    }

    /**
     * print information
     */
    public void print (){
//        System.out.println("Lab class:");
        System.out.println("day:" + day);
        System.out.println("TA:" + TA);

    }
}