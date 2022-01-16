import java.util.*;

public class Main {
    public static Scanner jin;

    public static void main(String[] args) {
        jin = new Scanner(System.in);
        BookList bookList = new BookList();
        ArrayList<User> userList = new ArrayList<>();
        int bookNum = jin.nextInt();
        while (bookNum-- > 0) {
            String author = jin.next();
            String subject = jin.next();
            Book newBook = new Book(author, subject);
            bookList.addBook(newBook);
        }
        int userNum = jin.nextInt();
        while (userNum-- > 0) {
            User newUser;
            String userType = jin.next();
            String userName = jin.next();
            if (userType.equals("Borrower")) {
                int predifinedNum = jin.nextInt();
                newUser = new User(userName, userType, predifinedNum);
            } else
                newUser = new User(userName, userType);
            userList.add(newUser);
        }
        while (jin.hasNext()) {
            
        }
    }
}
