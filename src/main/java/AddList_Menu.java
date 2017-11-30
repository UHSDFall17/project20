
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class AddList_Menu {

    public static void AddList_Menu_Choice(String Boardname) {

        //Option to choose from
        System.out.println("*******************************************************");

        System.out.println("Welcome!!Please Choose any one of the following options");

        System.out.println("1.Add List");

        System.out.println("2.Create Card from Existing lists");

        System.out.println("3.Exit");

        System.out.println("*******************************************************");
        System.out.println("Enter your option below");

        int option;

        Scanner in = new Scanner(System.in);

        option = in.nextInt();
        // Switch case for choosing option
        switch (option) {
            case 1:

                Lists.createLists(Boardname);
                break;
            case 2:

                boolean found = false;
                FileReader fr1 = null;
                try {
                    fr1 = new FileReader("BoardDetails.txt");
                    BufferedReader br = new BufferedReader(fr1);
                    String str;
                    while ((str = br.readLine()) != null) {
                        if (str.contains("Board: " + Boardname))
                            found = true;
                        if (found && str.contains("List:")) {
                            System.out.println(str);
                            if (str.length() == 0)
                                break;
                        }
                    }
                    br.close();
                    if (!found)
                        System.out.println("Board not found");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter a list to add card:");
                Scanner c = new Scanner(System.in);
                String l = c.nextLine();
                Lists.createCardUnderList(l);
                break;
            case 3:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Please select a valid option");


        }
    }
}
