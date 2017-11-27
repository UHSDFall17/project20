import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


class CreateBoards {

   /* public static void
    login() throws FileNotFoundException {

        Scanner scan = new Scanner(new File("login.txt"));
        Scanner keyboard = new Scanner(System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine(); // looks at selected file in scan

        System.out.println("Enter your username: ");
        String inpUser = keyboard.nextLine();
        //System.out.println("Enter your password: ");
        // String inpPass = keyboard.nextLine();
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        //   console.printf("Testing password%n");
        String inpPass = String.valueOf(console.readPassword("Enter your  password: "));

        if (inpUser.equals(user) && inpPass.equals(pass)) {
            System.out.print("Welcome to Trello" + " " + user);
            chooseOptions();

        } else {
            System.out.print("Incorrect username and password!! Please try again");
        }
    }*/

  /*  private static void displayOptions() {
        System.out.println("*******************************************************");
        System.out.println("Welcome!!Please Choose any one of the following options");

        System.out.println("1.Create Board");

        System.out.println("2.Create a new Team");

        System.out.println("3.Display Board");

        System.out.println("4.Display Team");

        System.out.println("5.Exit");
        System.out.println("*******************************************************");
        System.out.println("Enter your option here");

    }*/

    //Create Boards method
    public static void createBoards() {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("");
        System.out.println(" ************Welcome to Trello************ ");
        System.out.println("===========================================");
        System.out.println("|              MENU SELECTION             |");
        System.out.println("===========================================");
        System.out.println("| Options:                                |");
        System.out.println("|        1. Display Boards                |");
        System.out.println("|        2. Create Board                  |");
        System.out.println("|        3. Remove Board                  |");
        System.out.println("|        4. Add Team                      |");
        //System.out.println("|        5. Remove Board                  |");
        System.out.println("|        5. Exit                          |");
        System.out.println("===========================================");

        int choice;

        do {

            String key = scanner.next();
            choice = Integer.parseInt(key);

            switch (choice)
            //switch(key)
            {

                case 1:
                    System.out.println("Existing Boards:");

                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader("input.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    try {
                        String txtFile1;
                        int i = 0;
                        while ((txtFile1 = br.readLine()) != null) {
                            //String word1 = br.readLine();
                            //String word1 = list1.get(i);
                            System.out.println(txtFile1);
                            //System.out.println(word1);
                            i++;
                        }
                    } catch (IOException e) {

                        e.printStackTrace();

                    } finally {

                        try {

                            if (br != null)
                                br.close();

                        } catch (IOException ex) {

                            ex.printStackTrace();

                        }

                    }

                    break;

                case 2:
                    System.out.println("Welcome to Board");
                    System.out.println("Enter the Board Name: ");
                    //String name = scanner.nextLine();
                    //String name = reader1.readLine();
                    //System.out.println(name);

                    try {
                        String name = reader1.readLine();
                        //System.out.println(name);
                        FileWriter writer = new FileWriter("input.txt", true);
                        writer.write(name);
                        writer.write("\r\n");   // write new line
                        //writer.write("Good Bye!");
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

						/*	BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\Harshit\\Downloads\\output.txt"));

							try {
									String txtFile1; int i = 0;
									while((txtFile1 = br1.readLine()) != null)
									{
										//String word1 = br.readLine();
										//String word1 = list1.get(i);
										System.out.println(txtFile1);
										//System.out.println(word1);
										i++;
									}
								} catch (IOException e) {

										e.printStackTrace();

									}

							System.out.println("Board created: "+name);
						*/

                    //System.out.println(br);
                    break;

                case 3:
                    System.out.println("Board to be deleted");

                    try {

                        File inputFile = new File("output.txt");
                        File tempFile = new File("tmp.txt");

                        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                        //String lineToRemove = "bbb";
                        System.out.println("Enter the board name to be deleted:");
                        String lineToRemove = scanner.next();
                        String currentLine;


                        while ((currentLine = reader.readLine()) != null) {
                            // trim newline when comparing with lineToRemove
                            String trimmedLine = currentLine.trim();
                            if (trimmedLine.equals(lineToRemove)) continue;
                            writer.write(currentLine + System.getProperty("line.separator"));
                            writer.close();
                            reader.close();
                            boolean successful = tempFile.renameTo(inputFile);
                        }
                    } catch (IOException e) {

                        e.printStackTrace();

                    }/*finally {

										try {
												if (writer != null)
													writer.close();

												if (reader != null)
													reader.close();
											}catch (IOException ex) {

												ex.printStackTrace();

											}

										 }*/


                    //boolean successful = tempFile.renameTo(inputFile);

                    //Call the add team module
                    break;

                case 4:
                    System.out.println("Add Team");
                    //Call the add team module
                    break;

                default:
                    System.out.println("Bye bye!! See you soon!");

            }
        } while (choice != 5);

        //System.out.println("Make another choice:");
        //int key1 = scanner.nextInt();
    }

  /* private static void chooseOptions() {
        int option;

        try {
            do {
                displayOptions();
                Scanner in = new Scanner(System.in);


                option = in.nextInt();

                switch (option) {
                    case 1:
                        //call the main function

                        createBoards();
                        break;
                    case 2:
                        CreateATeam();
                        break;
                    case 3:
                        System.out.println("Go to Display Board Page");
                        break;
                    case 4:
                        String name;
                        Scanner in1 = new Scanner(System.in);
                        System.out.println("Enter the name of the team");
                        name = in1.nextLine();
                        displayTeam(name);
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

    }*/

   /* public static boolean displayTeam(String name) {
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
    private static void CreateATeam() {

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
*/
   /* public static void main(String[] agrs) {
        {
            try {
                login();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }*/
}
