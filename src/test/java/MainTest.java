import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
    Main m = new Main();
    @Test
    public void validate() throws Exception {
        assertTrue(m.validate("phshah@uh.edu"));
    }

    @Test
    public void validate1() throws Exception {
        assertFalse(m.validate("phshah"));
    }
    /*@Test
    public void trelloWelcome() throws Exception {
    }

    @Test
    public void main() throws Exception {
    }

    @Test
    public void login() throws Exception {
    }*/

}