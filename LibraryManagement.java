import java.util.ArrayList;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return String.format("Title: %-20s | Author: %s", "\"" + title + "\"", author);
    }
}

public class LibrarySystem {
    
    private ArrayList<Book> inventory = new ArrayList<>();

    public void addBook(String title, String author) {
        inventory.add(new Book(title, author));
        System.out.println("Success: Added " + title);
    }

    public void displayLibrary() {
        System.out.println("\n--- Current Library Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            for (Book b : inventory) {
                System.out.println(b);
            }
        }
        System.out.println("----------------------------------\n");
    }
  
    public void searchByTitle(String title) {
        System.out.println("Searching for: " + title);
        for (Book b : inventory) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Result: " + b);
                return;
            }
        }
        System.out.println("Result: Book not found.");
    }

    public void issueBook(String title) {
        boolean removed = inventory.removeIf(b -> b.title.equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Success: '" + title + "' has been issued.");
        } else {
            System.out.println("Error: Could not find '" + title + "' to issue.");
        }
    }

    public static void main(String[] args) {
        LibrarySystem myLibrary = new LibrarySystem();

        myLibrary.addBook("The Great Gatsby", "F. Scott Fitzgerald");
        myLibrary.addBook("1984", "George Orwell");
        myLibrary.addBook("The Hobbit", "J.R.R. Tolkien");

        myLibrary.displayLibrary();

        myLibrary.searchByTitle("1984");

        myLibrary.issueBook("The Great Gatsby");

        myLibrary.displayLibrary();
    }
}
