package com.company;

/*
 * Snakes and Ladders Project
 * Author   :   Alexandru Ipsalat  || Jacynta Ryan
 * K Number :   K00229834          || k00231373
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Player {

    int location;
    int value;
    boolean isGameOver=false;
    String name;
    Board b1;

    //pass in board object so we can use the snakes and ladders
    Player(Board b1)
    {
        this.b1 = b1;
        location=0;
        name = "";
    }

    //
    //Set Methods
    //

    //takes in players name ,limited to only letters no symbols or numbers
    public void enterName()
    {
        String userInput;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter a Name");

        while(!scan.hasNext("[A-Za-z]+"))
        {
            System.out.println("Please Enter Letters Only");
            scan.next();
        }
        userInput = scan.next();
        name=(userInput);
    }

    //Set the location of Player
    public void movePlayer() {
        //location is set to the current location on the board plus the dice roll
        location = location + value;
        //checks to see if the player has landed on a snake or ladder which overrides the location
        //and sets it to either the snakes tail or top of the ladder
        boolean checkPosition = false;
        while (!checkPosition){
            for (int i = 0; i < 6; i++) {
                if (location == b1.snakesHeadArray[i]) {
                    location = b1.snakesTailArray[i];
                    System.out.println("Landed on Snake...move back to square " + getLocation());
                    //checkPosition = true;

                } else if (location == b1.ladderBottomArray[i]) {
                    location = b1.ladderTopArray[i];
                    System.out.println("Landed on Ladder...Climb up to square " + getLocation());
                    //checkPosition = true;
                }
            }
            //if the player is not on a snake head or a ladder exit loop
            checkPosition = true;

            if(getLocation() >= 100)
            {
                location=100;
            }
        }
        System.out.println("Moving Player...Now on square " + getLocation()+"\n");
    }

    //asks player if they would like to roll the die or quit the game
    //(Add loop to avoid unintentional char from being entered)
    public void rollAgain()
    {

        System.out.println("type 'r' to roll the dice or 'q' to quit the game");
        Scanner scan = new Scanner(System.in);
        char roll = scan.next().charAt(0);
        if(roll=='r')
        {
            isGameOver=false;

        }
        else if(roll=='q'){
            isGameOver=true;
            System.out.println("exiting game...");
            System.exit(0);
        }
        else if(roll!='q' || roll!= 'r'){
            System.out.println("Sorry invalid input, try again");
            rollAgain();
        }

    }

    //Set the roll of the player
    //uses two die generated at random and are added together to get the total value of their turn,also calls roll again method
    public void playerOneRollDice() {
        rollAgain();
        System.out.println(" -----------------------------------------");
        int roll1;
        int roll2;
        Random rand = new Random();
        roll1 = rand.nextInt(7 - 1) + 1;
        roll2 = rand.nextInt(7 - 1) + 1;
        value = roll1 + roll2;
        System.out.println("Rolled: " + value);

        try {
            FileWriter fw = new FileWriter("DiceRollData.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            {
                out.println(value);
            }
            out.close();
        }

            catch(IOException ioe){
                //exception handling
            }
    }

    //
    //Get Methods
    //

    //get players name
    public String getName()
    {
        return name;
    }

    //Get the players Roll
    public int getRoll()
    {
        return value;
    }

    //uses two die generated at random and are added together to get the total value of their turn
    public int playerTwoRollDice()
    {

        int roll1;
        int roll2;
        Random rand = new Random();
        roll1=rand.nextInt(7-1)+1;
        roll2=rand.nextInt(7-1)+1;
        value=roll1+roll2;
        System.out.println("Rolled: " + value);
        return value;
    }

    //Get players location
    public int getLocation()
    {
        return location;
    }

}
