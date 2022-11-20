package Hi_Low;
// import java.io.File;
import java.util.Scanner;

//import javax.sound.sampled.SourceDataLine;

public class Players
{
    public static void player() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numer of particapants playing: ");//prompt user amount and player names
        
        int playerCount = input.nextInt();

        String[] playerNames = {"Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11", "Player12", "Player13", "Player14", "Player15"};
        Scanner nameinput = new Scanner(System.in);
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Enter in the player names:");
            String playerIds = nameinput.nextLine();
            playerNames[i] = playerIds;
        }

        int[] playerArry = new int[playerCount];//make an array that holds player amount
        for(int i = 0; i < playerArry.length; i++)//for loop that leys each player make guesses
        {
              
            // File file = new File("CardCheck.java");//crates new file to access the cardcheck
            // if(file.exists())//is statement for if the file exists; will prompt for users to make guesses
            // {
                // .getdeck();

                Scanner Rinput = new Scanner(System.in);
                System.out.println(playerNames[i] + " enter in you guess for the rank");
                // String playerRankGuess = Rinput.nextLine();
                Scanner Sinput = new Scanner(System.in);
                System.out.println( playerNames[i] + " enter in your guess for the suit");
                // String playerSuitGuess = Sinput.nextLine();


                // CardCheck.checkCard(playerNames[i], playerSuitGuess, playerRankGuess);
                
                Rinput.close();
                Sinput.close();
            // }
            // else
            //     System.out.println("file does not exist");
                           
           
        }
        input.close();
        nameinput.close();
        
    }

}