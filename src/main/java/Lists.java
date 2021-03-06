import java.io.*;
import java.util.Scanner;

public class Lists {
   
   
    private static String cardDesc;
    private static String option;
    public static boolean is_List_Created;

    public static boolean display(String Boardname){
        boolean found = false;
        FileReader fr1 = null;
        try {
            fr1 = new FileReader("BoardDetails.txt");
            BufferedReader br = new BufferedReader(fr1);
            String str;
            while ((str = br.readLine()) != null) {
                if (str.contains("Board: " + Boardname))
                    found = true;
                if (found) {
                    System.out.println(str);
                    if (str.length() == 0)
                        break;
                }
            }
            br.close();
            if (!found)
                System.out.println("Team not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    //createList Method
    public static boolean createLists(String Boardname) {

        System.out.println("Do you want to create a new list");
        Scanner choose = new Scanner(System.in);

        option = choose.next();


        if ("Y".equals(option) || "y".equals(option)) {

            String listTitle = "";
            System.out.println("Enter the List Description");
            Scanner in = new Scanner(System.in);
            listTitle = in.nextLine();

           
                String oldFileName = "BoardDetails.txt";
                String tmpFileName = "tmp_try.txt";

                BufferedReader br = null;
                BufferedWriter bw = null;
                try {
                    br = new BufferedReader(new FileReader(oldFileName));
                    bw = new BufferedWriter(new FileWriter(tmpFileName));
                    String line;
                    boolean f = false;
                    while ((line = br.readLine()) != null) {
                        bw.write(line + "\n");
                        if (line.contains("Board: " + Boardname))
                            f = true;
                        if (f) {
                            //System.out.println("!!!!!!!!!!!");
                            bw.write("List: " + listTitle + "\n");
                            f = false;
                        }
                    }

                    System.out.println("A new List has been Created!!");
                    System.out.println();


                } catch (Exception e) {
                    is_List_Created = false;
                    return is_List_Created;
                } finally {
                    try {
                        if (br != null)
                            br.close();
                    } catch (IOException e) {}
                    try {
                        if (bw != null)
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

              
            System.out.println("Do you want to Create Card?y/n");
            String ans = "";
            Scanner input = new Scanner(System.in);
            ans = input.next();
            if ("y".equals(ans)) {
                // createCard method
                createCardUnderList(listTitle);

            } else {


                AddList_Menu.AddList_Menu_Choice(Boardname);
            }

        } else if ("N".equals(option) || "n".equals(option)) {
            //System.exit(0);
            AddList_Menu.AddList_Menu_Choice(Boardname);

        }

        return is_List_Created;
    }

    public static boolean createCardUnderList(String list) {

        System.out.println("1. Enter Description");
        Scanner in = new Scanner(System.in);
        cardDesc = in.nextLine();
        
        String oldFileName = "BoardDetails.txt";
        String tmpFileName = "tmp_try.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(oldFileName));
            bw = new BufferedWriter(new FileWriter(tmpFileName));
            String line;
            boolean f = false;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
                if (line.equals("List: " + list))
                    f = true;
                if (f) {
                    bw.write("Card : " + cardDesc + "\n");
                    
                    f = false;
                }
            }
        } catch (Exception e) {
            System.out.println("File not found");
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                //
            }
            try {
                if (bw != null)
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
        return true;
    }
   

}
