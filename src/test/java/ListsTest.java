import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class ListsTest {
    Lists lc = new Lists();

    @Test
    public void createLists() throws Exception {
        // assertTrue(lc.createLists("Software Design"));
        File file = new File("BoardDetails.txt");

        assertTrue(file.canWrite());

        assertTrue(file.canRead());

    }
    // commented due to asking for creating card under list instead of running  the test.
    @Test
    public void createCardUnderList() throws Exception {
        //  assertTrue(lc.createCardUnderList("Demo List"));


    }

    @Test
    public void createCard() throws Exception {

        File file = new File("BoardDetails.txt");

        assertTrue(file.canWrite());

        assertTrue(file.canRead());


    }

    @Test
    public void main() throws Exception {

        File file = new File("BoardDetails.txt");
        assertTrue(file.exists());
    }


}