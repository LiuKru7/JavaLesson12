package tasks.library_system;

import java.util.ArrayList;

public class Library {
    ArrayList<Book>books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook (Book book) {
        books.add(book);
    }

    public void displayAvailableBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.printf("%d. Name: %s ; Author: %s %n", i+1, books.get(i).title, books.get(i).author);

        }
    }
}
