import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {
    @Test
    public void name() throws Exception {
        assertEquals(Message.getWelcomeMessage(), "Welcome to Biblioteca!");
    }


}