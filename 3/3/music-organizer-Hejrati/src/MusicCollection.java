import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael K�lling
 *
 * editted by Mahdi Hejrati 9723100
 * 2020.03.14
 *
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection() {
        files = new ArrayList<Music>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param name The music to be added.
     */
    public void addFile(Music name) {
        files.add(name);
        System.out.println(name.getName() + " added to list");
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        System.out.println("Name of the music that you entered its index:");
        if (validIndex(index))
            System.out.println(files.get(index).getName());
        else
            System.out.println("The entered index is invalid");
        System.out.println();
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles() {
        System.out.println();
        System.out.println("List of all music in the collection:");
        for (int i = 0; i < files.size(); i++)
            System.out.println(i+1 + ". " + files.get(i).getName() + " , " + files.get(i).getSingerName());
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        if (! validIndex(index))
            System.out.println("The entered index is invalid");

        int i = 0;
        Iterator <Music> it = files.iterator();
        while(it.hasNext()) {
            it.next();
            if (i == index)
                it.remove();
            i++;
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index) {
//            if (! validIndex(index))
//                System.out.println("The entered index is invalid");
//            else
                player.startPlaying(files.get(index).getName());

    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        player.stop();
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
      if (index < 0)
          return false;
      else if (index >= files.size())
          return false;
      return true;
    }

    /**
     * A method that get a string and check if there is any music or singer with this name or not
     *
     * @param name string that we want to search it.
     */
    public void search (String name) {
        System.out.println();
        System.out.println("Result of search in the collection:");
        boolean counter = false;
        for (Music el: files){
            if (el.getSingerName() == name || el.getName() == name) {
                System.out.println(el.getName() + " , " + el.getSingerName());
                counter = true;
            }
        }
        if (!counter)
            System.out.println("There is no music or singer with this name");
    }
}