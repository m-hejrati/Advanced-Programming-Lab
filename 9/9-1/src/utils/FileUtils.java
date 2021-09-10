package utils;

import java.io.*;

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


    /**
     * read information from file with buffer
     *
     * @param file address of file to read
     * @return read text
     */
    public static String fileReader(File file) {
        //TODO: Phase1: read content from file

        String readText = "";

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            int count;
            char[] buffer = new char[2048];

            while (bufferedReader.ready()){
                count = bufferedReader.read(buffer);
                readText += new String(buffer, 0, count);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error in opening file");
        } catch (IOException e) {
            System.err.println("Error in reading file");
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Error in closing file");
            }
        }

        return readText;
    }

    /**
     * write information to file with buffer
     *
     * @param content to read in file
     */
    public static void fileWriter(String content) {
        //TODO: write content on file

        String fileName = getProperFileName(content);

        BufferedWriter bufferedWriter = null;
        try {
            String completeFileName = "./notes/" + fileName + ".txt";
            bufferedWriter = new BufferedWriter(new FileWriter(completeFileName));
            bufferedWriter.write(content);
            bufferedWriter.flush();

        } catch (IOException e) {
            System.err.println("Error in writing in file");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.err.println("Error in closing file");
                }
            }
        }
    }


    /**
     * reading file with input stream
     *
     * @param file address of file to read
     * @return read text
     */
    /*
    public static String  fileReader(File file) {
        //TODO: Phase1: define method here for reading file with InputStream

        String readText = "";

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int c;
            while ((c = fileInputStream.read()) != -1) {
                readText += (char) c;
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error in opening file");
        } catch (IOException e) {
            System.err.println("Error in reading file");

        } finally {
            try {
                if(fileInputStream != null)
                fileInputStream.close();
            } catch (IOException e) {
                System.err.println("Error in closing file");
            }
        }

        return readText;
    }
     */

    /**
     * write information to file with output stream
     *
     * @param content to read in file
     */
    /*
    public static void fileWriter(String content) {
        //TODO: Phase1: define method here for writing file with OutputStream

        String fileName = getProperFileName(content);
        String completeFileName = "./notes/" + fileName + ".txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(completeFileName)) {

            byte[] txt = content.getBytes();
            fileOutputStream.write(txt);

        } catch (IOException e) {
            System.err.println("Error in writing to file");
        }
    }
    */

    //TODO: Phase2: proper methods for handling serialization

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
