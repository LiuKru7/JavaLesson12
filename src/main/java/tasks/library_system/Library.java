package tasks.library_system;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Book> books;
    ArrayList<User> users = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void createNewUser() {
        System.out.println("Say your name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);
        users.add(user);
    }

    public void printUsers() {
        System.out.println("Print Users ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).name);
        }
    }



    public void displayAvailableBooks() {
        System.out.println("Hello! We have this books now.");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable) {
                System.out.printf("%d. Name: %s ; Author: %s %n", i + 1, books.get(i).title, books.get(i).author);
            }
        }
    }

    public void takeBookFromLibrary() {
        printUsers();
        System.out.println("Say your name:");
        String userName = scanner.nextLine();


        if (userName == null || userName.isEmpty()) {
            System.out.println("Invalid user name.");
            return;
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).books[i]);

        }

        displayAvailableBooks();
        System.out.println("If you want a book from the list, write the book number. If not, write '0':");
        int wantBookNumber = scanner.nextInt();
        scanner.nextLine();

        if (wantBookNumber == 0) {
            System.out.println("Good day. Back next time!");
            return;
        }
        if (wantBookNumber > books.size() || wantBookNumber < 1) {
            System.out.println("This number does not exist.");
            return;
        }

        Book selectedBook = books.get(wantBookNumber - 1);
        if (!selectedBook.isAvailable) {
            System.out.println("Sorry, this book is not available.");
            return;
        }
        selectedBook.isAvailable = false;

    }
}
