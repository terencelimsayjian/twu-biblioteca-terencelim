import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {

    @Test
    public void testListAvailableBookResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_1_LIST_AVAILABLE_BOOKS);
            assertEquals(menuResponse, mainMenu.availableBookMessage);
        } catch (Exception ex) {

        }
    }

    @Test
    public void testListBorrowedBooksResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_2_LIST_BORROWED_BOOKS);
            assertEquals(menuResponse, mainMenu.booksOnLoanMessage);
        } catch (Exception ex) {

        }
    }

    @Test
    public void testMainMenuExitResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(mainMenu.OPTION_3_EXIT_APPLICATION);
            assertEquals(menuResponse, mainMenu.exitMessage);
        } catch (Exception ex) {

        }
    }

    @Test
    public void testMainMenuInvalidResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(42);
            assertEquals(menuResponse, mainMenu.wrongInputMessage);
        } catch (Exception ex) {

        }
    }

}