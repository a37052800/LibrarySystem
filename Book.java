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

    public void show() {
        System.out.printf("ID: %d Author: %s Subject: %s\n", ID, author, subject);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void borrowBook(User user) {
        isBorrow = true;
        borrowerName = user.getName();
    }

    public void returnBook() {
        isBorrow = false;
        borrowerName = "";
    }

    public boolean isBorrow() {
        return isBorrow;
    }

}