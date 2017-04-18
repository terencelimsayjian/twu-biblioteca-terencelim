import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    @Test
    public void testMainMenuDisplay() {
        String mainMenuString = "Please select an option\n" +
                "1. List Books\n" +
                "2. Quit Application";

        assertEquals(MainMenu.getOptions(), mainMenuString);
    }

    @Test
    public void testMainMenuInputListBooks() {
    }

}