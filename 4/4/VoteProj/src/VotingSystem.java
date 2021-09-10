import java.util.ArrayList;

/**
 * this class control all the program and it makes voting.
 *
 * @author Mahdi hejrati 9723100
 * @since 2020.03.21
 */

public class VotingSystem {
    public ArrayList<Voting> votingList;

    /**
     * constructor for Voting system
     */
    public VotingSystem() {
    votingList = new ArrayList<Voting>();
    }

    /**
     * creat a new voting with given information
     * @param question question of vote
     * @param type type of voting
     * @param choices choices of voting
     */
    public void creatVoting (String question, int type, ArrayList<String> choices) {
        votingList.add(new Voting(type, question, choices));
    }

    /**
     * print questions of voting
     */
    public void printVotingQuestions(){
        for (int i = 0 ; i < votingList.size() ; i++)
            System.out.println(i + ": " + votingList.get(i).getQuestion());
    }

    /**
     * get an index and print its questions and answers
     * @param index index of voting in list
     */
    public void printVoting (int index){
        System.out.println();
        System.out.println(votingList.get(index).getQuestion());
        for (String choice : votingList.get(index).getChoices())
            System.out.println(choice);
    }

    /**
     * get information and submit a vote
     * @param index index of voting in list
     * @param voter the person who vote
     * @param votes his vote
     */
    public void vote (int index, Person voter, ArrayList<String> votes) {
        votingList.get(index).vote(voter,votes);
    }

    /**
     * get index and print its result
     * @param index index of voting in list
     */
    public void printResult(int index) {
        votingList.get(index).printVotes();
    }
}