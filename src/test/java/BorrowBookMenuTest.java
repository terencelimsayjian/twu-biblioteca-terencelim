import libraryservice.LibraryLoanableDatabase;
import menuprocessor.BorrowBookMenu;
import menuprocessor.MenuRouter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BorrowBookMenuTest {
    LibraryLoanableDatabase libraryBookDatabase;
    MenuRouter menuRouter;
    BorrowBookMenu borrowBookMenu;

    @Before
    public void setUp() throws Exception {
        libraryBookDatabase = mock(LibraryLoanableDatabase.class);
        menuRouter = mock(MenuRouter.class);
        borrowBookMenu = new BorrowBookMenu(libraryBookDatabase, menuRouter);
    }

    @Test
    public void testBorrowBook() throws Exception {
        String response = borrowBookMenu.getResponse(MenuRouter.EXIT);
        assertEquals(response, "");
    }
}