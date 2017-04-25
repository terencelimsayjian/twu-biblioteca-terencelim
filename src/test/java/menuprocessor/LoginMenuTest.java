package menuprocessor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class LoginMenuTest {
    LoginMenu loginMenu;

    @Before
    public void setUp() throws Exception {
        MenuRouter menuRouter = mock(MenuRouter.class);
        loginMenu = new LoginMenu(menuRouter);
    }

    @Test
    public void testGetResponseForLoginSuccess() throws Exception {
        String menuMessage = loginMenu.getResponse(LoginMenu.AUTHENTICATION_SUCCESS);
        assertEquals(menuMessage, LoginMenu.authenticationSuccessMessage);
    }

    @Test
    public void testGetResponseForLoginFailure() throws Exception {
        String menuMessage = loginMenu.getResponse(LoginMenu.AUTHENTICATION_FAILURE);
        assertEquals(menuMessage, LoginMenu.authenticationFailureMessage);
    }
}