import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    //createList Method
    public static void createLists() {
        System.out.println("Do you want to create a new list");
        Scanner choose = new Scanner(System.in);

        String option = choose.next();

        if (option.equals("Y") || option.equals("y")) {
            String listTitle = "";
            System.out.println("Enter the List Description");
            Scanner in = new Scanner(System.in);
            listTitle = in.next();
            Date dNow = new Date();

            SimpleDateFormat ft =
                    new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

            try {
                // text file cardCreate to write the contents of card such as members, description and time create
                FileWriter fw = new FileWriter("ListCreate.txt", true);
                PrintWriter p = new PrintWriter(fw);


                p.print("List Details");


                p.println("Description: " + listTitle + ", Created at: " + ft.format(dNow));

                p.close();
                System.out.println("Description: " + listTitle + ", Created at: " + ft.format(dNow));

                System.out.println("Do you want to Create Card?y/n");
                String ans = "";
                Scanner input = new Scanner(System.in);
                ans = input.next();
                if (ans.equals("y")) {

                    // createCard method
                    createCard();
                } else {

                    System.exit(0);

                    AddList_Menu.AddList_Menu_Choice();
                }

            } catch (IOException ex) {

                ex.printStackTrace();
            }


        } else if (option.equals("N") || option.equals("n")) {
            //System.exit(0);
            AddList_Menu.AddList_Menu_Choice();

        }

    }


    //createCard method
    public static void createCard() {


        System.out.println("1. Enter Description");
        Scanner in = new Scanner(System.in);
        desc = in.next();
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
            System.exit(0);
        }
        try {
            // To get the date and time info of when the card is created
            Date dNow = new Date();
            SimpleDateFormat ft =
                    new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");


            // text file cardCreate to write the contents of card such as members, description and time create
            FileWriter fw = new FileWriter("cardCreate.txt", true);
            PrintWriter p = new PrintWriter(fw);


            p.print("Card Details");


            p.println("Description: " + desc + ", Comments: " + comment + ", Members: " + Arrays.toString(members) + ", Created at: " + ft.format(dNow));

            p.close();
            System.out.println("Description: " + desc + ", Comments: " + comment + ", Members: " + Arrays.toString(members) + ", Created at: " + ft.format(dNow));


        } catch (IOException ex) {

            ex.printStackTrace();
        }

    }


    public static void main(String[] args) {


        //Calling list method

        createLists();
    }
}