import java.util.*;

public class BookList {

	public BookList() {
		currntID = 0;
		bookList = new ArrayList<>();
		bookLogMap = new HashMap<>();
	}

	private ArrayList<Book> bookList;

	private HashMap<String, BookLog> bookLogMap;

	private int currntID;

	public void addBook(Book book) {
		bookList.add(book);
	}

	public void removeBook(Book book) {
		bookList.remove(book);
	}

	public void listAuthor() {
		// TODO implement here
	}

	public void listSubject() {
		// TODO implement here
	}

	public void checkoutBook() {
		// TODO implement here
	}

	public void returnBook() {
		// TODO implement here
	}

	public void findBorrower() {
		// TODO implement here
	}

	public void findChecked() {
		// TODO implement here
	}

	private Book getBook(int ID) {
		for (Book book : bookList) {
			if (book.getID() == ID) {
				return book;
			}
		}
		return null;
	}

}