package Hi_Low;

public class CardCheck{
    // public void main(String[] args) {
    //     String playerName = "joe";
    //     String guessSuit = "lower";
    //     String guessRank = "lower";
        
    //     checkCard(playerName, guessSuit, guessRank);
    // }

    // Method that runs to check card
    public void checkCard(String pName, String guessSuit, String guessRank){
        Boolean dAnswer; // Connor here might need to make a variable 
                        //that sets to true or false so i can call it in the bets function. Problem is the function is void not sure if we can change that or not
        // the players name
        String playerName = pName;
        // the players guesses
        // String playerGSuit = guessSuit;
        // String playerGRank = guessRank; 

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
        if(guessSuit == "higher" || guessSuit == "Higher" || guessSuit == "HIGHER" || guessSuit == "h" || guessSuit == "H"){
            if (dSuitNum > hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                // return true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the suit.");
                // return false;
            }

        }
        else if (guessRank == "lower" || guessRank == "Lower" || guessRank == "LOWER" || guessRank == "l" || guessRank == "L") {
            if (dSuitNum < hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                // return true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the suit.");
                // return false;
            }

        }
        else{
            System.out.println("Invalid Input");
        }

        if (guessSuit == "higher" || guessSuit == "Higher" || guessSuit == "HIGHER" || guessSuit == "h" || guessSuit == "H"){
            if (dRankNum > hRankNum){
                System.out.println("Congratulations " + playerName + " you guessed the rank correct!");
                // return true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the rank.");
                // return false;
            }
        }
        else if (guessRank == "lower" || guessRank == "Lower" || guessRank == "LOWER" || guessRank == "l" || guessRank == "L") {
            if (dSuitNum < hSuitNum){
                System.out.println("Congratulations " + playerName + " you guessed the suit correct!");
                // return true;
            }
            else {
                System.out.println( playerName + " guessed wrong for the suit.");
                // return false;
            }
        }
        else{
            System.out.println("Invalid Input");
        }

    }
}