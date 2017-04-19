import org.junit.*;

import static org.junit.Assert.*;

public class BookTest {
    Book book;

    @Before
    public void setUp() throws Exception {
        book = new Book(1, "Harry Potter", "J.K. Rowling", 2003);
    }

    @Test
    public void testGetTitle() {
        assertEquals(book.getTitle(), "Harry Potter");
    }

    @Test
    public void testGetAuthor() {
        assertEquals(book.getAuthor(), "J.K. Rowling");
    }

    @Test
    public void testGetYearPublished() {
        assertEquals(book.getYearPublished(), 2003);
    }

    @Test
    public void testGetId() {
        assertEquals(book.getId(), 1);
    }

}