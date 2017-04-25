package database;

import model.Book;
import model.Loanable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryLoanableDatabaseTest {
    LibraryLoanableDatabase libraryBookDatabase;

    @Before
    public void setUp() throws Exception {
        Book book1 = new Book(1,  "Harry Potter", "J.K. Rowling", 2003);
        Book book2 = new Book(2,  "Lord Of The Rings", "J.R.R Tolkein", 1978);
        Book book3 = new Book(3, "The Magicians", "Lev Grossman", 2006);
        Book book4 = new Book(4, "American Gods", "Neil Gaiman", 2007);

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        libraryBookDatabase = new LibraryLoanableDatabase(bookList);
    }

    @Test
    public void testGetAvailableLoanables() throws Exception {
        assertEquals(libraryBookDatabase.getAvailableLoanables().size() == 4, true);
        assertEquals(libraryBookDatabase.getAvailableLoanables().get(1) instanceof Loanable, true);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size() == 0, true);

    }

    @Test
    public void testCheckout() throws Exception {
        assertEquals(libraryBookDatabase.checkoutLoanable(1), true);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size() == 3, true);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size() == 1, true);
    }

    @Test
    public void testCheckoutSameLoanableTwice() throws Exception {
        assertEquals(libraryBookDatabase.checkoutLoanable(1), true);
        assertEquals(libraryBookDatabase.checkoutLoanable(1), false);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size() == 3, true);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size() == 1, true);
    }

    @Test
    public void testReturn() throws Exception {
        assertEquals(libraryBookDatabase.checkoutLoanable(1), true);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size() == 3, true);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size() == 1, true);
        assertEquals(libraryBookDatabase.returnLoanable(1), true);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size() == 4, true);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size() == 0, true);
    }

    @Test
    public void testReturnSameLoanableTwice() throws Exception {
        assertEquals(libraryBookDatabase.checkoutLoanable(3), true);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size() == 3, true);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size() == 1, true);
        assertEquals(libraryBookDatabase.returnLoanable(3), true);
        assertEquals(libraryBookDatabase.returnLoanable(3), false);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size() == 4, true);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size() == 0, true);
    }
}