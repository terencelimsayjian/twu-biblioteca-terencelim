import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testGetTitle() {
        Book harryPotter = new Book("Harry Potter", "J.K. Rowling", 2003);
        assertEquals(harryPotter.getTitle(), "Harry Potter");
    }

    @Test
    public void testGetAuthor() {
        Book theMagicians = new Book("The Magicians", "Lev Grossman", 2005);
        assertEquals(theMagicians.getAuthor(), "Lev Grossman");
    }

    @Test
    public void testGetYearPublished() {
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2008);
        assertEquals(americanGods.getYearPublished(), 2008);
    }

}