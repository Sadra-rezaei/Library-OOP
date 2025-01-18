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
        Scanner scanner = new Scanner(System.in);

        boolean flag;
        String title;
        String author;
        String year;
        String isbn;
        int numberOfCopy;
        String userName;
        String userPhoneNumber;

        do{
            System.out.println("1. Show book list");
            System.out.println("2. Add a new book");
            System.out.println("3. Remove a book");
            System.out.println("4. Search book");
            System.out.println("5. *Edit book");
            System.out.println("6. Borrow book");
            System.out.println("7. Return book");
            System.out.println("8. Show borrowed books");
            System.out.println("9. Show borrow history of book");
            System.out.println("10. Show all borrowed books and returned books");
            System.out.println("11. Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    this.library.showBooks();
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    title = scanner.next();

                    System.out.print("Enter author: ");
                    author = scanner.next();

                    do {
                        System.out.print("Enter ISBN: ");
                        isbn = scanner.next();

                        flag = false;
                        for (Book book : this.library.getBooks()) {
                            if (book.getIsbn().equals(isbn)) {
                                flag = true;
                            }
                        }
                        if (flag) {
                            System.out.print("=== ISBN already exists ===");
                        }
                    } while (flag);

                    System.out.print("Enter year: ");
                    year = scanner.next();

                    System.out.print("Enter number of copies: ");
                    numberOfCopy = scanner.nextInt();

                    this.library.addBook(title, author, isbn , year , numberOfCopy);
                    break;

                case 3:
                    System.out.print("=== Enter the ISBN of book ===: ");
                    isbn = scanner.next();

                    this.library.removeBook(isbn);
                    break;

                case 4:
                    System.out.println("=== Chose the filter ===: ");
                    System.out.println("  1. by title");
                    System.out.println("  2. by author");
                    System.out.println("  3. by ISBN");
                    System.out.println("  4. === Back ===\n");

                    System.out.print("=== Enter your choice: ");
                    int choice1 = scanner.nextInt();

                    switch (choice1) {
                        case 1:
                            System.out.print("Enter title: ");
                            title = scanner.next();
                            library.searchTitle(title);
                            break;

                        case 2:
                            System.out.print("Enter author: ");
                            author = scanner.next();
                            library.searchAuthor(author);
                            break;

                        case 3:
                            System.out.print("Enter ISBN: ");
                            isbn = scanner.next();
                            library.searchISBN(isbn);
                            break;
                    }
                    System.out.print("\n");
                    break;

                case 5:
                    for (User user : library.getAllUsers()) {
                        System.out.println(user.getName());
                    }

                    break;

                case 6:
                    System.out.print("Enter the ISBN of book: ");
                    isbn = scanner.next();

                    System.out.print("Enter your name: ");
                    userName = scanner.next();

                    System.out.print("Enter your phone number: ");
                    userPhoneNumber = scanner.next();

                    boolean userFlag = false;
                    int bookFlag = 0;
                    for (Book book : library.getBooks()) {
                        if (book.getIsbn().equals(isbn)) {
                            if (book.getNumberOfBook() > 0) {
                                for (User user : library.getAllUsers()) {
                                    if (user.getName().equals(userName) && user.getPhoneNumber().equals(userPhoneNumber)) {
                                        book.setNumberOfBook(book.getNumberOfBook() - 1);
                                        user.getBorrowedBooks().add(book);
                                        System.out.println("\n=== You borrowed " + book.getTitle() + " ===\n");
                                        userFlag = true;
                                        break;

                                    }
                                }
                                if (!userFlag) {
                                    User user = new User(userName, userPhoneNumber);
                                    library.getAllUsers().add(user);
                                    book.setNumberOfBook(book.getNumberOfBook() - 1);
                                    user.getBorrowedBooks().add(book);
                                    System.out.println("\n=== You borrowed " + book.getTitle() + " ===\n");
                                    break;
                                }
                            }
                            else {
                                bookFlag = 1;
                            }
                        }
                        else {
                            bookFlag = 2;
                        }
                    }
                    if (bookFlag == 1) {
                        System.out.println("\n=== this book is not available ===\n");
                    }
                    else if (bookFlag == 2) {
                        System.out.println("\n=== ISBN is not exist ===\n");
                    }
                    break;

                case 7:
                    System.out.print("Enter your name: ");
                    userName = scanner.next();

                    System.out.print("Enter your phone number: ");
                    userPhoneNumber = scanner.next();

                    int counter = 0;
                    for (User user : library.getAllUsers()) {
                        if (user.getName().equals(userName) && user.getPhoneNumber().equals(userPhoneNumber)) {
                            System.out.println("=== You borrowed these books ===");
                            System.out.println("\n0. === Back ===\n");
                            for (Book book : user.getBorrowedBooks()) {
                                counter ++;
                                System.out.print(counter + ". ");
                                book.showBookSpecifications();
                            }
                            System.out.print("\n=== Which book do you want to return? ===\n=== Enter the number of book in this list ===: ");
                            counter = scanner.nextInt();
                            if (counter == 0) {
                                break;
                            }

                            user.getBorrowedBooks().get(counter - 1).getBorrowetionHistory().add(user);
                            user.getBorrowedBooks().get(counter - 1).setNumberOfBook(user.getBorrowedBooks().get(counter - 1).getNumberOfBook() + 1);
                            user.getBorrowedBooks().remove(counter - 1);

                            System.out.println("=== Book returned successfully ===");
                            break;
                        }
                    }




                    System.out.println();
                    break;

                case 8:
                    for (User user : library.getAllUsers()) {
                        for (Book book : user.getBorrowedBooks()) {
                            book.showBookSpecifications();
                            System.out.println("    Borrowed by " + user.getName() + " with phone number: " + user.getPhoneNumber() + "\n\n");
                        }
                    }
                    break;

                case 9:
                    System.out.print("Enter books ISBN: ");
                    isbn = scanner.next();

                    for (Book book : library.getBooks()) {
                        if (book.getIsbn().equals(isbn)) {
                            for (User user : book.getBorrowetionHistory()) {
                                System.out.println(book.getTitle() + " was borrowed by " + user.getName() + " with phone number: " + user.getPhoneNumber() + "\n");
                            }
                        }
                    }
                    break;

                case 10:
                    for (User user : library.getAllUsers()) {
                        for (Book book : user.getBorrowedBooks()) {
                            System.out.println(book.getTitle() + " was returned by " + user.getName() + " with phone number: " + user.getPhoneNumber() + "\n");
                        }
                    }

                    for (Book book : library.getBooks()) {
                        for (User user : book.getBorrowetionHistory()) {
                            System.out.println(book.getTitle() + " is borrowed by " + user.getName() + " with phone number: " + user.getPhoneNumber() + "\n");
                        }
                    }
                    break;

                case 11:
                    System.out.println("Goodbye!");
                    break;
            }

        }while (choice != 11);
    }
}
