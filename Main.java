import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    library.addBook(new Book(id, title, author, price));
                    break;

                case 2:
                    System.out.println("\n--- Book List ---");
                    for (Book b : library.getAllBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    Book book = library.getBookById(searchId);
                    System.out.println(book != null ? book : "Book not found");
                    break;

                case 4:
                    System.out.print("Enter Book ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter new Author: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter new Price: ");
                    double newPrice = sc.nextDouble();

                    boolean updated = library.updateBook(upId, newTitle, newAuthor, newPrice);
                    System.out.println(updated ? "Book updated successfully!" : "Book not found");
                    break;

                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    int delId = sc.nextInt();

                    boolean deleted = library.deleteBook(delId);
                    System.out.println(deleted ? "Book deleted successfully!" : "Book not found");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
