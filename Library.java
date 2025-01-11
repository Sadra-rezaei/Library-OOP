import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;


    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public void addBook(String title, String author, int pages) {
        Book book = new Book(title, author, pages);
        this.books.add(book);
    }

    public void removeBook(String title, String author, int pages) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.getPages() == pages) {
                this.books.remove(book);
                break;
            }
        }
    }

    public void showBooks() {
        for (Book book : this.books) {
            if (book.isAvaiable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages is available");
            }
            else {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages is borrowed");
            }
        }
        System.out.println();
    }

    public void searchBook(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                if (book.isAvaiable()) {
                    System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages is available");
                }
                else {
                    System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages is borrowed");
                }
            }
        }
    }

    public void searchAuthor(String author) {
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                if (book.isAvaiable()) {
                    System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages is available");
                }
                else {
                    System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages is borrowed");
                }
            }
        }
    }
}

