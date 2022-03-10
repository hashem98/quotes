package quotes;

public class Quotes {
    public int length;
    String author;
    String text;

    public Quotes(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String toString(){

        return String.format("Author: %s, Quote: %s",
                author,
                text);
    }
}
