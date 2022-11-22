package Hi_Low;

import java.util.Scanner;

public class controller{

    public static void main(String[] args) {

        System.out.println("Welcome to High low.");
        
        player();

    } // end of main

    public static void player() 
    {

        Scanner nameinput = new Scanner(System.in);
            System.out.print("Enter in the player name: ");
            String playerNames = nameinput.nextLine();

        getGuess(playerNames);
    }

    public static void getGuess(String playerNames){
            
                Scanner input = new Scanner(System.in);

                getdeck();

                String[] cardArray = getdeck();

                String dSuit = cardArray[1];
                String dRank = cardArray[0];


                System.out.println("Displayed card (rank suit) " + dRank + " " + dSuit);

                // Scanner Rinput = new Scanner(System.in);
                System.out.print(playerNames + " enter in your guess for the rank: ");
                String playerRankGuess = input.nextLine();

                // Scanner Sinput = new Scanner(System.in);
                System.out.print( playerNames + " enter in your guess for the suit: ");
                String playerSuitGuess = input.nextLine();

                // Scanner bInput = new Scanner(System.in);
                System.out.print(playerNames + " enter in your betting amount: ");
                int playerBets = input.nextInt();

                // Scanner currencyInout = new Scanner(System.in);
                System.out.print(playerNames + " enter in your currency amount: ");
                int currencyAmount = input.nextInt();

                Boolean dAnswer = checkCard(playerNames, playerRankGuess, playerSuitGuess, cardArray);

                playerBets(currencyAmount, playerBets, dAnswer);
                
                currencyAmount = playerBets(currencyAmount, playerBets, dAnswer);
                System.out.println("\n" + playerNames + " your new betting amount: " + currencyAmount);
                System.out.println(" ");

                

        }
            
        
      
        
        public static int bet() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the amount you want to bet: ");
            int playerBet = input.nextInt();

            input.close();

            return playerBet;
        } // end of bet method


    // this function checks dAnswer to see if true if so add bet else subtract
    public static int playerBets(int currencyAmount, int playerBets, boolean dAnswer){
            if(dAnswer == true){
                currencyAmount += playerBets;
            return currencyAmount;
            } else {
                currencyAmount -= playerBets;
            return currencyAmount;
            }
    
    } // end of playerBets method

    public static String[] getdeck(){
        String Dsuit = "";
        String Drank = "";
        String Hsuit = "";
        String Hrank = "";


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
            Dsuit = suits[deck[i] / 13];
            Drank = ranks[deck[i] % 13];

            // displayed card
            // System.out.println(Drank + " of " + Dsuit);
        }
        for (int i = 0; i < 1; i++) {
            Hsuit = suits[deck[i] / 13];
            Hrank = ranks[deck[i] % 13];

            // Hidden card
            // System.out.println(Hrank + " of " + Hsuit);
        }

        String[] cardarray = {Drank, Dsuit, Hrank, Hsuit};

        return cardarray;

    } //end of getdeck method


    public static boolean checkCard(String pName, String guessSuit, String guessRank, String[] cardArray){
        Boolean dAnswer = false; 
                        
        String playerName = pName;

        // System.out.println(guessRank);
        // System.out.println(guessSuit);

        // array to hold the suits and ranks to get the int values
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        // holder values
        String dSuit = cardArray[1];
        String dRank = cardArray[0];

        String hSuit = cardArray[3];
        String hRank = cardArray[2];

        // System.out.println("Displayed card " + dRank + dSuit);
        // System.out.println("Displayed card " + hRank + hSuit);

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
                System.out.println( playerName + " guessed wrong for the suit5.");
                dAnswer = false;
            }

        }
        else if (guessSuit.equals("lower") || guessSuit.equals("lower") || guessSuit.equals("LOWER") || guessSuit.equals("l") || guessSuit.equals("L")) {
            if (dSuitNum < hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                dAnswer = true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the suit4.");
                dAnswer = false;
            }

        }
        else{
            System.out.println("Invalid Input");
            getGuess(playerName);
        }

        if (guessRank.equals("higher") || guessRank.equals("Higher") || guessRank.equals("HIGHER") || guessRank.equals("h") || guessRank.equals("H")){
            if (dRankNum > hRankNum){
                System.out.println("Congratulations " + playerName + " you guessed the rank correct!");
                dAnswer = true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the rank1.");
                dAnswer = false;
            }
        }
        else if (guessRank.equals("lower") || guessRank.equals("lower") || guessRank.equals("LOWER") || guessRank.equals("l") || guessRank.equals("L")) {
            if (dSuitNum < hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                dAnswer = true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the rank2.");
                dAnswer = false;
            }
        }
        else{
            System.out.println("Invalid Input");
            getGuess(playerName);
        }
        return dAnswer;
    }
} // end of class
