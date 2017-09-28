package com.softwaredesign.project20;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void showOptions() {
        System.out.println("1.Create Board");
        System.out.println("2.Create Team");

    }


    public static void optionChoose(int option) {

        if (option == 1) {

            System.out.println("go to create board page");
        } else if (option == 2) {
            System.out.println("go to create a new team page");
        } else if (option == 3) {


        }
    }





    public static void main(String[] args) {
        System.out.println("Welcome to Create Menu.Please Choose your option");

        Scanner in = new Scanner(System.in);


        showOptions();

        int option = in.nextInt();

        optionChoose(option);


    }
}
