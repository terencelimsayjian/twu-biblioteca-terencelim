import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void testMainMenuExitResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(3);
            assertEquals(menuResponse, MainMenu.exitMessage);
        } catch (Exception ex) {

        }
    }

    @Test
    public void testMainMenuInvalidResponse() {
        MainMenu mainMenu = new MainMenu();
        String menuResponse = "";
        try {
            menuResponse = mainMenu.getResponse(4);
            assertEquals(menuResponse, MainMenu.wrongInputMessage);
        } catch (Exception ex) {

        }
    }

}