package menuprocessor;

import menuprocessor.MainMenu;
import menuprocessor.MenuRouter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {
    MainMenu mainMenu;
    MenuRouter menuRouter;

    @Before
    public void setUp() throws Exception {
        menuRouter = new MenuRouter();
        mainMenu = new MainMenu(menuRouter);
    }

    @Test
    public void testListAvailableBookResponse() {
        String menuResponse = "";
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_1_LIST_AVAILABLE_BOOKS);
            assertEquals(menuResponse, mainMenu.availableBookMessage);
    }

    @Test
    public void testListAvailableMoviesResponse() {
        String menuResponse = "";
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_2_LIST_AVAILABLE_MOVIES);
            assertEquals(menuResponse, mainMenu.availableMovieMessage);
    }

    @Test
    public void testListBorrowedBooksResponse() {
        String menuResponse = "";
        menuResponse = mainMenu.getResponse(mainMenu.OPTION_3_LIST_BORROWED_BOOKS);
        assertEquals(menuResponse, mainMenu.booksOnLoanMessage);
    }

    @Test
    public void testListBorrowedMoviesResponse() {
        String menuResponse = "";
        menuResponse = mainMenu.getResponse(mainMenu.OPTION_4_LIST_BORROWED_MOVIES);
        assertEquals(menuResponse, mainMenu.moviesOnLoanMessage);
    }

    @Test
    public void testLoginResponse() {
        String menuResponse = "";
        menuResponse = mainMenu.getResponse(mainMenu.OPTION_5_LOGIN);
        assertEquals(menuResponse, mainMenu.loginMessage);
    }

    @Test
    public void testMainMenuExitResponse() {
        String menuResponse = "";
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_0_EXIT_APPLICATION);
            assertEquals(menuResponse, mainMenu.exitMessage);
    }

    @Test
    public void testMainMenuInvalidResponse() {
        String menuResponse = "";
            menuResponse = mainMenu.getResponse(42);
            assertEquals(menuResponse, mainMenu.wrongInputMessage);
    }

}