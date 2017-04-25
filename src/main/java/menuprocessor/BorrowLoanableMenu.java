package menuprocessor;

import libraryservice.LibraryLoanableDatabase;
import userauthentication.UserAuthenticator;

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

        if (UserAuthenticator.currentUser == null) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = UserAuthenticator.requiredLogin;
        } else if (userInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
        } else {
            menuMessage = processLoanableCheckout(userInput, menuMessage);
        }

        return menuMessage;
    }

    private String processLoanableCheckout(int userInput, String menuMessage) {
        boolean succeededCheckout = libraryLoanableDatabase.checkoutLoanable(userInput);

        if (succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = loanableCheckedOutMessage;
        } else if (!succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = loanableUnavailableMessage;
        }
        return menuMessage;
    }

    protected abstract String getLoanableTable();
}
