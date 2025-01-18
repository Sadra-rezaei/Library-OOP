import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;
    private ArrayList<User> allUsers;


    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.allUsers = new ArrayList<>();
    }

    public ArrayList<User> getAllUsers() { return allUsers; }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public void addBook(String title, String author, String isbn, String publishYear , int numberOfBook) {
        boolean flag = true;
        for (Book bookTemp : books) {
            if (bookTemp.getIsbn().equals(isbn)) {
                System.out.println("\n==== Sorry this ISBN already exists in the library ===\n");
                flag = false;
                break;
            }
        }
        if (flag) {
            Book book = new Book(title, author, isbn, publishYear , numberOfBook);
            this.books.add(book);
            System.out.println("\n=== " + book.getTitle() + " added to the library ===\n");
        }

    }

    public void removeBook(String isbn) {
        boolean found = false;
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                this.books.remove(book);
                System.out.println("==== " + book.getTitle() + " removed from the library ===");
                book = null;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("=== Sorry this ISBN does not exist in the library ===");
        }
    }

    public void showBooks() {
        boolean found = false;
        for (Book book : this.books) {
            book.showBookSpecifications();
            book.showAvailable();
            found = true;
        }
        if (!found) {
            System.out.println("=== Library is empty ===");
        }
        System.out.println();
    }

    public void searchTitle(String title) {
        boolean found = false;
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                book.showBookSpecifications();
                book.showAvailable();
                found = true;
            }
        }
        if (!found) {
            System.out.println("=== No result ===");
        }
        System.out.println();
    }

    public void searchAuthor(String author) {
        boolean found = false;
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                book.showBookSpecifications();
                book.showAvailable();
                found = true;
            }
        }
        if (!found) {
            System.out.println("=== No result ===");
        }
        System.out.println();
    }

    public void searchISBN(String isbn) {
        boolean found = false;
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                book.showBookSpecifications();
                book.showAvailable();
                found = true;
            }
        }
        if (!found) {
            System.out.println("=== No result ===");
        }
        System.out.println();
    }
}

