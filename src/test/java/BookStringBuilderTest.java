import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookStringBuilderTest {
    BookStringBuilder bookStringBuilder;
    int desiredIdStringLength;
    int desiredTitleStringLength;
    int desiredAuthorStringLength;
    int desiredYearPublishedStringLength;
    String divider;
    int totalStringLength;

    @Before
    public void setUp() {
        bookStringBuilder = new BookStringBuilder();
        desiredIdStringLength = bookStringBuilder.idStringLength;
        desiredTitleStringLength = bookStringBuilder.titleStringLength;
        desiredAuthorStringLength = bookStringBuilder.authorStringLength;
        desiredYearPublishedStringLength = bookStringBuilder.yearPublishedStringLength;
        divider = bookStringBuilder.divider;
        totalStringLength = bookStringBuilder.totalStringLength;
    }

    @Test
    public void testIdStringBuilder() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman", 2008);
        String americanGodsIdString = bookStringBuilder.buildId(americanGods);
        assertEquals(americanGodsIdString.length(), desiredIdStringLength);
    }

    @Test
    public void testTitleStringBuilder() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman", 2008);
        String americanGodsTitleString = bookStringBuilder.buildTitle(americanGods);
        assertEquals(americanGodsTitleString.length(), desiredTitleStringLength);
    }

    @Test
    public void testLongTitleToString() {
        Book harryPotter = new Book(1, "Harry Potter and the Goblet of Gooey Fire", "J.K. Rowling", 2003);
        String harryPotterTitleString = bookStringBuilder.buildTitle(harryPotter);
        assertEquals(harryPotterTitleString.length(), desiredTitleStringLength);
        assertEquals(harryPotterTitleString, "Harry Potter and the Goblet of Gooey ...");
    }

    @Test
    public void testAuthorToString() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman Bartholomew", 2008);
        String americanGodsAuthorString = bookStringBuilder.buildAuthor(americanGods);
        assertEquals(americanGodsAuthorString.length(), desiredAuthorStringLength);
        assertEquals(americanGodsAuthorString, "Neil Gaiman Barth...");
    }

    @Test
    public void testYearPublishedToString() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman Bartholomew", 2008);
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
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman Bartholomew", 2008);
        String americanGodsString = bookStringBuilder.build(americanGods);

        assertEquals(americanGodsString.length(), totalStringLength);
    }

    @Test
    public void testHeader() {
        assertEquals(bookStringBuilder.buildHeader().length(), totalStringLength);
    }

    @Test
    public void testDivider() {
        assertEquals(bookStringBuilder.buildDivider().length(), totalStringLength);
    }
}