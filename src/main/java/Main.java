import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String inpUser;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
        //return matcher.matches();
    }

    public static void trelloWelcome()
    {
        int opt;
        Scanner in = new Scanner(System.in);
        try {
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
                //opt = in.nextLine();
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
                        //System.out.println("Enter a unique id:");
                        System.out.println("Enter a unique email id:");
                        String id = sc.nextLine();
                        id = id.toLowerCase();
                        boolean res = validate(id);
                        //System.out.println(res);
                        //pw.println(id);
                        if (res == true) {
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

                        } else
                            System.out.println("Invalid Email ID");
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
            } while (opt != 3);
        }catch (InputMismatchException e) {
            System.out.println("Enter a valid number value");
            //chooseOptions();
            trelloWelcome();

        }
    }

    public static void main(String[] agrs) {
        //String opt;
        trelloWelcome();
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
                        CreateBoards.createBoard();
                        break;
                    case 2:
                        if(inpUser.contains(".edu")||inpUser.contains("dell.com")||inpUser.contains("amazon.com"))
                            createteam.CreateATeam();
                        else
                            System.out.println("You are not allowed to create a team.");
                        break;
                    case 3:
                        CreateBoards.displayBoard();
                        //System.out.println("Go to Display Board Page");
                        break;
                    case 4:
                        createteam.displayTeam();
                        break;
                    case 5:
                        createteam.editTeam();
                        break;
                    case 6:
                        CreateBoards.deleteBoard();
                    case 7:
                        System.out.println("Exit selected");
                        break;
                    default:
                        System.out.println("Please choose a valid option");
                        break;
                }
            } while (option != 7);
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid number value");
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
        System.out.println("|        6. Close a Board                 |");
        System.out.println("|        7. Exit                          |");
        System.out.println("===========================================");
        System.out.println("Enter your option here:");

    }

}


