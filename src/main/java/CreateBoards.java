import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


class CreateBoards {

    public static void createBoard()
    {   //Create Board
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Board Name: ");
        String board = scanner.nextLine();

        String[] teams = new String[100];
        boolean foun = false;
        FileReader fr = null;
        try {
            fr = new FileReader("DB.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            int i = 0;

            while ((str = br.readLine()) != null) {
                if (str.equals("ID: " + Main.inpUser))
                    foun = true;
                if (foun == true && ((str.contains("Team Name: ")) || str.contains("Name: "))) {
                    String[] parts = str.split(": ");
                    teams[i] = parts[1];
                    i++;
                    System.out.println(i + ")" + parts[1]);
                }
                if (foun == true && str.length() == 0)
                    break;
            }
            br.close();
            if (foun == false)
                System.out.println("Teams not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //List Boards
        System.out.println("Select a team from above list to add Board:");
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String oldFileName = "DB.txt";
        String tmpFileName = "tmp_try.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));
            String line;
            boolean f = false;
            while ((line = br.readLine()) != null) {
                bw.write(line+"\n");
                if (line.equals("ID: " + Main.inpUser))
                    f = true;
                if (f == true && line.contains(teams [s-1])) {
                    bw.write("Board: " + board+"\n");
                    f = false;
                }

            }
        } catch (Exception e) {
            return;
        } finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                //
            }
            try {
                if(bw != null)
                    bw.close();
            } catch (IOException e) {
                //
            }
        }
        // Once everything is complete, delete old file..
        File oldFile = new File(oldFileName);
        oldFile.delete();

        // And rename tmp file's name to old file name
        File newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);
        System.out.println("Board added successfuly...!!!");


        // Board Details
        try {	//String name = reader1.readLine();
            //System.out.println(name);
            FileWriter writer = new FileWriter("BoardDetails.txt", true);
            writer.write("\nBoard: " + board+" "+"Team: "+teams [s-1]+"\n");
            //writer.write("\r\n");   // write new line
            //writer.write("Good Bye!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void displayBoard(){
        boolean found = false;
        FileReader fr1 = null;
        try {
            fr1 = new FileReader("DB.txt");
            BufferedReader br = new BufferedReader(fr1);
            String str;
            while ((str = br.readLine()) != null) {
                if (str.equals("ID: " + Main.inpUser))
                    found = true;
                if (found == true && !(str.equals("Admin Teams:") || str.equals("Non Admin Teams:") ) ) {
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

    }

    public static void deleteBoard()
    {
        displayBoard();
        System.out.println("Enter the board to be closed:");
        Scanner sc = new Scanner(System.in);

        String renameBoard = sc.nextLine();
        String oldBoard = "DB.txt";
        String tmpBoard = "tmp_try.txt";
        boolean rrf= false;
        boolean flag = false;
        BufferedReader rrb = null;
        BufferedWriter wwb = null;
        try {
            rrb = new BufferedReader(new FileReader(oldBoard));
            wwb = new BufferedWriter(new FileWriter(tmpBoard));
            String line;

            while ((line = rrb.readLine()) != null) {
                if(line.equals("ID: " + Main.inpUser))
                    rrf=true;
                if (rrf==false || !line.equals("Board: " + renameBoard))
                {
                    wwb.write(line+"\n");
                }
                else
                {
                    flag = true;
                }
            }
        } catch (Exception e) {
            //  return;
        } finally {
            try {
                if(rrb != null)
                    rrb.close();
            } catch (IOException e) {
                //
            }
            try {
                if(wwb != null)
                    wwb.close();
            } catch (IOException e) {
                //
            }
        }
        // Once everything is complete, delete old file..
        File oile = new File(oldBoard);
        oile.delete();

        // And rename tmp file's name to old file name
        File nile = new File(tmpBoard);
        nile.renameTo(oile);

        if(flag==true)
        {
            System.out.println("Board closed successfuly...!!!");
        }
        else
            System.out.println("Board doesn't exist...!!!");
    }

}
