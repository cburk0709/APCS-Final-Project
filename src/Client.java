import java.util.Scanner;

public class Client {
    //nested while loop, quit conditional, 21 conditional
    //user defined int for starting pot
    //implement betting
    //show cards
    //player has hand object
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String conditional = "";

        while (!conditional.equals("quit")){
            System.out.println("Welcome to Blackjack. To play, enter any token besides \"quit\"");
            conditional = userInput.next();
            int[] myValues =   {2,   3,   4,   5,   6,   7 ,  8,   9,    10,   10,  10, 10, 11};
            String[] myRanks = {"2", "3", "4", "5", "6", "7", "8", "9",  "10", "J", "Q", "K", "A"};
            Deck myDeck = new Deck(myRanks, myValues);
            Dealer myDealer = new Dealer(myDeck);
            Hand myHand = new Hand(myDeck.deal(), myDeck.deal());
            while (myHand.totalValue <= 21){
                myHand.printHand();
                myDealer.h.
            }
        }
    }
}
