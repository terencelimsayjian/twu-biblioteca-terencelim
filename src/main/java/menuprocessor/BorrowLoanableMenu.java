package menuprocessor;

import database.LibraryLoanableDatabase;

public abstract class BorrowLoanableMenu implements Menu {
    public static String loanableUnavailableMessage = "That item is not available";
    public static String loanableCheckedOutMessage = "Item checked out!";

    protected MenuRouter menuRouter;
    protected LibraryLoanableDatabase libraryLoanableDatabase;

    public BorrowLoanableMenu(LibraryLoanableDatabase libraryLoanableDatabase, MenuRouter menuRouter) {
        this.menuRouter = menuRouter;
        this.libraryLoanableDatabase = libraryLoanableDatabase;
    }

    @Override
    public String getOptions() {
        String loanableTable = getLoanableTable();

        return loanableTable + "\n" +
                "Pick item to borrow" + "\n" +
                "0: Exit this menu";
    }

    @Override
    public String getResponse(int userInput) {
        String menuMessage = "";
        boolean succeededCheckout = libraryLoanableDatabase.checkoutLoanable(userInput);

        if (succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = loanableCheckedOutMessage;
        } else if (userInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
        } else if (!succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.BORROW_BOOK_MENU);
            menuMessage = loanableUnavailableMessage;
        }

        return menuMessage;
    }

    protected abstract String getLoanableTable();
}
