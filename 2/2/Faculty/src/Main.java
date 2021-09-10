/**
 * main class just to test the other classes.
 * @author Mahdi hejrati
 * @version 1.0
 * @since 2020/3/8
 */

public class Main {
    public static void main(String[] args) {

        Faculty f1 = new Faculty("CE");

        Student st1 = new Student("Mahdi", "Hejrati", "9723100", 10);
        Student st2 = new Student("Amin", "Hejrati", "9523123", 10);
        Student st3 = new Student("Sattar", "Noee", "9731067", 10);

        Professor p1 = new Professor("Ehsan", "Edalat", 10);
        Professor p2 = new Professor("Parham", "Alvani", 10);

        Course c1 = new Course("AP", p1, 60);
        Course c2 = new Course("BP", p2, 60);

        Lab l1 = new Lab("Hoseini", "Saturday", c1, 20);
        Lab l2 = new Lab("Adib", "Monday", c1 , 20);
        Lab l3 = new Lab("Zameni", "Monday", c2 , 20);

        f1.enrollStudent(st1);
        f1.enrollStudent(st2);
        f1.enrollStudent(st3);

        f1.addCourse(c1);
        f1.addCourse(c2);

        f1.addProfessor(p1);
        f1.addProfessor(p2);

        c1.addLab(l1);
        c1.addLab(l2);
        c2.addLab(l3);

        c1.enrollStudent(st1);
        c1.enrollStudent(st2);
        c2.enrollStudent(st3);

        l1.enrollStudent(st1);
        l1.enrollStudent(st1);
        l2.enrollStudent(st2);

        p1.addCourse(c1);
        p2.addCourse(c2);

        f1.print();
        System.out.println();
        c1.print();
        System.out.println();
        c2.print();
        System.out.println();
        l1.print();
        System.out.println();
        l2.print();
        System.out.println();
        l3.print();
        System.out.println();
        p1.print();
        System.out.println();
        p2.print();
    }

}
