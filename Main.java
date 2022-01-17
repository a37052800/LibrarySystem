import java.util.*;

public class Main {
    public static Scanner jin;
    private static BookList bookList;
    private static ArrayList<User> userList;

    public static void main(String[] args) {
        jin = new Scanner(System.in);
        bookList = new BookList();
        userList = new ArrayList<>();
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
        jin.nextLine();
        while (jin.hasNext()) {
            String[] commend = jin.nextLine().split(" ");
            switch (commend[1].trim()) {
                case "addBook":
                    String author = jin.next();
                    String subject = jin.next();
                    Book newBook = new Book(author, subject);
                    bookList.addBook(getUser(commend[0].trim()), newBook);
                    jin.nextLine();
                    break;
                case "removeBook":
                    bookList.removeBook(getUser(commend[0].trim()), Integer.parseInt(commend[2]));
                    break;
                case "checkout":
                    String[] bookID = jin.nextLine().split(" ");
                    User borrower = getUser(commend[2]);
                    int limit = borrower.getLimit();
                    for (String ID : bookID) {
                        if (limit < 1) {
                            System.out.println(
                                    "Can not check out since the number of books exceed the limitation of user can check-out");
                            break;
                        }
                        bookList.checkoutBook(getUser(commend[0]), Integer.parseInt(ID), borrower);
                        limit--;
                    }
                    break;
                case "return":
                    bookList.returnBook(getUser(commend[0]), Integer.parseInt(commend[2]));
                    break;
                case "listAuthor":
                    bookList.listAuthor(getUser(commend[0]), commend[2]);
                    break;
                case "listSubject":
                    bookList.listSubject(getUser(commend[0]), commend[2]);
                    break;
                case "findChecked":
                    bookList.findChecked(getUser(commend[0]), getUser(commend[2]));
                    break;
                case "findBorrower":
                    bookList.findBorrower(getUser(commend[0]), Integer.parseInt(commend[2]));
                    break;
                default:
                    break;
            }
        }
    }

    private static User getUser(String name) {
        for (User user : userList) {
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }
}
