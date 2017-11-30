
import java.util.*;


public class AddList_Menu {

    public static void AddList_Menu_Choice() {

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
                Lists.createLists();
                break;
            case 2:
                Lists.createCard();
            case 3:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Please select a valid option");


        }
    }
}
