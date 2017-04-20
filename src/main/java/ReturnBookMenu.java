public class ReturnBookMenu implements Menu {
    LibraryBookDatabase libraryBookDatabase;
    public static String invalidReturnBookMessage = "Not a valid book to return!";
    public static String bookReturnedMessage = "Book successfully returned. Thank you!";
    private int nextMenu;

    public ReturnBookMenu(LibraryBookDatabase libraryBookDatabase) {
        this.libraryBookDatabase = libraryBookDatabase;
    }

    @Override
    public String getOptions() {
        return libraryBookDatabase.booksOnLoanToString() + "\n" +
                "Pick book to return" + "\n" +
                "0: Exit this menu";
    }

    @Override
    public String getResponse(int bookMenuInput){
        String menuMessage = "";
        boolean succeededReturn = libraryBookDatabase.returnBook(bookMenuInput);

        if (succeededReturn) {
            nextMenu = MenuRouter.MAIN_MENU;
            menuMessage = bookReturnedMessage;
        } else if (bookMenuInput == MenuRouter.EXIT) {
            nextMenu = MenuRouter.MAIN_MENU;
            menuMessage = "";
        } else if (!succeededReturn) {
            nextMenu = MenuRouter.RETURN_BOOK_MENU;
            menuMessage = invalidReturnBookMessage;
        }

        return menuMessage;
    }

    @Override
    public int getNextMenuId() {
        return nextMenu;
    }
}
