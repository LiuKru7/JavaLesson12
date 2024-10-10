package tasks.library_system;

import java.util.ArrayList;
import java.util.Objects;
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
        System.out.print("Say your name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);
        users.add(user);
    }

    public void printUsers() {
        System.out.println("\nAvailable users and his books: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Username: " + users.get(i).name);
            for (int j = 0; j < users.get(i).books.length; j++) {
                if (users.get(i).books[j] != null) {
                    System.out.printf("%d. Book name: %s ; Book author: %s",j+1, users.get(i).books[j].title, users.get(i).books[j].author);
                }
            }
            System.out.println("\n");
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

    public void displayUserBooks(int userIndex) {
        for (int j = 0; j < users.get(userIndex).books.length; j++) {
            if (users.get(userIndex).books[j] != null) {
                System.out.printf("%d. Book name: %s ; Book author: %s",j+1, users.get(userIndex).books[j].title, users.get(userIndex).books[j].author);
            }
        }



    }

    public void takeBookFromLibrary() {
        printUsers();
        int index = -1;


        System.out.println("Say your name:");
        String userName = scanner.nextLine();
        if (userName == null || userName.isEmpty()) {
            System.out.println("Invalid user name.");
            return;
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name.toLowerCase().equals(userName.toLowerCase())) {
                index = i;
                break;
            }
        }
        if (index == -1){
            return;
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
        users.get(index).books[0] = books.get(wantBookNumber-1);
        System.out.println();
        System.out.println(users.get(index).books[0].title);
    }


    public void returnBook(){
        printUsers();
        int index = -1;
        System.out.println("Say your name:");
        String userName = scanner.nextLine();
        if (userName == null || userName.isEmpty()) {
            System.out.println("Invalid user name.");
            return;
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name.toLowerCase().equals(userName.toLowerCase())) {
                index = i;
                break;
            }
        }
        if (index == -1){
            return;
        }

        displayUserBooks(index);

        System.out.println("Choose book number what you want to return :");
        int returnBookNumber = scanner.nextInt();
        int returnIndex = returnBookNumber-1;

        String bookTittle = users.get(index).books[returnIndex].title;
        users.get(index).books[returnIndex]= null;

        for (int i = 0; i < books.size(); i++) {
            if (Objects.equals(books.get(i).title, bookTittle)){
                books.get(i).isAvailable = true;
            }
        }
    }
}
