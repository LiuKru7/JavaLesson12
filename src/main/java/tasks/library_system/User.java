package tasks.library_system;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    String name;
    Book[] books = new Book[5];

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
