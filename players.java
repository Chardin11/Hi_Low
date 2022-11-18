package Hi_Low;
import java.io.File;
import java.util.Scanner;

//import javax.sound.sampled.SourceDataLine;

public class players extends bets
{
    public static void player() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numer of particapants playing: ");//prompt user amount and player names
        
        int playerCount = input.nextInt();
        
        System.out.println("enter in the player names");
        String playerIds = input.nextLine();
        String[] playerNames = {playerIds};
        

        int[] playerArry = new int[playerCount];//make an array that holds player amount
        for(int i = 0; i < playerArry.length; i++)//for loop that leys each player make guesses
        {
              
            // File file = new File("CardCheck.java");//crates new file to access the cardcheck
            // if(file.exists())//is statement for if the file exists; will prompt for users to make guesses
            // {
                System.out.println("player " + playerNames[i] + " enter in you guess for the rank");
                String playerRankGuess = input.nextLine();
                System.out.println("player " + playerNames[i] + " enter in your guess for the suit");
                String playerSuitGuess = input.nextLine();

                var playerClass = new CardCheck();
                playerClass.checkCard(playerNames[i], playerSuitGuess, playerRankGuess);
                
                
            // }
            // else
            //     System.out.println("file does not exist");
                           
           
        }
        input.close();

    }

}