import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateMenu {

    private static void displayOptions() {

        System.out.println("Welcome!!Please Choose any one of the following options");

        System.out.println("1.Create Board");

        System.out.println("2.Create a new Team");

    }

    private static void chooseOptions(int option) {

        if (option == 1) {

            System.out.println("goto the Create board page");
        } else if (option == 2) {

            System.out.println("go to the Create a new team page");

        }


    }

    public static void main(String[] args) {

        displayOptions();

        Scanner in = new Scanner(System.in);


        try {


            int option = in.nextInt();

            chooseOptions(option);
        }
        catch(InputMismatchException e){

            System.out.println("Enter a valid value of integer datatype");
        }


    }
}
