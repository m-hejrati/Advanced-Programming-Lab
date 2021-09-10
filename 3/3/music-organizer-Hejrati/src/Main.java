/**
 * Main class for run and test the other classes.
 *
 * @author Mahdi Hejrati 9723100
 * @version 2020.03.14
 */
public class Main {
    public static void main(String[] args) {

        // favourite musics list like other collection
        MusicCollection favourites = new MusicCollection();

        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();

        Music m1 = new Music("Ashoobam", "Chaartaar", 90);
        Music m2 = new Music("Nafas", "Reza Sadeghi", 96);
        Music m3 = new Music("Nafas", "Ali Abbasi", 95);
        Music m4 = new Music("Divane", "Reza Bahram", 97);

        pop.addFile(m1);
        pop.addFile(m2);
        pop.addFile(m3);
        pop.addFile(m4);

        pop.listAllFiles();

        pop.search("Nafas");

        pop.removeFile(2);
        pop.listAllFiles();

        pop.search("Nafas");

        favourites.addFile(m1);
        favourites.addFile(m2);

        pop.startPlaying(1);
        pop.stopPlaying();

    }
}
