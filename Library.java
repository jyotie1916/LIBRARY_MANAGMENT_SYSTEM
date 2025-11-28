import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBookById(int id) {
        for (Book book : bookList) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean updateBook(int id, String newTitle, String newAuthor, double newPrice) {
        Book book = getBookById(id);

        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setPrice(newPrice);
            return true;
        }
        return false;
    }

    public boolean deleteBook(int id) {
        Book book = getBookById(id);

        if (book != null) {
            bookList.remove(book);
            return true;
        }
        return false;
    }
}
