package menuprocessor;

import database.LibraryLoanableDatabase;

public class ReturnBookMenu implements Menu {
    public static String invalidReturnBookMessage = "Not a valid book to return!";
    public static String bookReturnedMessage = "model.Book successfully returned. Thank you!";

    LibraryLoanableDatabase libraryBookDatabase;
    MenuRouter menuRouter;

    public ReturnBookMenu(LibraryLoanableDatabase libraryBookDatabase, MenuRouter menuRouter) {
        this.libraryBookDatabase = libraryBookDatabase;
        this.menuRouter = menuRouter;
    }

    @Override
    public String getOptions() {
        return libraryBookDatabase.loanablesOnLoanToString() + "\n" +
                "Pick book to return" + "\n" +
                "0: Exit this menu";
    }

    @Override
    public String getResponse(int bookMenuInput){
        String menuMessage = "";
        boolean succeededReturn = libraryBookDatabase.returnLoanable(bookMenuInput);

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
