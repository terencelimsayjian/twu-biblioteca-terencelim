package menuprocessor;

import database.LibraryBookDatabase;

public class MenuRouter {
    public static int EXIT = 0;
    public static int MAIN_MENU = 1;
    public static int BORROW_BOOK_MENU = 2;
    public static int RETURN_BOOK_MENU = 3;
    Menu currentMenu;
    Menu mainMenu;
    Menu borrowBookMenu;
    Menu returnBookMenu;
    public boolean appRunning;

    public MenuRouter() {
        LibraryBookDatabase libraryBookDatabase = new LibraryBookDatabase();

        mainMenu = new MainMenu(this);
        borrowBookMenu = new BorrowBookMenu(libraryBookDatabase, this);
        returnBookMenu = new ReturnBookMenu(libraryBookDatabase, this);

        currentMenu = mainMenu;
        appRunning = true;
    }

    public String getResponse(int userInput) {
        return currentMenu.getResponse(userInput);
    }

    public String getOptions() {
        return currentMenu.getOptions();
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(int menuIndex) {
        if (menuIndex == MAIN_MENU) {
            currentMenu = mainMenu;
        } else if (menuIndex == BORROW_BOOK_MENU) {
            currentMenu = borrowBookMenu;
        } else if (menuIndex == RETURN_BOOK_MENU) {
            currentMenu = returnBookMenu;
        } else {
            quitApp();
        }
    }

    private void quitApp() {
        appRunning = false;
    }

}
