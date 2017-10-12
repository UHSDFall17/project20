import java.util.Scanner;

public class CreateBoard {

    public static void BoardDetails(String name, String teamAdd, String boardAccess) {

        System.out.println("Team name " + name);
        System.out.println("Team Added " + teamAdd);
        System.out.println("Team Access " + boardAccess);

    }


    public void CreateBoard() {
        System.out.println("*******************************************************************");
        System.out.println("Welcome to create new board page!");
        System.out.println("Enter the title of the board(Like Weekly meal planning for example) ");
        Scanner in = new Scanner(System.in);

        String name = in.nextLine();


        System.out.println("Add a Team ");
        String teamAdd = in.nextLine();

        System.out.println("Do you want the board to be private or public??");
        String boardAccess = in.nextLine();

        System.out.println("*******************************************************************");


        BoardDetails(name, teamAdd, boardAccess);
    }


    public static void main(String[] args) {


    }
}
