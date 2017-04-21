import database.MockBookDatabase;
import tableStringFormatter.BookTableStringFormatter;
import model.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTableStringFormatterTest {
    BookTableStringFormatter bookTableStringFormatter;
    int desiredIdStringLength;
    int desiredTitleStringLength;
    int desiredAuthorStringLength;
    int desiredYearPublishedStringLength;
    String divider;
    int totalStringLength;

    @Before
    public void setUp() {
        MockBookDatabase mockBookDatabase = new MockBookDatabase();

        bookTableStringFormatter = new BookTableStringFormatter(mockBookDatabase.getBooks());
        desiredIdStringLength = bookTableStringFormatter.idStringLength;
        desiredTitleStringLength = bookTableStringFormatter.titleStringLength;
        desiredAuthorStringLength = bookTableStringFormatter.authorStringLength;
        desiredYearPublishedStringLength = bookTableStringFormatter.yearPublishedStringLength;
        divider = bookTableStringFormatter.divider;
        totalStringLength = bookTableStringFormatter.totalStringLength;
    }

    @Test
    public void testIdStringBuilder() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman", 2008);
        String americanGodsIdString = bookTableStringFormatter.buildId(americanGods);
        assertEquals(americanGodsIdString.length(), desiredIdStringLength);
    }

    @Test
    public void testTitleStringBuilder() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman", 2008);
        String americanGodsTitleString = bookTableStringFormatter.buildTitle(americanGods);
        assertEquals(americanGodsTitleString.length(), desiredTitleStringLength);
    }

    @Test
    public void testLongTitleToString() {
        Book harryPotter = new Book(1, "Harry Potter and the Goblet of Gooey Fire", "J.K. Rowling", 2003);
        String harryPotterTitleString = bookTableStringFormatter.buildTitle(harryPotter);
        assertEquals(harryPotterTitleString.length(), desiredTitleStringLength);
        assertEquals(harryPotterTitleString, "Harry Potter and the Goblet of Gooey ...");
    }

    @Test
    public void testAuthorToString() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman Bartholomew", 2008);
        String americanGodsAuthorString = bookTableStringFormatter.buildAuthor(americanGods);
        assertEquals(americanGodsAuthorString.length(), desiredAuthorStringLength);
        assertEquals(americanGodsAuthorString, "Neil Gaiman Barth...");
    }

    @Test
    public void testYearPublishedToString() {
        Book americanGods = new Book(1, "American Gods", "Neil Gaiman Bartholomew", 2008);
        String americanGodsYearPublishedString = bookTableStringFormatter.buildYearPublished(americanGods);
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
        String americanGodsString = bookTableStringFormatter.build(americanGods);

        assertEquals(americanGodsString.length(), totalStringLength);
    }

    @Test
    public void testHeader() {
        assertEquals(bookTableStringFormatter.buildHeader().length(), totalStringLength);
    }

    @Test
    public void testDivider() {
        assertEquals(bookTableStringFormatter.buildDivider().length(), totalStringLength);
    }
}