package menuprocessor;

import database.LibraryBookDatabase;

public class BorrowBookMenu implements Menu {
    public static String bookUnavailableMessage = "That book is not available";
    public static String bookCheckedOutMessage = "model.Book checked out. Enjoy your book!";

    LibraryBookDatabase libraryBookDatabase;
    MenuRouter menuRouter;

    public BorrowBookMenu(LibraryBookDatabase libraryBookDatabase, MenuRouter menuRouter) {
        this.libraryBookDatabase = libraryBookDatabase;
        this.menuRouter = menuRouter;
    }

    @Override
    public String getOptions() {
        return libraryBookDatabase.availableBooksToString() + "\n" +
                "Pick book to borrow" + "\n" +
                "0: Exit this menu";
    }

    @Override
    public String getResponse(int bookMenuInput) {
        String menuMessage = "";
        boolean succeededCheckout = libraryBookDatabase.checkoutBook(bookMenuInput);

        if (succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = bookCheckedOutMessage;
        } else if (bookMenuInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = "";
        } else if (!succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.BORROW_BOOK_MENU);
            menuMessage = bookUnavailableMessage;
        }

        return menuMessage;
    }

}
