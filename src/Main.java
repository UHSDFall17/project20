import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {

        FileWriter fw = null;
        try {
            fw = new FileWriter("teamprofile.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        int value;
        String [] names = new String[100];
        int mem;

        do {
            // Setting menuOption equal to return value from showMenu();
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
                    displayTeam(name);
                    break;
                case 2:
                    System.out.println("Boards from harshit code");
                    break;
                case 3:
                    System.out.println("Enter number of members you want to add: ");
                    mem = sc.nextInt();
                    System.out.println("Enter the Names: ");
                    try {
                        fw = new FileWriter("teamprofile.txt", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PrintWriter p = new PrintWriter(fw);
                    p.print("Members:");
                    for(int i=0 ; i<mem+1 ; i++)
                    {
                        names[mem] = sc.nextLine();
                        p.println(names[mem]);
                    }
                    p.close();
                    System.out.println("Members have been added.");
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
    public static void displayTeam(String name){
        int found = 0;
        FileReader fr = null;
        try {
            fr = new FileReader("teamprofile.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                if (str.equals("Name: " + name))
                    found = 1;
                if (found == 1) {
                    out.println(str);
                    if (str.length() == 0)
                        break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


