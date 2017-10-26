import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {

    public static void createCard() {

        String desc = "", comment = "";
        System.out.println("1. Enter Description");
        Scanner in = new Scanner(System.in);
        desc = in.next();
        System.out.println("2.Add comment");


        Scanner in1 = new Scanner(System.in);
        comment = in1.next();
        String members[] = new String[0];
        try {
            System.out.println("3.Add Members");
            System.out.println("Enter the number of members you want to add");
            Scanner in11 = new Scanner(System.in);
            int mem = in11.nextInt();


            members = new String[mem];
            for (int i = 0; i < mem; i++) {
                Scanner in2 = new Scanner(System.in);
                members[i] = in2.nextLine();
            }
            Date dNow = new Date();
            SimpleDateFormat ft =
                    new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");


            try

            {
                FileWriter fw = new FileWriter("cardCreate.txt", true);
                PrintWriter p = new PrintWriter(fw);


                p.print("Card Details");


                p.println("Description: " + desc + ", Comments: " + comment + ", Members: " + Arrays.toString(members) + ", Created at: " + ft.format(dNow));

                p.close();
                System.out.println("Description: " + desc + ", Comments: " + comment + ", Members: " + Arrays.toString(members) + ", Created at: " + ft.format(dNow));


            } catch (IOException ex) {

                ex.printStackTrace();
            }


        } catch (InputMismatchException e) {
            System.out.println("enter value of integer data type");
        }


    }


    public static void main(String[] args) {


        createCard();
    }
}
