import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * main class test all other classes
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.03.21
 */

public class Main {
    public static void main(String[] args) {

        VotingSystem votingsystem = new VotingSystem();
        // make new voter
        Person voter1 = new Person("Mahdi", "Hejrati");
        Person voter2 = new Person("Abbas", "Moeini");
        Person voter3 = new Person("Reza", "Kalati");
        // make new voting
        ArrayList <String> options = new ArrayList<String>();
        options.add("yes");
        options.add("No");
        votingsystem.creatVoting("Do you come?", 0, options);
        // make new voting
        ArrayList <String> days = new ArrayList <String>();
        days.add("Today");
        days.add("Tomorrow");
        days.add("Saturday");
        votingsystem.creatVoting("Which day?",1, days);
        // make new voting
        ArrayList <String> courses = new ArrayList <String>();
        courses.add("BP");
        courses.add("AP");
        courses.add("DS");
        courses.add("DB");
        votingsystem.creatVoting("Which course?",1, courses);

        votingsystem.printVotingQuestions();

        votingsystem.printVoting(0);
        ArrayList<String> votes1 = new ArrayList<String> ();
        votes1.add("No");
        // random vote
        Random rnd = new Random();
        ArrayList<String> votes5 = new ArrayList<String> ();
        int rand = rnd.nextInt(votingsystem.votingList.get(0).getChoices().size());
        String randString = votingsystem.votingList.get(0).getChoices().get(rand);
        votes5.add(randString);
        // submit votes
        votingsystem.vote(0, voter1, votes1);
        votingsystem.vote(0, voter2, votes5);
        votingsystem.vote(0, voter3, votes5);
        // show result of first voting
        votingsystem.printResult(0);


        votingsystem.printVoting(1);

        ArrayList<String> votes2 = new ArrayList<String> ();
        votes2.add("Today");
        votes2.add("Tomorrow");

        ArrayList<String> votes3 = new ArrayList<String>();
        votes3.add("Tomorrow");

        votingsystem.vote(1, voter1, votes3);
        votingsystem.vote(1, voter2, votes2);
        votingsystem.vote(1, voter3, votes2);
        votingsystem.vote(0, voter3, votes3);
        votingsystem.vote(1, voter1, votes3);

        votingsystem.printResult(1);
        
    }
}