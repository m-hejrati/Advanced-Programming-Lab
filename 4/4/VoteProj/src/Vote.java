/**
 * this class holds information of vote
 *
 * @author Mahdi Hejrati 9723100
 * @since 2020.03.21
 */

public class Vote {

    private Person person;
    private String date;

    /**
     * constructor for this class
     * @param person person who vote
     * @param date date in which he vote
     */
    public Vote (Person person, String date){
        this.person = person;
        this.date = date;
    }

    /**
     * getter for person
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * getter for date
     * @return date
     */
    public String getDate() {
        return date;
    }

    // equals and hashCode method for checking voter that should be different

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;

        Vote vote = (Vote) o;

        if (!getPerson().equals(vote.getPerson())) return false;
        return getDate().equals(vote.getDate());
    }

    @Override
    public int hashCode() {
        int result = getPerson().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }

}