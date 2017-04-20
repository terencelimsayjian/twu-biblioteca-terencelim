import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuRouterTest {
    @Test
    public void testMainMenu() throws Exception {
        Menu mockMenu = mock(Menu.class);

        when(mockMenu.getNextMenuId()).thenReturn(1);

    }
}