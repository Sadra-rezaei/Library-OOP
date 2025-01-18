import java.util.ArrayList;

public class User {
    private String name;
    private String phoneNumber;
    private ArrayList<Book> borrowedBooks;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }
}
