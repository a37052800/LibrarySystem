import java.util.*;

public class Book {

    public Book(String author, String subject) {
        this.ID = 0;
        this.author = author;
        this.subject = subject;
        this.isBorrow = false;
        this.borrowerName = null;
    }

    private int ID;

    private String author;

    private String subject;

    private boolean isBorrow;

    private String borrowerName;

    public String show() {
        return "";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}