package Hi_Low;

import java.util.Scanner;


public class bets extends CardCheck{

    public void thebets() {
        String pName;
        String guessSuit;
        String guessRank;
        CardCheck check = new CardCheck();
        check.checkCard(pName, guessSuit, guessRank);
        Boolean answer = check.CardCheck(dAnswer);
        // check.checkCard(pName, guessSuit, guessRank);
        // Boolean answer = check.dRankNum;
        
        int playerCurrency = 1000;
        int bet = bet();
        int newPlayerCurrency = initalPlayerBetWon(playerCurrency, bet);
        newPlayerCurrency = initalPlayerBetLoss(playerCurrency, bet);
    
        // startingBetAmount();
        //initalPlayerBetWon(playerCurrency, bet);
        // initialPlayerBetLoss(playerCurrency, bet);
        playerBets(newPlayerCurrency, bet, true);
        
        

    } // main

        public int bet() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the amount you want to bet: ");
            int playerBet = input.nextInt();
            return playerBet;
          
        } // end of bet method

        // this function tells the user the starting bet amount
        public void startingBetAmount(int playerCurrency) {
            System.out.println("Your starting bet amount is: " + "$ " + playerCurrency);

        } // end of startingBetAmount method

        // this function takes the playerCurrency and subtracts bet amount
    public int initalPlayerBetLoss(int playerCurrency, int bet) {
        int playerNewCurrency = playerCurrency - bet;
        System.out.println("Your new betting amount: $ " + playerNewCurrency);
        return playerNewCurrency;
    } // end of playerBet method

        // this function takes the playerCurrency and adds the bet amount
    public int initalPlayerBetWon(int playerCurrency, int bet) {
        int playerNewCurrency = playerCurrency + bet;
        System.out.println("Your new betting amount: $ " + playerNewCurrency);
        return playerNewCurrency;
    } // end of initialPlayerbetWon method


    // this function checks dRankNum on CardCheck.java to see if true if so add bet else subtract
    public int playerBets(int newPlayerCurrency, int bet, boolean answer){
            if(answer == true){
            newPlayerCurrency += bet;
            return newPlayerCurrency;
            } else {
            newPlayerCurrency -= bet;
            return newPlayerCurrency;
            }
    
    } // end of playerBets method

} // end of bets
