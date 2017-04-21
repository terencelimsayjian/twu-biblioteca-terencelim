package tableStringFormatter;

import model.Book;

import java.util.ArrayList;

public class BookTableStringFormatter extends TableStringFormatter {
    public int idStringLength = 3;
    public int titleStringLength = 40;
    public int authorStringLength = 20;
    public int yearPublishedStringLength = 14;

    ArrayList<Book> bookList;

    public BookTableStringFormatter(ArrayList<Book> bookList) {
        totalStringLength = idStringLength + divider.length() +
                titleStringLength + divider.length() +
                authorStringLength + divider.length() + yearPublishedStringLength;

        this.bookList = bookList;
    }

    public String build(Book book) {
        return buildId(book) + divider +
                buildTitle(book) + divider +
                buildAuthor(book) + divider +
                buildYearPublished(book);
    }

    public String buildId(Book book) {
        String idString = Integer.toString(book.getId());
        return formatStringToFixedLength(idString, idStringLength);
    }

    public String buildTitle(Book book) {
        return formatStringToFixedLength(book.getTitle(), titleStringLength);
    }

    public String buildAuthor(Book book) {
        return formatStringToFixedLength(book.getAuthor(), authorStringLength);
    }

    public String buildYearPublished(Book book) {
        String yearPublishedString = Integer.toString(book.getYearPublished());
        return formatStringToFixedLength(yearPublishedString, yearPublishedStringLength);
    }

    public String buildHeader() {
        String idHeaderString = "#";
        idHeaderString = formatStringToFixedLength(idHeaderString, idStringLength);

        String titleHeaderString = "Title";
        titleHeaderString = formatStringToFixedLength(titleHeaderString, titleStringLength);

        String authorHeaderString = "Author";
        authorHeaderString = formatStringToFixedLength(authorHeaderString, authorStringLength);

        String yearPublishedHeaderString = "Year Published";
        String headerString = idHeaderString + divider +
                titleHeaderString + divider
                + authorHeaderString + divider
                + yearPublishedHeaderString;

        return headerString;
    }

    public String getTable() {
        String bookTable = "";

        bookTable = bookTable + buildHeader() + "\n";
        bookTable = bookTable  + buildDivider() + "\n";

        for (Book book : bookList) {
            bookTable = bookTable + build(book) + "\n";
        }

        bookTable = bookTable + buildDivider();

        return bookTable;
    }

}
