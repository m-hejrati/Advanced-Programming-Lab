package model;

import java.io.Serializable;

// TODO: Phase2: uncomment this code
public class Note implements Serializable {

    private String title;
    private String content;
    private String date;

    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Title: '" + title + '\'' +
                "\n\nContent : \n" + content +
                "\nDate: '" + date + '\'';
    }

}

