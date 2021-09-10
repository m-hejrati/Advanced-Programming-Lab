import java.util.SimpleTimeZone;

/**
 * A class to hold information of each music.
 *
 * @author Mahdi Hejrati
 * @version 2020.03.14
 */
public class Music {
    private String name;
    private String singer;
    private int year;

    /**
     * creat a music with given data
     * @param name name of music
     * @param singer singer of music
     * @param year year that it made
     */
    public Music (String name, String singer, int year) {
        this.name = name;
        this.singer = singer;
        this.year = year;
    }

    /**
     * get name of music
     * @return name
     */
    public String getName () {
        return name;
    }

    /**
     * get singer of music
     * @return singer name
     */
    public String getSingerName () {
        return singer;
    }

}
