public class BookMenu {
    LibraryBookDatabase libraryBookDatabase = new LibraryBookDatabase();
    public static String bookUnavailableMessage = "That book is not available";
    public static String bookCheckedOutMessage = "Book checked out. Enjoy your book!";
    public static String invalidReturnBookMessage = "Not a valid book to return!";
    public static String bookReturnedMessage = "Book successfully returned. Thank you!";

    public String getAvailableBooks() {
        return libraryBookDatabase.availableBooksToString();
    }

    public String getBorrowedBooks() {
        return libraryBookDatabase.booksOnLoanToString();
    }

    public String getBookCheckoutResponse(int bookMenuInput) {
        String menuMessage = "";
        Book checkedOutBook = libraryBookDatabase.checkoutBook(bookMenuInput);

        if (bookMenuInput == 0) {

        } else if (checkedOutBook == null) {
            menuMessage = bookUnavailableMessage;
        } else {
            menuMessage = bookCheckedOutMessage;
        }

        return menuMessage;
    }

    public String getBookReturnResponse(int bookMenuInput){
        String menuMessage = "";
        Book checkedOutBook = libraryBookDatabase.returnBook(bookMenuInput);

        if (bookMenuInput == 0) {

        } else if (checkedOutBook == null) {
            menuMessage = invalidReturnBookMessage;
        } else {
            menuMessage = bookReturnedMessage;
        }

        return menuMessage;
    }

}
