package helper;

import model.Book;

public class BookStringBuilder {
    public int idStringLength = 3;
    public int titleStringLength = 40;
    public int authorStringLength = 20;
    public int yearPublishedStringLength = 14;
    public String divider = " | ";
    public int totalStringLength;

    public BookStringBuilder() {
        totalStringLength = idStringLength + divider.length() +
                titleStringLength + divider.length() +
                authorStringLength + divider.length() + yearPublishedStringLength;
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
        return appendSpaces(yearPublishedString, yearPublishedStringLength);
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

    public String buildDivider() {
        String dividerString = "";

        for (int i = 0; i < totalStringLength; i++) {
            dividerString += "-";
        }

        return dividerString;
    }

    private String formatStringToFixedLength(String subject, int desiredTitleStringLength) {
        String titleString;

        if (subject.length() > desiredTitleStringLength) {
            titleString = subject.substring(0, desiredTitleStringLength - 3) + "...";
        } else {
            titleString = appendSpaces(subject, desiredTitleStringLength);
        }
        return titleString;
    }

    private String appendSpaces(String subject, int desiredTitleStringLength) {
        int remainingSpaces = desiredTitleStringLength - subject.length();

        for (int i = 0; i < remainingSpaces; i++) {
            subject = subject + " ";
        }
        return subject;
    }
}
