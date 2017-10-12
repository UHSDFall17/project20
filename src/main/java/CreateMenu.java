import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateMenu {

    private static void displayOptions() {
        System.out.println("*******************************************************");
        System.out.println("Welcome!!Please Choose any one of the following options");

        System.out.println("1.Create Board");

        System.out.println("2.Create a new Team");

        System.out.println("3.Display Board");

        System.out.println("4.Display Team");

        System.out.println("5.Exit");
        System.out.println("*******************************************************");
        System.out.println("Enter your option here");

    }

    private static void CreateATeam() {

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
        String[] names = new String[100];
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
            System.out.println("|        6. Leave Team                    |");
            System.out.println("|        7. Exit                          |");
            System.out.println("===========================================");
            value = sc.nextInt();
            // Switching on the value given from user
            switch (value) {

                case 1:
                    FileReader fr = null;
                    try {
                        fr = new FileReader("teamprofile.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String str;
                        while ((str = br.readLine()) != null) {
                            System.out.println(str + "\n");
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
                    for (int i = 0; i < mem + 1; i++) {
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
                    System.out.println("remove name from team text file");
                    break;
                case 7:
                    System.out.println("Exit selected");
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;

            }// End of switch statement

        } while (value != 7);

    }


    private static void chooseOptions() {
        int option;
        try {
            do {
                displayOptions();
                Scanner in = new Scanner(System.in);


                option = in.nextInt();

                switch (option) {
                    case 1:
                        CreateBoard cm = new CreateBoard();
                        cm.CreateBoard();
                        break;
                    case 2:
                        CreateATeam();
                        break;
                    case 3:
                        System.out.println("Go to Display Board Page");
                        break;
                    case 4:
                        System.out.println("Go to Display Team page");

                        break;
                    case 5:
                        System.out.println("Exit selected");
                        break;
                    default:
                        System.out.println("Please choose a valid option");
                        break;
                }
            } while (option != 5);
        } catch (InputMismatchException e) {
            System.out.println("enter a valid number value");
            chooseOptions();
        }

    }


    public static void main(String[] args) {

        chooseOptions();


    }
}
