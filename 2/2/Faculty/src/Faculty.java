/**
 * the faculty class holds all information about faculty
 * @author Mahdi hejrati
 * @version 1.0
 * @since 2020/3/8
 */
public class Faculty {

    private String name;
    private Professor[] professors;
    private Student[] students;
    private Course[] courses;
    private int profNum;
    private int stuNum;
    private int courseNum;
    private int max;

    /**
     * crate the faculty with given name.
     * @param name name of faculty
     */
    public Faculty (String name){
        this.name = name;
        max = 1000;
        professors = new Professor[max];
        students = new Student[max];
        courses = new Course[max];
        profNum = 0;
        stuNum = 0;
        courseNum = 0;
    }

    /**
     * get name
     * @return name of faculty
     */
    public String getName(){
        return name;
    }

    /**
     * set students
     * @param students students of faculty
     */
    public void setStudents(Student[] students){
        this.students = students;
    }

    /**
     * get students
     * @return students of faculty
     */
    public Student[] getStudents(){
        return students;
    }

    /**
     * set courses
     * @param courses courses in faculty
     */
    public void setCourses(Course[] courses){
        this.courses = courses;
    }

    /**
     * set professors
     * @param professors professors in faculty
     */
    public void setProfessors(Professor[] professors){
        this.professors = professors;
    }

    /**
     * get professors
     * @return professors in faculty
     */
    public Professor[] getProfessors(){
        return professors;
    }

    /**
     * get courses
     * @return courses in courses in faculty
     */
    public Course[] getCourses(){
        return courses;
    }

    /**
     * add student to faculty
     * @param student student
     */
    public void enrollStudent(Student student){
        students[stuNum] = student;
        stuNum++;
    }

    /**
     * add course to faculty
     * @param course course
     */
    public void addCourse(Course course){
        courses[courseNum] = course;
        courseNum++;
    }

    /**
     * add professor to faculty
     * @param professor professor
     */
    public void addProfessor(Professor professor){
        professors[profNum] = professor;
    }

    /**
     * check if an special student is in faculty or not.
     * @param student student that want to check.
     * @return true if he is, and false if he is not.
     */
    public boolean isStudentValid(Student student){
        for (int i = 0; i < stuNum; i++)
            if (students[i] == student)
                return true;
        return false;
    }

    /**
     * check if an special course is in faculty or not.
     * @param course student that want to check.
     * @return true if it is, and false if it is not.
     */
    public boolean isCourseValid(Course course){
        for (int i = 0; i < courseNum; i++)
            if (courses[i] == course)
                return true;
        return false;
    }

    /**
     * check if an special course is in faculty or not.
     * @param professor student that want to check.
     * @return true if it is, and false if it is not.
     */
    public boolean isProfessorValid(Professor professor){
        for (int i = 0; i < profNum; i++)
            if (professors[i] == professor)
                return true;
        return false;
    }

    /**
     * print information
     */
    public void print (){
        System.out.println("Faculty class");
        System.out.println("name:" + name);
        for (int i = 0; i < stuNum; i++)
            students[i].print();
        for (int i = 0; i < profNum; i++)
            professors[i].print();
        for (int i = 0; i < courseNum; i++)
            courses[i].print();
    }
}