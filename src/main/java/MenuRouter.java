public class MenuRouter {
    public static int EXIT = 0;
    public static int MAIN_MENU = 1;
    public static int BORROW_BOOK_MENU = 2;
    public static int RETURN_BOOK_MENU = 3;
    Menu currentMenu;
    Menu mainMenu;
    Menu borrowBookMenu;
    Menu returnBookMenu;

    public MenuRouter() {
        LibraryBookDatabase libraryBookDatabase = new LibraryBookDatabase();

        mainMenu = new MainMenu();
        borrowBookMenu = new BorrowBookMenu(libraryBookDatabase);
        returnBookMenu = new ReturnBookMenu(libraryBookDatabase);

        this.currentMenu = mainMenu;
    }

    public String getResponse(int userInput) {
        return currentMenu.getResponse(userInput);
    }

    public String getOptions() {
        return currentMenu.getOptions();
    }

    public void getNextMenu() throws Exception {
        int bookMenuIndex = currentMenu.getNextMenuId();

        if (bookMenuIndex == MAIN_MENU) {
            currentMenu = mainMenu;
        } else if (bookMenuIndex == BORROW_BOOK_MENU) {
            currentMenu = borrowBookMenu;
        } else if (bookMenuIndex == RETURN_BOOK_MENU) {
            currentMenu = returnBookMenu;
        } else {
            throw new Exception();
        }
    }


}
