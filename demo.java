import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;


class demo
{
public static void main (String[] agrs) throws FileNotFoundException {
	{	
		System.out.println("");
		System.out.println("*****Welcome to Trello*****");
		System.out.println("");
		System.out.println("############ Menu ############");
		//System.out.println("");
		//System.out.println("Personal Boards: Welcome to Board");
		System.out.println("");
		//System.out.println("Welcome to Board");
		Scanner scanner = new Scanner(System.in);
		System.out.println("List Existing Boards: press 1");
		System.out.println("Create Board: press 2");
		System.out.println("Delete the Board: press 3");
		System.out.println("Add Team: press 4");
		System.out.println("Exit: press 5");
	
	
		int choice;
		
		do{
			
		String key = scanner.next();
		choice = Integer.parseInt(key);
		
		switch(choice)
		//switch(key)
		{
		
			case 1: System.out.println("Existing Boards:");
				
					BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Harshit\\Downloads\\input.txt"));
				
					try {
						String txtFile1; int i = 0;
						while((txtFile1 = br.readLine()) != null)
						{
							//String word1 = br.readLine();
							//String word1 = list1.get(i);
							System.out.println(txtFile1);
							//System.out.println(word1);
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
					String name = scanner.next();
				
					try {
							FileWriter writer = new FileWriter("C:\\Users\\Harshit\\Downloads\\input.txt", true);
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
				
			case 4: System.out.println("Add Team");
					//Call the add team module
					break;
				
			default: System.out.println("Bye bye!! See you soon!");
		
		}
		}while(choice!=5);
		
		//System.out.println("Make another choice:");
		//int key1 = scanner.nextInt();
}
}
}