import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class createteamTest {
    createteam ct = new createteam();

   /* @Test
    public void editTeam() throws Exception {
    }*/

  /*  @Test
    public void displayTeam() throws Exception {
        assertTrue(ct.displayTeam());
    }*/

    @Test
    public void displayTeamProfile() throws Exception {
        assertTrue(ct.displayTeamProfile("second"));
    }

    @Test
    public void displayTeamProfile1() throws Exception {
        assertFalse(ct.displayTeamProfile("no such team"));
    }

  /*  @Test
    public void addMembers() throws Exception {
    }

    @Test
    public void createATeam() throws Exception {
    }*/

}