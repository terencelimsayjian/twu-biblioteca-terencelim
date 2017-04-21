import database.LibraryLoanableDatabase;
import database.StaticBookData;
import model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryBookDatabaseTest {
    private static LibraryLoanableDatabase libraryBookDatabase;

    @Before
    public void setUp() throws Exception {
        StaticBookData staticBookData = new StaticBookData();
        libraryBookDatabase = new LibraryLoanableDatabase(staticBookData.getBooks());
    }

    @Test
    public void listAllBooks() throws Exception {
        assertEquals(libraryBookDatabase.getAvailableLoanables().get(0) instanceof Book, true);
    }

    @Test
    public void testCheckoutBooks() throws Exception {
        libraryBookDatabase.checkoutLoanable(3);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size(), 9);
        libraryBookDatabase.checkoutLoanable(4);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size(), 8);
        libraryBookDatabase.checkoutLoanable(5);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size(), 7);

    }

    @Test
    public void checkoutSameBookTwiceShouldNotWork() throws Exception {
        libraryBookDatabase.checkoutLoanable(3);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size(), 9);
        libraryBookDatabase.checkoutLoanable(3);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size(), 9);
    }

    @Test
    public void testReturnBook() throws Exception {
        libraryBookDatabase.checkoutLoanable(1);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size(), 9);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size(), 1);
        libraryBookDatabase.returnLoanable(1);
        assertEquals(libraryBookDatabase.getAvailableLoanables().size(), 10);
        assertEquals(libraryBookDatabase.getLoanablesOnLoan().size(), 0);
    }

}