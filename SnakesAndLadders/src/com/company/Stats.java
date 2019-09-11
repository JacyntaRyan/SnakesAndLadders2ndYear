package com.company;

/*
 * Snakes and Ladders Project
 * Author   :   Alexandru Ipsalat  || Jacynta Ryan
 * K Number :   K00229834          || k00231373
 */

import java.io.*;
import java.util.ArrayList;

public class Stats {

    //The stats class is an example of composition as it cannot exist without Game class
    Game g1;
    ArrayList<Integer> turnsStats = new ArrayList<>();
    ArrayList<Integer> diceRollStats = new ArrayList<>();


    public Stats(Game g1) throws IOException {
        this.g1=g1;
        WriteTurns();
        ReadTurnsData();
        ReadDiceRollData();
        averageTurnsTaken();
        averageDiceRoll();
        formatTable();
    }

    //Creates a file called "DataDump" that stores all the turns in a vertical format so that when reading the file back
    //it will be easier to access the data, no formatting required here
    public void WriteTurns()throws IOException {

        FileWriter fw = new FileWriter("DataDump.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        {
            out.println(g1.turns);

        }
        out.close();
    }

    //This method reads in the "DataDump" file from the last method
    public void ReadTurnsData() {
        // The name of the file to open.
        String fileName = "DataDump.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                //this will convert the string line to an int
                int num = Integer.parseInt(line);
                //add number to stats if its not zero because i haven't figured out why zeros keeping being added to the datadump file
                if (num != 0) {
                    turnsStats.add(num);
                }
                //System.out.println(num);
            }
            //close file.
            bufferedReader.close();
        }
        //error handling
        catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        //error handling
        catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }//end of method

    //Gets the average turns taken, works better when you have many games played to get a more accurate answer
    public int averageTurnsTaken() {
        int i;
        int j = 0;
        //System.out.println("iterate through stats");
        for (Integer stat : turnsStats) {
            //System.out.println(stat);
            i = stat;
            j = j + i;
        }
        //System.out.println("total turns " + j);
        int avg = j / turnsStats.size();
        //System.out.println("average " + avg);
        return avg;
    }

    //Reads in dice
    public void ReadDiceRollData() {
        // The name of the file to open.
        String fileName = "DiceRollData.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                //this will convert the string line to an int
                int num = Integer.parseInt(line);
                //add number to stats if its not zero because i haven't figured out why zeros keeping being added to the datadump file
                if (num != 0) {
                    diceRollStats.add(num);
                }
                //System.out.println(num);
            }
            //close file.
            bufferedReader.close();
        }
        //error handling
        catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        //error handling
        catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }//end of method

    //gets the average dice roll from the "DiceRollData.txt" file (Its always 6)
    public int averageDiceRoll() {
        int i;
        int j = 0;
        //System.out.println("iterate through diceRollStats");
        for (Integer stat : diceRollStats) {
            //System.out.println(stat);
            i = stat;
            j = j + i;
        }
        //System.out.println("total  " + j);
        int avg = j / diceRollStats.size();
        //System.out.println("average " + avg);
        return avg;
    }//end of method

    //This method puts all the data written from all the other files and compiles them in an easy to read table
    public void formatTable()throws IOException
    {
        FileWriter writer = new FileWriter("GameAnalytics.txt");
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println("------------Snakes and Ladders Analytics-------");
        printWriter.println("-----------------------------------------------");
        printWriter.println("Each Line Represents 1 Game");
        printWriter.println("-----------------------------------------------");
        printWriter.printf("           %10s %20s \r\n", "Turns", "Avg Die Roll");
        printWriter.println("-----------------------------------------------");

        for(int tS: turnsStats) {
            printWriter.printf("           %10s %20s \r\n", tS, averageDiceRoll());
        }
        printWriter.println("-----------------------------------------------");
        printWriter.printf("Avg Turns: %10s \r\n", averageTurnsTaken());


        writer.close();
        printWriter.close();
    }

}

