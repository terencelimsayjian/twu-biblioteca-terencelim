import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    @Test
    public void testApp() throws Exception {
        assertEquals(BibliotecaApp.getSomething(), "Hello World");
    }
}