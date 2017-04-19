import java.util.ArrayList;

public class LibraryBookDatabase {
    ArrayList<Book> availableBooks = new ArrayList<>();
    ArrayList<Book> booksOnLoan = new ArrayList<>();

    public LibraryBookDatabase() {
        MockBookDatabase mockBookDatabase = new MockBookDatabase();
        availableBooks.addAll(mockBookDatabase.getBooks());
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public ArrayList<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    public Book checkoutBook(int bookId) {
        Book checkedOutBook = null;
        for (Book book : availableBooks) {
            if (book.getId() == bookId) {
                availableBooks.remove(book);
                booksOnLoan.add(book);
                checkedOutBook = book;
                break;
            }
        }

        return checkedOutBook;
    }

    public Book returnBook(int bookId) {
        Book returnedBook = null;

        for (Book book : booksOnLoan) {
            if (book.getId() == bookId) {
                booksOnLoan.remove(book);
                availableBooks.add(book);
                returnedBook = book;
                break;
            }
        }

        return returnedBook;
    }

    private String toTable(ArrayList<Book> bookList) {
        BookStringBuilder bookStringBuilder = new BookStringBuilder();
        String bookTable = "";

        bookTable = bookTable + bookStringBuilder.buildHeader() + "\n";
        bookTable = bookTable  + bookStringBuilder.buildDivider() + "\n";

        for (Book book : bookList) {
            bookTable = bookTable + bookStringBuilder.build(book) + "\n";
        }

        bookTable = bookTable + bookStringBuilder.buildDivider();

        return bookTable;
    }

    public String availableBooksToString() {
        return toTable(availableBooks);
    }

    public String booksOnLoanToString() {
        return toTable(booksOnLoan);
    }
}
