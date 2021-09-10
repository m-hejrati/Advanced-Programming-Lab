/**
 * the professor class hold professor’s information.
 * @author Mahdi hejrati
 * @version 1.0
 * @since 2020/3/8
 */
public class Professor {

    private String firstName;
    private String lastName;
    private Course[] courses;
    private int currentSize;
    private int max;

    /**
     * Create a new prof. with a given name, last name.
     *
     * @param firstName professor’s first name
     * @param lastName  professor’s last name
     * @param max       maximum courses that professor can have.
     */
    public Professor(String firstName, String lastName, int max) {
        this.firstName = firstName;
        this.lastName = lastName;
        courses = new Course[max];
        this.max = max;
        currentSize = 0;
    }

    /**
     * get the student’s first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get the student’s last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * get the professor’s courses.
     *
     * @return courses
     */
    public Course[] getCourses() {
        return courses;
    }

    /**
     * set the professor’s courses.
     */
    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        if (currentSize < max) {
            courses[currentSize] = course;
            currentSize++;
        } else {
            System.out.println("professor cant not have more course");
        }
    }

    /**
     * print information
     */
    public void print() {
//        System.out.println("Professor class:");
        System.out.println("last name:" + lastName);
        for (int i = 0; i < currentSize; i++)
            courses[i].print();
    }
}