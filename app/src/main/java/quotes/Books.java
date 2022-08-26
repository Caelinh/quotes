package quotes;

import java.util.ArrayList;

public class Books {
    ArrayList<String>tags = new ArrayList<>();
    String author;
    String likes;
    String text;

    public Books(ArrayList<String> tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }
    public String toString(){
        return author + " - " + '\"' + text;
//        help from Ben
    }
}
