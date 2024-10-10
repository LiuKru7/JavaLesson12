package tasks.library_system;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        library.createNewUser();
        library.createNewUser();
        library.addBook(new Book("Knyga", "Biliunas"));
        library.addBook(new Book("Knyga2", "Biliunas2"));
        library.addBook(new Book("Knyga3", "Biliunas3"));
        library.addBook(new Book("Knyga4", "Biliunas4"));
        library.takeBookFromLibrary();


    }
}
