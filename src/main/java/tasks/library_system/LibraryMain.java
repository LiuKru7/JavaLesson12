package tasks.library_system;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        User jonas = new User("Jonas");
        Book book1 = new Book("Juodi lapai", "Juozas Erlickas");
        Book book2 = new Book("Raudonos knygs", "Edmundas Jakilaitis");
        Book book3 = new Book("Juodi ", "Juozas ");
        Book book4 = new Book("Raudonos ", "Edmundas ");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.displayAvailableBooks();

    }
}
