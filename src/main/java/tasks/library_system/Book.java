package tasks.library_system;

public class Book {
    String title ;
    String author ;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}
