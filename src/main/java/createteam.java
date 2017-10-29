import java.io.*;
import java.util.Scanner;

public class createteam {
    public static boolean displayTeam(String name) {
        boolean found = false;
        FileReader fr = null;
        try {
            fr = new FileReader("teamprofile.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                if (str.equals("Name: " + name))
                    found = true;
                if (found == true) {
                    System.out.println(str);
                    if (str.length() == 0)
                        break;
                }
            }
            br.close();
            if (found == false)
                System.out.println("Team not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }

    public static boolean addMembers(int mem) {
        String names[] = new String[1000];

        System.out.println("Enter the Names: ");
        try {
            FileWriter fw = new FileWriter("teamprofile.txt", true);

            PrintWriter p = new PrintWriter(fw);

            p.print("Members:");
            for (int i = 0; i < mem + 1; i++) {
                Scanner sc = new Scanner(System.in);
                names[mem] = sc.next();
                p.println(names[mem]);
            }
            p.close();
            System.out.println("Members have been added.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    //following function is for creating a Team in trello.
    static void CreateATeam() {

        FileWriter fw = null;
        try {
            fw = new FileWriter("teamprofile.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //taking basic team profile information and storing it in a text file.
        PrintWriter pw = new PrintWriter(fw);
        Scanner sc = new Scanner(System.in);
        pw.println();
        System.out.println("Enter Name of the Team:");
        String name = sc.nextLine();
        pw.println("Name: " + name);
        System.out.println("Enter Website:");
        String site = sc.nextLine();
        pw.println("Website: " + site);
        System.out.println("Enter Description:");
        String desc = sc.nextLine();
        pw.println("Description: " + desc);
        pw.close();
        //Taking menu options from the user
        int value;
        String[] names = new String[100];
        int mem;
        //displaying menu
        do {
            System.out.println("===========================================");
            System.out.println("|              MENU SELECTION             |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Display Team Profile          |");
            System.out.println("|        2. Display existing Boards       |");
            System.out.println("|        3. Add Member                    |");
            System.out.println("|        4. Add Board                     |");
            System.out.println("|        5. Remove Board                  |");
            System.out.println("|        6. Exit                          |");
            System.out.println("===========================================");
            value = sc.nextInt();
            // Switching on the value given from user
            switch (value) {

                case 1:
                    //when user selects option 1 it shows the profile of the created team using the following function.
                    displayTeam(name);
                    break;
                case 2:
                    System.out.println("Boards from harshit code");
                    break;
                case 3:
                    //when the user selects option 3 we ask the number members to be added.
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Enter number of members you want to add: ");
                    mem = sc1.nextInt();
                    //we call this function to add members to the textfile.
                    addMembers(mem);
                    break;
                case 4:
                    System.out.println("Add board from harshit code");
                    break;
                case 5:
                    System.out.println("remove from the file of boards");
                    break;
                case 6:
                    System.out.println("Exit selected");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;

            }// End of switch statement

        } while (value != 6);
    }
}
