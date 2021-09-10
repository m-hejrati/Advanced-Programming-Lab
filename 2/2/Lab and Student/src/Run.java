import java.util.ArrayList;

public class Run {

    public static void main(String[] args) {
        Student std1 = new Student("Ehsan","Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Mahdi", "Hejrati", "9723100");

//        std1.print();
        std1.setGrade(19);
        //       std1.print();

//        std2.print();
        std2.setGrade(15);
//        std2.print();

//        std3.print();
        std3.setGrade(18);
//        std3.print();


        Lab l1 = new Lab(20, "saturday");
        l1.enrollStudent(std1);
        l1.enrollStudent(std2);
        l1.enrollStudent(std3);

        l1.print();
    }
}