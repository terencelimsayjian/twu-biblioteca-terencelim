import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookStringBuilderTest {
    BookStringBuilder bookStringBuilder;
    int desiredTitleStringLength = 40;
    int desiredAuthorStringLength = 20;
    int desiredYearPublishedStringLength = 14;
    String divider = " | ";
    int totalStringLength;

    @Before
    public void setUp() {
        bookStringBuilder = new BookStringBuilder();

        totalStringLength = desiredTitleStringLength + desiredAuthorStringLength + desiredYearPublishedStringLength
                + divider.length() + divider.length();
    }

    @Test
    public void testTitleStringBuilder() {
        Book americanGods = new Book("American Gods", "Neil Gaiman", 2008);
        String americanGodsTitleString = bookStringBuilder.buildTitle(americanGods);
        assertEquals(americanGodsTitleString.length(), desiredTitleStringLength);
    }

    @Test
    public void testLongTitleToString() {
        Book harryPotter = new Book("Harry Potter and the Goblet of Gooey Fire", "J.K. Rowling", 2003);
        String harryPotterTitleString = bookStringBuilder.buildTitle(harryPotter);
        assertEquals(harryPotterTitleString.length(), desiredTitleStringLength);
        assertEquals(harryPotterTitleString, "Harry Potter and the Goblet of Gooey ...");
    }

    @Test
    public void testAuthorToString() {
        Book americanGods = new Book("American Gods", "Neil Gaiman Bartholomew", 2008);
        String americanGodsAuthorString = bookStringBuilder.buildAuthor(americanGods);
        assertEquals(americanGodsAuthorString.length(), desiredAuthorStringLength);
        assertEquals(americanGodsAuthorString, "Neil Gaiman Barth...");
    }

    @Test
    public void testYearPublishedToString() {
        Book americanGods = new Book("American Gods", "Neil Gaiman Bartholomew", 2008);
        String americanGodsYearPublishedString = bookStringBuilder.buildYearPublished(americanGods);
        assertEquals(americanGodsYearPublishedString.length(), desiredYearPublishedStringLength);

        String yearPublished = "2008";

        int spacesToAdd = desiredYearPublishedStringLength - yearPublished.length();
        for (int i = 0; i < spacesToAdd; i++) {
            yearPublished = yearPublished + " ";
        }

        assertEquals(americanGodsYearPublishedString, yearPublished);
    }

    @Test
    public void testBookToString() {
        Book americanGods = new Book("American Gods", "Neil Gaiman Bartholomew", 2008);
        String americanGodsString = bookStringBuilder.build(americanGods);

        assertEquals(americanGodsString.length(), totalStringLength);
    }

    @Test
    public void testHeader() {
        assertEquals(bookStringBuilder.buildHeader().length(), totalStringLength);
    }

    @Test
    public void testDivider() throws Exception {
        assertEquals(bookStringBuilder.buildDivider().length(), totalStringLength);
    }
}