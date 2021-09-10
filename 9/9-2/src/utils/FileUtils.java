package utils;

import model.Note;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }

/*
    public static String fileReader(File file) {
        //TODO: Phase1: read content from file
        return "";
    }

    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);
    }

    //TODO: Phase1: define method here for reading file with InputStream
    //TODO: Phase1: define method here for writing file with OutputStream
*/

    //TODO: Phase2: proper methods for handling serialization

    /**
     * read information of file with serialization
     *
     * @param file file to read
     * @return read string
     */
    public static String fileReader(File file) {

        Note note = null;
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            note = (Note) objectInputStream.readObject();

        } catch (Exception e) {
            System.err.println("Error in reading from file");
        }

        return note.toString();
    }

    /**
     * read information of file with serialization
     *
     * @param content content to write
     */
    public static void fileWriter(String content) {
        //TODO: write content on file
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(); // get date of system
        String date = dtf.format(now);

        String fileName = getProperFileName(content);
        String completeFileName = "./notes/" + fileName + ".txt";

        try(FileOutputStream fileOutputStream = new FileOutputStream(completeFileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(new Note(fileName, content,date));

        } catch (Exception e) {
            System.err.println("Error in writing into file");
        }
    }

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
