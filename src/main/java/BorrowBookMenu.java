public class BorrowBookMenu implements Menu {
    LibraryBookDatabase libraryBookDatabase;
    public static String bookUnavailableMessage = "That book is not available";
    public static String bookCheckedOutMessage = "Book checked out. Enjoy your book!";

    public BorrowBookMenu(LibraryBookDatabase libraryBookDatabase) {
        this.libraryBookDatabase = libraryBookDatabase;
    }

    public String getOptions() {
        return libraryBookDatabase.availableBooksToString() + "\n" +
                "Pick book to borrow" + "\n" +
                "0: Exit this menu";
    }

    public String getResponse(int bookMenuInput) {
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



}
