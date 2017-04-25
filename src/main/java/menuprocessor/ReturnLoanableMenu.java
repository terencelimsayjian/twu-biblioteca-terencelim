package menuprocessor;

import database.LibraryLoanableDatabase;

public abstract class ReturnLoanableMenu implements Menu {
    public static String invalidLoanableMessage = "Not a valid item to return!";
    public static String loanableReturnedMessage = "Item successfully returned. Thank you!";

    LibraryLoanableDatabase libraryLoanableDatabase;
    MenuRouter menuRouter;

    public ReturnLoanableMenu(LibraryLoanableDatabase libraryLoanableDatabase, MenuRouter menuRouter) {
        this.libraryLoanableDatabase = libraryLoanableDatabase;
        this.menuRouter = menuRouter;
    }

    @Override
    public String getOptions() {
        String bookTable = getLoanableTable();

        return bookTable + "\n" +
                "Pick item to return" + "\n" +
                "0: Exit this menu";
    }

    @Override
    public String getResponse(int bookMenuInput) {
        String menuMessage = "";
        boolean succeededReturn = libraryLoanableDatabase.returnLoanable(bookMenuInput);

        if (succeededReturn) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = loanableReturnedMessage;
        } else if (bookMenuInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = "";
        } else if (!succeededReturn) {
            menuRouter.setCurrentMenu(MenuRouter.RETURN_BOOK_MENU);
            menuMessage = invalidLoanableMessage;
        }

        return menuMessage;
    }

    protected abstract String getLoanableTable();
}
