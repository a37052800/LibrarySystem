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
		book.setID(currntID);
		currntID++;
		bookList.add(book);
	}

	public void addBook(User user, Book book) {
		if (user.getType().equals("Borrower")) {
			System.out.println("Borrower can not add book");
		} else
			addBook(book);
	}

	private void removeBook(int ID) {
		bookList.remove(getBook(ID));
	}

	public void removeBook(User user, int ID) {
		if (user.getType().equals("Borrower")) {
			System.out.println("Borrower can not remove book");
		} else
			removeBook(ID);
	}

	public void listAuthor(User user, String author) {
		for (Book book : bookList) {
			if (book.getAuthor().equals(author))
				book.show();
		}
	}

	public void listSubject(User user, String subject) {
		for (Book book : bookList) {
			if (book.getSubject().equals(subject))
				book.show();
		}
	}

	private void checkoutBook(int ID, User user) {
		Book book = getBook(ID);
		if (!book.isBorrow()) {
			book.borrowBook(user);
			if (bookLogMap.get(user.getName()) == null)
				bookLogMap.put(user.getName(), new BookLog());
			bookLogMap.get(user.getName()).addLog(book);
		} else
			System.out.println("Can not check out since the book is checked out");
	}

	public void checkoutBook(User user1, int ID, User user2) {
		if (user1.getType().equals("Borrower")) {
			System.out.println("Borrower can not check out the books");
		} else
			checkoutBook(ID, user2);
	}

	private void returnBook(int ID) {
		Book book = getBook(ID);
		if (book.isBorrow()) {
			bookLogMap.get(getBook(ID).getBorrowerName()).removeLog(book);
			book.returnBook();
		} else
			System.out.println("Can not return since the book isn't checked out");
	}

	public void returnBook(User user, int ID) {
		if (user.getType().equals("Borrower")) {
			System.out.println("Borrower can not return book");
		} else
			returnBook(ID);
	}

	private void findBorrower(int ID) {
		System.out.printf("User: %s", getBook(ID).getBorrowerName());
	}

	public void findBorrower(User user, int ID) {
		if (user.getType().equals("Borrower")) {
			System.out.println("Borrower can not find borrower");
		} else
			findBorrower(ID);
	}

	private void findChecked(User user) {
		for (int ID : bookLogMap.get(user.getName()).getBorrowedList()) {
			getBook(ID).show();
		}
	}

	public void findChecked(User user1, User user2) {
		if (user1.getType().equals("Borrower") && (!user1.getName().equals(user2.getName()))) {
			System.out.println("Borrower can not find books checked out by other users");
		} else
			findChecked(user2);
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