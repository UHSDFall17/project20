import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class CreateMenuTest {

    private CreateMenu cm = new CreateMenu();


    @Test
    public void displayTeamTest() throws Exception {

        assertTrue(cm.displayTeam("Team20"));
    }


    @org.junit.Test
    public void main() throws Exception {
        File file = new File("teamprofile.txt");
        assertTrue(file.exists());

    }


}