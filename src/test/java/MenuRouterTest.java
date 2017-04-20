import menuprocessor.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MenuRouterTest {
    MenuRouter menuRouter;

    @Before
    public void setUp() throws Exception {
        menuRouter = new MenuRouter();
    }

    @Test
    public void testMainMenu() throws Exception {
        menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
        assertEquals(menuRouter.getCurrentMenu() instanceof MainMenu, true);
    }

    @Test
    public void testBorrowBookMenu() throws Exception {
        menuRouter.setCurrentMenu(MenuRouter.BORROW_BOOK_MENU);
        assertEquals(menuRouter.getCurrentMenu() instanceof BorrowBookMenu, true);
    }

    @Test
    public void testReturnBookMenu() throws Exception {
        menuRouter.setCurrentMenu(MenuRouter.RETURN_BOOK_MENU);
        assertEquals(menuRouter.getCurrentMenu() instanceof ReturnBookMenu, true);
    }
}