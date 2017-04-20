public class ReturnBookMenu implements Menu {
    LibraryBookDatabase libraryBookDatabase;
    public static String invalidReturnBookMessage = "Not a valid book to return!";
    public static String bookReturnedMessage = "Book successfully returned. Thank you!";

    public ReturnBookMenu(LibraryBookDatabase libraryBookDatabase) {
        this.libraryBookDatabase = libraryBookDatabase;
    }

    public String getOptions() {
        return libraryBookDatabase.booksOnLoanToString() + "\n" +
                "Pick book to return" + "\n" +
                "0: Exit this menu";
    }

    public String getResponse(int bookMenuInput){
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
