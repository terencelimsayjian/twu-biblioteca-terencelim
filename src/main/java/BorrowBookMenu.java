public class BorrowBookMenu implements Menu {
    LibraryBookDatabase libraryBookDatabase;
    public static String bookUnavailableMessage = "That book is not available";
    public static String bookCheckedOutMessage = "Book checked out. Enjoy your book!";
    private int nextMenu;

    public BorrowBookMenu(LibraryBookDatabase libraryBookDatabase) {
        this.libraryBookDatabase = libraryBookDatabase;
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
            nextMenu = MenuRouter.MAIN_MENU;
            menuMessage = bookCheckedOutMessage;
        } else if (bookMenuInput == MenuRouter.EXIT) {
            nextMenu = MenuRouter.MAIN_MENU;
            menuMessage = "";
        } else if (!succeededCheckout) {
            nextMenu = MenuRouter.BORROW_BOOK_MENU;
            menuMessage = bookUnavailableMessage;
        }

        return menuMessage;
    }

    @Override
    public int getNextMenuId() {
        return nextMenu;
    }


}
