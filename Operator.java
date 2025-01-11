import java.util.Scanner;

public class Operator {
    private Library library;

    public Operator(Library library) {
        this.library = library;
    }


    public void help() {
        System.out.println("Welcome to " + library.getName() + " Library");
        System.out.println("How can I help you?\n");
        int choice = 0;
        do{
            System.out.println("1. Show book list");
            System.out.println("2. Add a new book");
            System.out.println("3. Remove a book");
            System.out.println("4. Search book by title");
            System.out.println("5. Search author by author");
            System.out.println("6. Borrow book");
            System.out.println("7. Return book");
            System.out.println("8. Exit");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    this.library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title = scanner.next();

                    System.out.print("Enter author: ");
                    String author = scanner.next();

                    System.out.print("Enter pages: ");
                    int pages = scanner.nextInt();

                    this.library.addBook(title, author, pages);
                    System.out.println("New book added!");
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the title of book: ");
                    String title1 = scanner.next();

                    System.out.print("Enter the author of book: ");
                    String author1 = scanner.next();

                    System.out.print("Enter the pages of book: ");
                    int pages1 = scanner.nextInt();

                    this.library.removeBook(title1, author1, pages1);
                    System.out.println("Book removed");
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter the title of book: ");
                    String title2 = scanner.next();

                    for (Book book : this.library.getBooks()) {
                        if (book.getTitle().equals(title2)) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages");
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Enter the author of book: ");
                    String author3 = scanner.next();
                    for (Book book : this.library.getBooks()) {
                        if (book.getAuthor().equals(author3)) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor() + " with " + book.getPages() + " pages");
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter the title of book: ");
                    String title4 = scanner.next();

                    System.out.print("Enter the author of book: ");
                    String author4 = scanner.next();

                    System.out.print("Enter the pages of book: ");
                    int pages4 = scanner.nextInt();

                    for (Book book : this.library.getBooks()) {
                        if (book.getTitle().equals(title4) && book.getAuthor().equals(author4) && book.getPages() == pages4 && book.isAvaiable()) {
                            book.changeAvaiable();
                            System.out.println(book.getTitle() + " borrowed for you");
                            break;
                        } else if (!book.isAvaiable()) {
                            System.out.println(book.getTitle() + " is already borrowed");
                            break;
                        }
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.print("Enter the title of book: ");
                    String title5 = scanner.next();

                    System.out.print("Enter the author of book: ");
                    String author5 = scanner.next();

                    System.out.print("Enter the pages of book: ");
                    int pages5 = scanner.nextInt();

                    for (Book book : this.library.getBooks()) {
                        if (book.getTitle().equals(title5) && book.getAuthor().equals(author5) && !book.isAvaiable()) {
                            book.changeAvaiable();
                            System.out.println(book.getTitle() + " returned to library");
                            break;
                        } else if (book.isAvaiable()) {
                            System.out.println(book.getTitle() + " is not borrowed");
                        }
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    break;
            }

        }while (choice != 8);
    }
}
