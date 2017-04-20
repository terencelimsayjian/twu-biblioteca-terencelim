package menuprocessor;

import database.LibraryBookDatabase;

public class ReturnBookMenu implements Menu {
    public static String invalidReturnBookMessage = "Not a valid book to return!";
    public static String bookReturnedMessage = "model.Book successfully returned. Thank you!";

    LibraryBookDatabase libraryBookDatabase;
    MenuRouter menuRouter;

    public ReturnBookMenu(LibraryBookDatabase libraryBookDatabase, MenuRouter menuRouter) {
        this.libraryBookDatabase = libraryBookDatabase;
        this.menuRouter = menuRouter;
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
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = bookReturnedMessage;
        } else if (bookMenuInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = "";
        } else if (!succeededReturn) {
            menuRouter.setCurrentMenu(MenuRouter.RETURN_BOOK_MENU);
            menuMessage = invalidReturnBookMessage;
        }

        return menuMessage;
    }

}
