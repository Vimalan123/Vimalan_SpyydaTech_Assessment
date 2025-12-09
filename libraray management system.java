import java.util.*;
class Book {
    int id;
    String title;
    String author;
    boolean borrowed;
    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Borrowed: " + borrowed;
    }
}

public class LibrarySystem {

    ArrayList<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // new id exists
        for (Book b : books) {
            if (b.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added.");
    }

    public void searchBooks(Scanner sc) {
        System.out.print("Enter search text: ");
        String text = sc.nextLine().toLowerCase();
         boolean found = false;

        for (Book b : books) 
        {
            if (b.title.toLowerCase().contains(text) || b.author.toLowerCase().contains(text)) 
            {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) 
        {
            System.out.println("No matching books found.");
        }
    }

 
    public void borrowBook(Scanner sc) {
        System.out.print("Enter Book ID to borrow: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) 
        {
            if (b.id == id) 
                
            {
                if (b.borrowed) 
                    {
                    System.out.println("Already borrowed!");
                } 
                else {
                    b.borrowed = true;
                    System.out.println("Book borrowed.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    // Return book
    public void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {
            if (b.id == id) 
            {
                if (!b.borrowed) 
                {
                    System.out.println("Book was not borrowed.");
                } else 
                {
                    b.borrowed = false;
                    System.out.println("Book returned.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1)
                addBook(sc);
            else if (choice == 2)
                searchBooks(sc);
            else if (choice == 3)
                borrowBook(sc);
            else if (choice == 4)
                returnBook(sc);
            else if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }
            else
                System.out.println("Invalid choice.");
        }

        sc.close();
    }

    public static void main(String[] args) {
        LibrarySystem  ls  = new LibrarySystem();
        ls.start();
    }
}
