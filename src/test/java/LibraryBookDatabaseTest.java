import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryBookDatabaseTest {
    private static LibraryBookDatabase libraryBookDatabase;

    @Before
    public void setUp() throws Exception {
        libraryBookDatabase = new LibraryBookDatabase();
    }

    @Test
    public void listAllBooks() throws Exception {
        assertEquals(libraryBookDatabase.getAvailableBooks().get(0) instanceof Book, true);
    }

    @Test
    public void testCheckoutBooks() throws Exception {
        libraryBookDatabase.checkoutBook(3);
        assertEquals(libraryBookDatabase.getAvailableBooks().size(), 9);
        libraryBookDatabase.checkoutBook(4);
        assertEquals(libraryBookDatabase.getAvailableBooks().size(), 8);
        libraryBookDatabase.checkoutBook(5);
        assertEquals(libraryBookDatabase.getAvailableBooks().size(), 7);

    }

    @Test
    public void checkoutSameBookTwiceShouldNotWork() throws Exception {
        libraryBookDatabase.checkoutBook(3);
        assertEquals(libraryBookDatabase.getAvailableBooks().size(), 9);
        libraryBookDatabase.checkoutBook(3);
        assertEquals(libraryBookDatabase.getAvailableBooks().size(), 9);
    }

    @Test
    public void testReturnBook() throws Exception {
        libraryBookDatabase.checkoutBook(1);
        assertEquals(libraryBookDatabase.getAvailableBooks().size(), 9);
        assertEquals(libraryBookDatabase.getBooksOnLoan().size(), 1);
        libraryBookDatabase.returnBook(1);
        assertEquals(libraryBookDatabase.getAvailableBooks().size(), 10);
        assertEquals(libraryBookDatabase.getBooksOnLoan().size(), 0);
    }

}