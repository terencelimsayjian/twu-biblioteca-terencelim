package menuprocessor;

import database.LibraryLoanableDatabase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BorrowMovieMenuTest {
    LibraryLoanableDatabase libraryBookDatabase;
    MenuRouter menuRouter;
    BorrowMovieMenu borrowMovieMenu;

    @Before
    public void setUp() throws Exception {
//        libraryBookDatabase = mock(LibraryBookDatabase.class);
        menuRouter = new MenuRouter();
        borrowMovieMenu = new BorrowMovieMenu(menuRouter);
    }

    @Test
    public void testBorrowBook() throws Exception {
        String response = borrowMovieMenu.getResponse(MenuRouter.EXIT);
        assertEquals(response, "");
        assertEquals(menuRouter.getCurrentMenu() instanceof MainMenu, true);
    }
}