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
    public void testListBorrowedBooksResponse() {
        String menuResponse = "";
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_2_LIST_BORROWED_BOOKS);
            assertEquals(menuResponse, mainMenu.booksOnLoanMessage);
    }

    @Test
    public void testMainMenuExitResponse() {
        String menuResponse = "";
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_3_EXIT_APPLICATION);
            assertEquals(menuResponse, mainMenu.exitMessage);
    }

    @Test
    public void testMainMenuInvalidResponse() {
        String menuResponse = "";
            menuResponse = mainMenu.getResponse(42);
            assertEquals(menuResponse, mainMenu.wrongInputMessage);
    }

}