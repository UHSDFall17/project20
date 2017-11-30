import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lists {
    static String desc = "";
    static String comment = "";
    static String members[];
    static int val = 0;
    static String TeamChoose;
    private static Date dNow;
    private static Date card_dNow;

    private static String cardDesc;
    private static String option;
    static boolean is_List_Created;
    static boolean is_Card_Created;


    //createList Method
    public static boolean createLists(String Boardname) {

        System.out.println("Do you want to create a new list");
        Scanner choose = new Scanner(System.in);

        option = choose.next();


        if (option.equals("Y") || option.equals("y")) {

            String listTitle = "";
            System.out.println("Enter the List Description");
            Scanner in = new Scanner(System.in);
            listTitle = in.nextLine();
            dNow = new Date();

            SimpleDateFormat ft =
                    new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
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

                    System.out.println("Do you want to Create Card?y/n");
                    String ans = "";
                    Scanner input = new Scanner(System.in);
                    ans = input.next();
                    if (ans.equals("y")) {

                        // createCard method
                        createCardUnderList(listTitle);

                    } else {


                        AddList_Menu.AddList_Menu_Choice(Boardname);
                    }
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

                // text file cardCreate to write the contents of card such as members, description and time create
              /*  FileWriter fw = new FileWriter("BoardDetails.txt", true);
                PrintWriter p = new PrintWriter(fw);


                p.print("List Details");


                p.println("Title: " + listTitle + ", Created at: " + ft.format(dNow));

                p.close();
                System.out.println("Description: " + listTitle + ", Created at: " + ft.format(dNow));*/



        } else if (option.equals("N") || option.equals("n")) {
            //System.exit(0);
            AddList_Menu.AddList_Menu_Choice(Boardname);

        }

        return is_List_Created;
    }

    public static void createCardUnderList(String list) {

        System.out.println("1. Enter Description");
        Scanner in = new Scanner(System.in);
        cardDesc = in.nextLine();
        /*System.out.println("Do you want to add comment?y/n");
        String ans = "";
        Scanner input = new Scanner(System.in);
        ans = input.next();
        boolean fl = false;
        if (ans.equals("y")) {
            fl = true;
            System.out.println("2.Add comment");

            Scanner in1 = new Scanner(System.in);
            comment = in1.next();

        } else if (ans.equals("n")) {

        } else {
            System.out.println("Enter a valid option only");
        }*/
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
                    //if (fl){
                      //  bw.write("Comment: " + comment + "by: " + Main.inpUser);
                    //}
                    f = false;
                }
            }
        } catch (Exception e) {
            return;
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

    }
    //createCard method
  /*  public static boolean createCard() {
        System.out.println("Do you want to create a new Card");
        Scanner chooser = new Scanner(System.in);

        String option = chooser.next();

        if (option.equals("Y") || option.equals("y")) {
            is_Card_Created = true;
            System.out.println("1. Enter Description");
            Scanner in = new Scanner(System.in);
            cardDesc = in.next();
            System.out.println("Do you want to add comment?y/n");
            String ans = "";
            Scanner input = new Scanner(System.in);
            ans = input.next();
            if (ans.equals("y")) {

                System.out.println("2.Add comment");


                Scanner in1 = new Scanner(System.in);
                comment = in1.next();
                val = 1;
                if (val == 1) {
                    try {
                        System.out.println("3.Add Members");
                        System.out.println("Do you want to add members");
                        Scanner opt = new Scanner(System.in);
                        String choose = opt.next();
                        if (choose.equals("Y") || choose.equals("y")) {
                            System.out.println("Enter the number of members you want to add");
                            Scanner in11 = new Scanner(System.in);
                            int mem = in11.nextInt();


                            members = new String[mem];
                            for (int i = 0; i < mem; i++) {
                                Scanner in2 = new Scanner(System.in);
                                members[i] = in2.nextLine();
                            }
                        } else if (choose.equals("N") || choose.equals("n")) {


                            members = new String[]{""};

                        }


                    } catch (InputMismatchException e) {
                        System.out.println("enter value of integer data type");
                    }
                }
            } else if (ans.equals("n")) {
                try {
                    System.out.println("3.Add Members");
                    System.out.println("Do you want to add members");
                    Scanner opt = new Scanner(System.in);
                    String choose = opt.next();
                    if (choose.equals("Y") || choose.equals("y")) {
                        System.out.println("Enter the number of members you want to add");
                        Scanner in11 = new Scanner(System.in);
                        int mem = in11.nextInt();


                        members = new String[mem];
                        for (int i = 0; i < mem; i++) {
                            Scanner in2 = new Scanner(System.in);
                            members[i] = in2.nextLine();
                        }
                    } else if (choose.equals("N") || choose.equals("n")) {


                        members = new String[]{""};

                    }


                } catch (InputMismatchException e) {
                    System.out.println("enter value of integer data type");
                }
            } else {
                System.out.println("Enter a valid option only");
                AddList_Menu.AddList_Menu_Choice();
            }
            try {
                // To get the date and time info of when the card is created
                card_dNow = new Date();
                SimpleDateFormat ft =
                        new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");


                // text file cardCreate to write the contents of card such as members, description and time create
                FileWriter fw = new FileWriter("BoardDetails.txt", true);
                PrintWriter p = new PrintWriter(fw);


                p.print("Card Details");


                p.println("Description: " + cardDesc + ", Comments: " + comment + ", Members: " + Arrays.toString(members) + ", Created at: " + ft.format(card_dNow));

                p.close();
                System.out.println("Description: " + cardDesc + ", Comments: " + comment + ", Members: " + Arrays.toString(members) + ", Created at: " + ft.format(card_dNow));

                System.out.println("A New Card has been Added!");
                System.out.println();
                System.out.println();
                AddList_Menu.AddList_Menu_Choice();


            } catch (IOException ex) {

                ex.printStackTrace();
            }
        } else if (option.equals("N") || option.equals("n")) {
            //System.exit(0);
            is_Card_Created = false;

            AddList_Menu.AddList_Menu_Choice();

        }
        return is_Card_Created;
    }*/

}
