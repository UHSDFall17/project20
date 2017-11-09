import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.Console;

//CreateBoards Class
class CreateBoards
{
	//Function for login into Trello 
	public static void login() throws FileNotFoundException 
	{
	    Scanner scan = new Scanner (new File("C:\\Users\\Harshit\\Downloads\\Software Design Project\\login.txt"));
	    Scanner keyboard = new Scanner (System.in);
	    String user = scan.nextLine();
	    String pass = scan.nextLine(); // looks at selected file in scan
	    
		//Login functionality of Trello
	    System.out.println("Enter your username: ");
	    String inpUser = keyboard.nextLine();
		Console console = System.console();
        if (console == null) 
		{
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

		//Password protection
        char passwordArray[] = console.readPassword("Enter your password: ");
		String inpPass = new String(passwordArray);

		//Passwod authentication
	    if (inpUser.equals(user) && inpPass.equals(pass)) {
	        System.out.println("Welcome to Trello"+" "+user);
	    } else {
	        System.out.print("Incorrect username and password!! Please try again");
			System.exit(0);
	    }
	}
	
	//Main function
	
	public static void main (String[] agrs) throws FileNotFoundException 
	{
		{	
			//call to the login() function
			login();

			Scanner scanner = new Scanner(System.in);
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
		
			int choice;
			//Loop condtion for each of the menu
			do{
				/*
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
				*/
				
				String key = scanner.next();
				choice = Integer.parseInt(key);
				
				switch(choice)
				//switch(key)
				{
			
					case 1: System.out.println("Existing Boards:");
						
							BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Harshit\\Downloads\\Software Design Project\\input.txt"));
						
							try {
								String txtFile1; int i = 0;
								while((txtFile1 = br.readLine()) != null)
								{
									System.out.println(txtFile1);
									i++;
								}	
							} catch (IOException e) {

									e.printStackTrace();

								}finally {

										try {

												if (br != null)
												br.close();

											} catch (IOException ex) {

												ex.printStackTrace();
											}
										}
							break;		
						
					case 2: System.out.println("Welcome to Board");
							System.out.println("Enter the Board Name: ");
						
							try {	String name = reader1.readLine(); 
									//System.out.println(name);
									FileWriter writer = new FileWriter("C:\\Users\\Harshit\\Downloads\\Software Design Project\\input.txt", true);
									writer.write(name);
									writer.write("\r\n");   // write new line
									//writer.write("Good Bye!");
									writer.close();
								} catch (IOException e) {
									e.printStackTrace();
								}

							System.out.println("");
							System.out.println("Board added successfuly...!!!");
							break;
						
					case 3: System.out.println("Board to be deleted");
						
						try {
						
						File inputFile = new File("C:\\Users\\Harshit\\Downloads\\output.txt");
						File tempFile = new File("C:\\Users\\Harshit\\Downloads\\tmp.txt");
						
						BufferedReader reader = new BufferedReader(new FileReader(inputFile));
						BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

						//String lineToRemove = "bbb";
						System.out.println("Enter the board name to be deleted:");
						String lineToRemove = scanner.next();
						String currentLine;
						
						
							while((currentLine = reader.readLine()) != null) 
							{
								// trim newline when comparing with lineToRemove
								String trimmedLine = currentLine.trim();
								if(trimmedLine.equals(lineToRemove)) continue;
									writer.write(currentLine + System.getProperty("line.separator"));
									writer.close();
									reader.close();
									boolean successful = tempFile.renameTo(inputFile);
							}
						} catch (IOException e) {

									e.printStackTrace();

								}
							System.out.println("");
							System.out.println("Board deleted successfuly...!!!");
							break;
						
					case 4: System.out.println("Rename Board");
							//Call the add team module
							break;
						
					default: System.out.println("Bye bye!! See you soon!");
			
				}
			}while(choice!=5);

		}
	}
}