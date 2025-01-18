import java.util.ArrayList;

public class Book {
    private String title;
    private String isbn;
    private String author;
    private String publishYear;
    private int numberOfBook;
    private ArrayList<User> borrowetionHistory;


    public Book (String title,String author, String isbn ,String publishYear , int numberOfBook) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.numberOfBook = numberOfBook;
        this.publishYear = publishYear;
        this.borrowetionHistory = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublishYear() { return this.publishYear; }

    public int getNumberOfBook() { return this.numberOfBook; }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public ArrayList<User> getBorrowetionHistory() {
        return this.borrowetionHistory;
    }

    public void showBookSpecifications() {
        System.out.print(this.title + ": \n");
        System.out.println("    wrote by " + this.author);
        System.out.println("    published in " + this.publishYear);
        System.out.println("    ISBN: " + this.isbn);
    }

    public void showAvailable() {
        if (this.numberOfBook > 0) {
            System.out.println("    " + this.numberOfBook + " copies of book is available\n");
        }
        else {
            System.out.println("    no books available\n");
        }
    }






}
