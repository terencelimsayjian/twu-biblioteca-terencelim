package userauthentication;

import model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAuthenticatorTest {
    UserAuthenticator userAuthenticator;

    @Before
    public void setUp() throws Exception {
        userAuthenticator = new UserAuthenticator();
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        UserAuthenticator userAuthenticator = new UserAuthenticator();
        User authenticatedUser = userAuthenticator.authenticate("111-1111", "test123");

        assertEquals(authenticatedUser != null, true);
    }

    @Test
    public void testWrongLibraryId() throws Exception {
        UserAuthenticator userAuthenticator = new UserAuthenticator();
        User authenticatedUser = userAuthenticator.authenticate("111-1112", "test123");

        assertEquals(authenticatedUser, null);
    }
}