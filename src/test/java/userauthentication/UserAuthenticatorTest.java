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
        userAuthenticator = new UserAuthenticator();
        boolean authenticatedUser = userAuthenticator.authenticate("111-1111", "test123");

        assertEquals(authenticatedUser, true);
    }

    @Test
    public void testWrongLibraryId() throws Exception {
        userAuthenticator = new UserAuthenticator();
        boolean authenticatedUser = userAuthenticator.authenticate("111-1112", "test123");

        assertEquals(authenticatedUser, false);
    }

    @Test
    public void testSetCurrentUser() throws Exception {
        userAuthenticator = new UserAuthenticator();
        userAuthenticator.authenticate("222-2222", "test123");

        assertEquals(UserAuthenticator.currentUser != null, true);
    }
}