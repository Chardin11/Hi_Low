package Hi_Low;

import java.util.Scanner;

public class controller{

    public static void main(String[] args) {
        getdeck();
        player();

    } // end of main

    public static void player() 
    {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of particapants playing: ");//prompt user amount and player names
        
        int playerCount = input.nextInt();

        String[] playerNames = {"Player1", "Player2", "Player3", "Player4", "Player5", "Player6", "Player7", "Player8", "Player9", "Player10", "Player11", "Player12", "Player13", "Player14", "Player15"};
        Scanner nameinput = new Scanner(System.in);
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Enter in the player name:");
            String playerIds = nameinput.nextLine();
            playerNames[i] = playerIds;
        }

        int[] playerArry = new int[playerCount];//make an array that holds player amount
        for(int i = 0; i < playerArry.length; i++)//for loop that leys each player make guesses
        {
              
                
                getdeck();

                Scanner Rinput = new Scanner(System.in);
                System.out.println(playerNames[i] + " enter in your guess for the rank");
                String playerRankGuess = Rinput.nextLine();

                Scanner Sinput = new Scanner(System.in);
                System.out.println( playerNames[i] + " enter in your guess for the suit");
                String playerSuitGuess = Sinput.nextLine();

                Scanner bInput = new Scanner(System.in);
                System.out.println(playerNames[i] + " enter in your betting amount");
                int playerBets = bInput.nextInt();

                Scanner currencyInout = new Scanner(System.in);
                System.out.println(playerNames[i] + " enter in your currency amount");
                int currencyAmount = currencyInout.nextInt();

                Boolean dAnswer = checkCard(playerSuitGuess, playerRankGuess, playerSuitGuess);
                checkCard(playerNames[i], playerSuitGuess, playerRankGuess);

                playerBets(currencyAmount, playerBets, true);
                
                currencyAmount = playerBets(currencyAmount, playerBets, dAnswer);
                System.out.println("\n" + playerNames[i] + " your new betting amount: " + currencyAmount);
                System.out.println(" ");
                // Rinput.close();
                // Sinput.close();
                // bInput.close();
                // currencyInout.close();        

        }
        input.close();
        nameinput.close();
    }        
        
        public static int bet() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the amount you want to bet: ");
            int playerBet = input.nextInt();

            input.close();

            return playerBet;
        } // end of bet method


    // this function checks dRankNum to see if true if so add bet else subtract
    public static int playerBets(int currencyAmount, int playerBets, boolean danswer){
            if(danswer == true){
                currencyAmount += playerBets;
            return currencyAmount;
            } else {
                currencyAmount -= playerBets;
            return currencyAmount;
            }
    
    } // end of playerBets method

    public static void getdeck(){
        int[] deck = new int[52];

        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }        

        for (int i = 0; i < deck.length; i++) {
            int index = (int) (Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }

        for (int i = 0; i < 1; i++) {
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];


            System.out.println(rank + " of " + suit);
        }

    } //end of getdeck method


    public static boolean checkCard(String pName, String guessSuit, String guessRank){
        Boolean dAnswer = false; 
                        
        String playerName = pName;

        System.out.println(guessRank);
        System.out.println(guessSuit);

        // array to hold the suits and ranks to get the int values
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        // holder values
        String dSuit = "Spades";
        String dRank = "2";

        String hSuit = "Diamonds";
        String hRank = "5";
        
        // string arrays to the suit and rank
        String[] displayCard =  {dSuit, dRank};
        String[] hiddenCard = {hSuit, hRank};

        // holder values for the displayed and hidden suits and ranks
        int dSuitNum = 0;
        int dRankNum = 0;
        int hSuitNum = 0;
        int hRankNum = 0;

        // for loop to get the int value of display card
        for (int i = 0; i < suits.length; i++) {
            if (displayCard[0] == suits[i]){
                // System.out.println(i);
                dSuitNum = i;
                // System.out.println(dSuitNum);
                
            }
        }
        // for loop to get the int value of display card
        for (int i = 0; i < ranks.length; i++) {
            if (displayCard[1] == ranks[i]){
                // System.out.println(i);
                dRankNum = i;
                // System.out.println(dRankNum);
                
            }
        }
        // for loop to get the int value of hidden card
        for (int i = 0; i < suits.length; i++) {
            if (hiddenCard[0] == suits[i]){
                // System.out.println(i);
                hSuitNum = i;
                // System.out.println(hSuitNum);
                
            }
        }
        // for loop to get the int value of hidden card
        for (int i = 0; i < ranks.length; i++) {
            if (hiddenCard[1] == ranks[i]){
                // System.out.println(i);
                hRankNum = i;
                // System.out.println(hRankNum);
                
            }
        }

        // tests if the players guess was correct for the rank and suit
        if(guessSuit.equals("higher") || guessSuit.equals("Higher") || guessSuit.equals("HIGHER") || guessSuit.equals("h") || guessSuit.equals("H")){
            if (dSuitNum > hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                dAnswer = true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the suit.");
                dAnswer = false;
            }

        }
        else if (guessSuit.equals("lower") || guessSuit.equals("lower") || guessSuit.equals("LOWER") || guessSuit.equals("l") || guessSuit.equals("L")) {
            if (dSuitNum < hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                dAnswer = true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the suit.");
                dAnswer = false;
            }

        }
        else{
            System.out.println("Invalid Input");
            checkCard(hRank, hRank, hRank);
        }

        if (guessRank.equals("higher") || guessRank.equals("Higher") || guessRank.equals("HIGHER") || guessRank.equals("h") || guessRank.equals("H")){
            if (dRankNum > hRankNum){
                System.out.println("Congratulations " + playerName + " you guessed the rank correct!");
                dAnswer = true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the rank.");
                dAnswer = false;
            }
        }
        else if (guessRank.equals("lower") || guessRank.equals("lower") || guessRank.equals("LOWER") || guessRank.equals("l") || guessRank.equals("L")) {
            if (dSuitNum < hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                dAnswer = true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the suit.");
                dAnswer = false;
            }
        }
        else{
            System.out.println("Invalid Input");
            checkCard(hRank, hRank, hRank);
        }
        return dAnswer;
    }
} // end of class
