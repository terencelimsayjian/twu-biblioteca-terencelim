import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void testMainMenuDisplay() {
        String mainMenuString = "Select an option\n" +
                "1. List Books\n" +
                "2. Quit Application";

        assertEquals(MainMenu.get(), mainMenuString);
    }

    @Test
    public void testMainMenuExitResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(2);
            assertEquals(menuResponse, MainMenu.exitMessage);
        } catch (Exception ex) {

        }
    }

    @Test
    public void testMainMenuInvalidResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(3);
            assertEquals(menuResponse, MainMenu.wrongInputMessage);
        } catch (Exception ex) {

        }
    }

}