package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("terence", "111-1111", "test123");
    }

    @Test
    public void testGetters() throws Exception {
        assertEquals(user.getName(), "terence");
        assertEquals(user.getLibraryId(), "111-1111");
    }

    @Test
    public void testUserValidation() throws Exception {
        assertEquals(user.validate("111-1111", "test123"), true);
    }

    @Test
    public void testWrongLibraryId() throws Exception {
        assertEquals(user.validate("111-111", "test123"), false);
    }

    @Test
    public void testWrongPassword() throws Exception {
        assertEquals(user.validate("111-1111", "test1234"), false);
    }
}