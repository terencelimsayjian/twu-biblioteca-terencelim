package database;

import helper.BookStringBuilder;
import model.Book;

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

    public boolean checkoutBook(int bookId) {
        boolean succeededCheckout = false;
        for (Book book : availableBooks) {
            if (book.getId() == bookId) {
                availableBooks.remove(book);
                booksOnLoan.add(book);
                succeededCheckout = true;
                break;
            }
        }

        return succeededCheckout;
    }

    public boolean returnBook(int bookId) {
        boolean succeedReturn = false;

        for (Book book : booksOnLoan) {
            if (book.getId() == bookId) {
                booksOnLoan.remove(book);
                availableBooks.add(book);
                succeedReturn = true;
                break;
            }
        }

        return succeedReturn;
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
