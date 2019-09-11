package com.company;

/*
 * Snakes and Ladders Project
 * Author   :   Alexandru Ipsalat  || Jacynta Ryan
 * K Number :   K00229834          || k00231373
 */

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    int userPick;
    String userPik;
    boolean loop;
    Scanner scan = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in); //Created a second scanner so that the user has an option to go back to menu after reading the rules
    Game g1 = new Game();

    //Basically the menu that shows the user what the can choose
    public UserInterface()throws IOException {
        loop = false;

        //The menu loops
        while (!loop)
        {
        System.out.println("---------------------------");
        System.out.println("|     Snakes & Ladders     |");
        System.out.println("---------------------------");
        System.out.println("|           MENU           |");
        System.out.println("---------------------------");
        System.out.println("|                          |");
        System.out.println("|  1: Play                 |");
        System.out.println("|  2: Rules                |");
        System.out.println("|  3: Exit                 |");
        System.out.println("|                          |");
        System.out.println("----------------------------");
        System.out.println("Which Option Do You Wish To Use?");
        System.out.println("----------------------------");

            userPick = scan.nextInt();
            switch (userPick) {
                case 1:
                    System.out.println("Loading Play...");
                    g1.playGame(); //Loads the game
                    Stats s1 = new Stats(g1); // Writes the Stats
                    loop = true;
                    break;

                case 2:
                    System.out.println("Loading Rules...");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.println("(1) - A simple game with two players, one in which you control and another that is automated");
                    System.out.println("(2) - The board consists of 100 squares and the goal is to reach the last square");
                    System.out.println("(3) - Scattered throughout the board are Snakes and Ladders");
                    System.out.println("(4) - If you land on the bottom of a ladder you get to move to the top of the ladder");
                    System.out.println("(5) - If you land on the head of a snake you then go down to the box where the tail is");
                    System.out.println("(6) - Both players get the same amount of goes, in case of a draw ");
                    System.out.println("(7) - If any player gets above 100+ when rolling the die, it will, by default, set the location to ");
                    System.out.println("    - 100 and the game is won ");
                    System.out.println("----------------------------------------------------------------------------------------------");

                    do {
                        System.out.println("Do you wish to go back to the Menu?"); //created nested loop to help the user maneuver around the menu without having to close the program after reading rules
                        System.out.println("|| y = Yes // n = No ||");
                        userPik = scan2.nextLine();

                        if (userPik.equals("y") || userPik.equals("Y")) { //If yes then the user breaks out of the second loop and goes back to the original loop, being the start of the menu
                            System.out.println("Leaving To Menu...");
                            break;
                        }
                        else if(userPik.equals("n") || userPik.equals("N")) { //If no just exit game
                            System.out.println("You Are Now Exiting...");
                            loop=true;
                            break;
                        }
                        else{
                            System.out.println("Invalid character, try again"); //Stops the user from entering the wrong character
                        }
                    }while(!userPik.equalsIgnoreCase("n"));
                    System.out.println("----------------------------------------------------------------------------------------------");
                    break;


                case 3:
                    System.out.println("You Are Now Exiting...");
                    loop = true;
                    break;
            }

        }
    }
}
