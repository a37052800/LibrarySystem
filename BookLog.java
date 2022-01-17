import java.util.*;

public class BookLog {

    public BookLog() {
        borrowedList = new ArrayList<>();
    }

    private ArrayList<Integer> borrowedList;

    public void addLog(Book book) {
        borrowedList.add(book.getID());
    }

    public void removeLog(Book book) {
        borrowedList.remove(book.getID());
    }

    public ArrayList<Integer> getBorrowedList() {
        return borrowedList;
    }
}