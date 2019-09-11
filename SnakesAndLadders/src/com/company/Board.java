package com.company;

/*
 * Snakes and Ladders Project
 * Author   :   Alexandru Ipsalat  || (Write name here jay)
 * K Number :   K00229834          || (Same as here)
 */

public class Board implements BoardInterface {

    int snakesHeadArray[] = new int[6]; // create a 6 element array for snake head positions
    int ladderBottomArray[] = new int[6];// create a 6 element array for the bottom of the ladder positions
    int snakesTailArray[] = new int[6]; // create a 6 element array for the snake tail positions
    int ladderTopArray[] = new int[6];// create a 6 element array for the top of the ladder positions

    public void setUpBoard()
    {
        // store the snakes and ladders locations in the array

        snakesHeadArray [0] = 99;
        snakesHeadArray [1] = 63;
        snakesHeadArray [2] = 32;
        snakesHeadArray [3] = 87;
        snakesHeadArray [4] = 31;
        snakesHeadArray [5] = 28;

        snakesTailArray [0] = 37;
        snakesTailArray [1] = 25;
        snakesTailArray [2] = 20;
        snakesTailArray [3] = 65;
        snakesTailArray [4] = 5;
        snakesTailArray [5] = 15;

        ladderBottomArray [0] = 18;
        ladderBottomArray [1] = 22;
        ladderBottomArray [2] = 54;
        ladderBottomArray [3] = 10;
        ladderBottomArray [4] = 32;
        ladderBottomArray [5] = 74;

        ladderTopArray [0] = 34;
        ladderTopArray [1] = 61;
        ladderTopArray [2] = 84;
        ladderTopArray [3] = 39;
        ladderTopArray [4] = 51;
        ladderTopArray [5] = 89;

    }

}
