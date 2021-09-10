import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/***
 * this class is modeling a voting.
 * it consist of a question and some choices and it keeps votes.
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.03.21
 */
public class Voting {

    // this field holds type of voting. 0 for single and 1 for multi choice.
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap <String, HashSet <Vote>> listOfVotesToChoices;

    /**
     * getter for voting
     * @param type type of voting
     * @param question question of vote
     */
    public Voting(int type, String question, ArrayList<String> choices) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        listOfVotesToChoices = new HashMap<String, HashSet<Vote>>();
        for (String choice : choices)
            creatChoice(choice);
    }

    /**
     * getter for question
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Add choice to choice list
     * @param choiceToAdd choice
     */
    public void creatChoice (String choiceToAdd){
        listOfVotesToChoices.put(choiceToAdd, new HashSet<Vote>());
    }

    /**
     * get voter and his vote and submit it
     * @param voter voter
     * @param votes hid vote
     */
    public void vote (Person voter, ArrayList<String> votes) {
        voters.add(voter);
        int sumOfAllVotesBefore = 0;
        for (String vote : votes)
            for (String savedVote : listOfVotesToChoices.keySet()) {
                sumOfAllVotesBefore += listOfVotesToChoices.get(savedVote).size();
                if (vote.equals(savedVote))
                    listOfVotesToChoices.get(savedVote).add(new Vote(voter, new JalaliCalendar().toString()));
            }

        sumOfAllVotesBefore /= votes.size();
        int sumOfAllVotesAfter = 0;
        for (String savedVote : listOfVotesToChoices.keySet()) {
            sumOfAllVotesAfter += listOfVotesToChoices.get(savedVote).size();
        }
        // check if this vote accepted or not
        if (sumOfAllVotesBefore == sumOfAllVotesAfter)
            System.out.println("You have voted before or your vote is not correct");
        else
            System.out.println("Vote submitted");
    }

    /**
     * print voters
     */
    public void getVoters(){
        for (Person voter : voters)
            System.out.println(voter.getFirstName() + voter.getLastName());
    }

    /**
     * print the result of voting
     */
    public void printVotes () {
        System.out.println();
        System.out.println("Result: ");
        for (String result : listOfVotesToChoices.keySet()) {
            System.out.println(result + " -> " + listOfVotesToChoices.get(result).size());
            if (!listOfVotesToChoices.get(result).isEmpty())
                for (Vote vote : listOfVotesToChoices.get(result))
                    System.out.println(vote.getPerson().getFirstName() + " " + vote.getPerson().getLastName() + " | " + vote.getDate());
        }
    }

    /**
     * get choices of a voting
     * @return choices
     */
    public ArrayList<String> getChoices (){
        ArrayList <String> choices = new ArrayList<String>();
        for (String choice : listOfVotesToChoices.keySet())
            choices.add(choice);
        return choices;
    }
}