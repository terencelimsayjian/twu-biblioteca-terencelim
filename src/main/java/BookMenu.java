public class BookMenu {
    LibraryBookDatabase libraryBookDatabase = new LibraryBookDatabase();
    public static String bookUnavailableMessage = "That book is not available";
    public static String bookCheckedOutMessage = "Book checked out. Enjoy your book!";
    public static String invalidReturnBookMessage = "Not a valid book to return!";
    public static String bookReturnedMessage = "Book successfully returned. Thank you!";

    public String getAvailableBooks() {
        return libraryBookDatabase.availableBooksToString() + "\n" +
                "Pick book to borrow" + "\n" +
                "0: Exit this menu";
    }

    public String getBorrowedBooks() {
        return libraryBookDatabase.booksOnLoanToString() + "\n" +
                "Pick book to return" + "\n" +
                "0: Exit this menu";
    }

    public String getBookCheckoutResponse(int bookMenuInput) {
        String menuMessage = "";
        boolean succeededCheckout = libraryBookDatabase.checkoutBook(bookMenuInput);

        if (succeededCheckout) {
            menuMessage = bookCheckedOutMessage;
        } else if (bookMenuInput == 0) {
            menuMessage = "";
        } else if (!succeededCheckout) {
            menuMessage = bookUnavailableMessage;
        }

        return menuMessage;
    }

    public String getBookReturnResponse(int bookMenuInput){
        String menuMessage = "";
        boolean succeededReturn = libraryBookDatabase.returnBook(bookMenuInput);

        if (succeededReturn) {
            menuMessage = bookReturnedMessage;
        } else if (bookMenuInput == 0) {
            menuMessage = "";
        } else if (!succeededReturn) {
            menuMessage = invalidReturnBookMessage;
        }

        return menuMessage;
    }

}
