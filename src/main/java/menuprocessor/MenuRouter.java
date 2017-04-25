package menuprocessor;

import libraryservice.*;

public class MenuRouter {
    public static int EXIT = 0;
    public static int MAIN_MENU = 1;
    public static int BORROW_BOOK_MENU = 2;
    public static int RETURN_BOOK_MENU = 3;
    public static int BORROW_MOVIE_MENU = 4;
    public static int RETURN_MOVIE_MENU = 5;
    public static int LOGIN_MENU = 6;

    Menu currentMenu;
    Menu mainMenu;
    Menu borrowBookMenu;
    Menu returnBookMenu;
    Menu borrowMovieMenu;
    Menu returnMovieMenu;
    Menu loginMenu;
    public boolean appRunning = true;

    public MenuRouter() {

        StaticBookData staticBookData = new StaticBookData();
        LibraryLoanableDatabase libraryBookDatabase = new LibraryLoanableDatabase(staticBookData.getBooks());

        StaticMovieData staticMovieData = new StaticMovieData();
        LibraryLoanableDatabase libraryMovieDatabase = new LibraryLoanableDatabase(staticMovieData.getMovies());

        mainMenu = new MainMenu(this);
        borrowBookMenu = new BorrowBookMenu(libraryBookDatabase, this);
        returnBookMenu = new ReturnBookMenu(libraryBookDatabase, this);
        borrowMovieMenu = new BorrowMovieMenu(libraryMovieDatabase, this);
        returnMovieMenu = new ReturnMovieMenu(libraryMovieDatabase, this);
        loginMenu = new LoginMenu(this);

        currentMenu = mainMenu;
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
        } else if (menuIndex == BORROW_MOVIE_MENU) {
            currentMenu = borrowMovieMenu;
        } else if (menuIndex == RETURN_MOVIE_MENU) {
            currentMenu = returnMovieMenu;
        } else if (menuIndex == LOGIN_MENU) {
            currentMenu = loginMenu;
        } else {
            quitApp();
        }
    }

    private void quitApp() {
        appRunning = false;
    }

}
