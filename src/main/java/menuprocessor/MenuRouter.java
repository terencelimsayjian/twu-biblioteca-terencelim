package menuprocessor;

import libraryservice.*;
import model.User;
import userauthentication.UserAuthenticator;

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

        BookData bookData = new BookData();
        LibraryLoanableDatabase libraryBookDatabase = new LibraryLoanableDatabase(bookData.getBooks());

        MovieData movieData = new MovieData();
        LibraryLoanableDatabase libraryMovieDatabase = new LibraryLoanableDatabase(movieData.getMovies());

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
        switch (menuIndex) {
            case 1:
                menuIndex = MAIN_MENU;
                currentMenu = mainMenu;
                break;
            case 2:
                menuIndex = BORROW_BOOK_MENU;
                currentMenu = borrowBookMenu;
                break;

            case 3:
                menuIndex = RETURN_BOOK_MENU;
                currentMenu = returnBookMenu;
                break;
            case 4:
                menuIndex = BORROW_MOVIE_MENU;
                currentMenu = borrowMovieMenu;
                break;
            case 5:
                menuIndex = RETURN_MOVIE_MENU;
                currentMenu = returnMovieMenu;
                break;
            case 6:
                menuIndex = LOGIN_MENU;
                currentMenu = loginMenu;
                break;
            default:
                quitApp();
                break;
        }
    }

    private void quitApp() {
        appRunning = false;
    }

}
