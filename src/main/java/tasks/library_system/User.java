package tasks.library_system;

public class User {
    String name;
    Book[] books = new Book[5];

    public User(String name) {
        this.name = name;
    }
}
