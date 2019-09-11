package com.company;

/*
 * Snakes and Ladders Project
 * Author   :   Alexandru Ipsalat  || (Jacynta Ryan
 * K Number :   K00229834          || k00231373
 */

public class Game {
    //If a class has an entity reference, it is known as Aggregation. Aggregation represents HAS-A relationship.
//example of aggregation is that game has a board object and player objects.

    boolean isGameOver=false;

    Board b1 = new Board(); //creates board object

    int turns;
    Player p1 = new Player(b1);
    Player p2 = new Player(b1);


    public void playGame()
    {
        //name = p1.getName();
        b1.setUpBoard();//this will initialize the snakes and ladders arrays
        p1.enterName();

        //after every dice roll the isGameOver Method checks to see if a player has reached the end of the board otherwise
        //it loops and the players roll again
        while(isGameOver==false){

            System.out.println(p1.getName() + " Will Roll");
            p1.playerOneRollDice();
            p1.movePlayer();
            isGameOver=isGameOver();

            System.out.println("Player2 Will Roll");
            p2.playerTwoRollDice();
            p2.movePlayer();
            isGameOver=isGameOver();
            turns++;
            System.out.println("Turns: " + turns);
        }
        getWinner();

    }

    //to get out of the game loop which repeats roll dice and moves player,checks if a player has reached the end of the board
    public boolean isGameOver()
    {
        boolean over = false;
        if((p1.getLocation() >= 99) || (p2.getLocation() >= 99))
        {
            over=true;
        }

        return over;
    }

    //checks to see which player has reached the end of the board and won
    public void getWinner()
    {
        if(p1.getLocation() >= 99)
        {
            System.out.println(" ------------!!!WINNER!!!--------------");
            System.out.println("| "    +     p1.getName()+" Has Won |");
            System.out.println(" --------------------------------------");
        }
        else if(p2.getLocation() >= 99)
        {
            System.out.println(" ------------!!!WINNER!!!--------------");
            System.out.println("|           Player 2 Has Won           |");
            System.out.println(" --------------------------------------");
        }

    }


}
