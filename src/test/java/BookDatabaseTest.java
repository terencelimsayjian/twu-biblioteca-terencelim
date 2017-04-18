import org.junit.Test;

import static org.junit.Assert.*;

public class BookDatabaseTest {

    @Test
    public void listAllBooks() throws Exception {
        BookDatabase bookDatabase = new BookDatabase();
        assertEquals(bookDatabase.getBooks().get(0) instanceof Book, true);
    }

}