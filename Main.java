import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String inpUser;
    public static void main(String[] agrs) {
        int opt;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("===========================================");
            System.out.println("|           WELCOME TO TRELLO             |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Login                         |");
            System.out.println("|        2. Sign up                       |");
            System.out.println("|        3. Exit                          |");
            System.out.println("===========================================");
            System.out.println("Enter your option here:");
            opt = in.nextInt();
            switch (opt) {
                case 1:
                    try {
                        login();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    FileWriter fw = null;
                    try {
                        fw = new FileWriter("login.txt", true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //taking basic team profile information and storing it in a text file.
                    // PrintWriter pw = new PrintWriter(fw);
                    Scanner sc = new Scanner(System.in);
                    // pw.println();
                    System.out.println("Enter a unique id:");
                    String id = sc.nextLine();
                    id = id.toLowerCase();
                    //pw.println(id);
                    FileReader fr = null;
                    boolean found = false;
                    try {
                        fr = new FileReader("login.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String str;
                        while ((str = br.readLine()) != null) {
                            if (str.equals(id)) {
                                found = true;
                                System.out.println("ID already exists.");
                                break;
                            }
                        }
                        br.close();
                        if (found == false) {
                            PrintWriter pw = new PrintWriter(fw);
                            pw.println();
                            pw.println(id);
                            Console console = System.console();
                            if (console == null) {
                                System.out.println("Couldn't get Console instance");
                                System.exit(0);
                            }
                            //   console.printf("Testing password%n");
                            String inpPass = String.valueOf(console.readPassword("Enter your  password: "));
                            pw.println(inpPass);
                            pw.close();
                            FileWriter f = null;
                            try {
                                f = new FileWriter("DB.txt", true);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            PrintWriter p = new PrintWriter(f);
                            p.println();
                            p.println("ID: " + id);
                            p.println("Admin Teams:");
                            p.println("Non Admin Teams:");
                            p.close();
                            System.out.println("You have been Registered, Please LogIn");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
               /* Console console = System.console();
                if (console == null) {
                    System.out.println("Couldn't get Console instance");
                    System.exit(0);
                }
                //   console.printf("Testing password%n");
                String inpPass = String.valueOf(console.readPassword("Enter your  password: "));
                pw.println(inpPass);
                pw.close();*/
                    break;
                case 3:
                    System.out.println("Thank You for using TRELLO.");
                    break;
                default:
                    System.out.println("Please choose a valid option");
                    break;
            }
        }while(opt != 3);
    }
    public static void
    login() throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your username: ");
        inpUser = keyboard.nextLine();
        inpUser = inpUser.toLowerCase();
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        //   console.printf("Testing password%n");
        String inpPass = String.valueOf(console.readPassword("Enter your  password: "));
        String str = null;
        FileReader fr = null;
        try {
            fr = new FileReader("login.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((str = br.readLine()) != null) {
                if (str.equals(inpUser)){
                    str = br.readLine();
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inpPass.equals(str)) {
            chooseOptions();

        } else {
            System.out.println("Incorrect username and password!! Please try again");
        }
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
                        //call the main function
                        CreateBoards.createBoards();
                        break;
                    case 2:
                        createteam.CreateATeam();
                        break;
                    case 3:
                        System.out.println("Go to Display Board Page");
                        break;
                    case 4:
                        createteam.displayTeam();
                        break;
                    case 5:
                        createteam.editTeam();
                        break;
                    case 6:
                        System.out.println("Exit selected");
                        break;
                    default:
                        System.out.println("Please choose a valid option");
                        break;
                }
            } while (option != 6);
        } catch (InputMismatchException e) {
            System.out.println("enter a valid number value");
            chooseOptions();
        }
    }

    private static void displayOptions() {
        System.out.println("===========================================");
        System.out.println("|           WELCOME TO TRELLO             |");
        System.out.println("===========================================");
        System.out.println("| Options:                                |");
        System.out.println("|        1. Create Board                  |");
        System.out.println("|        2. Create a new Team             |");
        System.out.println("|        3. Display Board                 |");
        System.out.println("|        4. Display Team                  |");
        System.out.println("|        5. Edit a Team                   |");
        System.out.println("|        6. Exit                          |");
        System.out.println("===========================================");
        System.out.println("Enter your option here:");

    }
    /*public static void main(String[] args) {

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
    }*/
}


