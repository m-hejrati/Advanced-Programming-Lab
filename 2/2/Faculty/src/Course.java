/**
 * the course class holds information of course
 * @author Mahdi hejrati
 * @version 1.0
 * @since 2020/3/8
 */
public class Course {

    private String name;
    private Professor professor;
    private Student[] students;
    private Lab[] labs;
    private int maxCapacity;
    private int currentCapacity;
    private int currentCapacityLab;

    /**
     * creat new course with given information.
     * @param name name of course
     * @param professor professor of course
     * @param maxCapacity
     */
    public Course(String name, Professor professor, int maxCapacity){
        this.name = name;
        this.professor = professor;
        this.maxCapacity = maxCapacity;
        currentCapacity = 0;
        currentCapacityLab = 0;
        students = new Student[maxCapacity];
        labs = new Lab[maxCapacity];
    }

    /**
     * set name
     * @param name name of course
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * get name
     * @return name of course
     */
    public String getName(){
        return name;
    }

    /**
     * set professor
     * @param professor professor
     */
    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    /**
     * get professor
     * @return professor
     */
    public Professor getProfessor(){
        return professor;
    }

    /**
     * set members of course
     * @param students members of course
     */
    public void setStudents(Student[] students){
        this.students = students;
    }

    /**
     * get members of course
     * @return members of course
     */
    public Student[] getStudents(){
        return students;
    }

    /**
     * get numbers of student in lab
     * @return numbers of student in lab
     */
    public int getCurrentCapacity(){
        return currentCapacity;
    }

    /**
     * get related lab to course
     * @return lab
     */
    public Lab[] getLabs(){
        return labs;
    }

    /**
     * add available lab to course
     * @param lab related lab
     */
    public void addLab(Lab lab){
        labs[currentCapacityLab] = lab;
        currentCapacityLab ++;
    }

    /**
     * add student to the course and first lab that have capacity
     * @param student student
     */
    public void enrollStudent(Student student){
        if (currentCapacity < maxCapacity){
            students [currentCapacity] = student;
            for (int i = 0; i < currentCapacityLab; i++)
                if (labs[i].hasCapacity())
                    labs[i].enrollStudent(student);
        } else
            System.out.println("Class is full");
    }

    /**
     * print information
     */
    public void print (){
//        System.out.println("Corse class:");
        System.out.println("name:" + name);
        for (int i = 0; i < currentCapacity; i++)
            System.out.println("students:" + students[i]);
    }
}