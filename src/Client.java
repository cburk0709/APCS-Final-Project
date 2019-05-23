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

        while (!conditional.equals("quit") || !conditional.equals("no")){
            System.out.println("Welcome to Blackjack. To play, enter any token besides \"quit\"");
            conditional = userInput.next();
            int[] myValues =   {2,   3,   4,   5,   6,   7 ,  8,   9,    10,   10,  10, 10, 11};
            String[] myRanks = {"2", "3", "4", "5", "6", "7", "8", "9",  "10", "J", "Q", "K", "A"};
            Deck myDeck = new Deck(myRanks, myValues);
            Dealer myDealer = new Dealer(myDeck);
            Hand myHand = new Hand(myDeck.deal(), myDeck.deal());
            boolean gameState = true;
            while (gameState){
                System.out.println("Dealer Cards:");
                myDealer.h.printFirstCard();

                System.out.println();
                System.out.println("Your hand:");
                myHand.printHand();

                System.out.print("hit or stay? -- ");
                String hitOrStay = "";
                hitOrStay = userInput.next();
                while (hitOrStay.equals("hit")){
                    myHand.hit(myDeck);
                    myHand.printHand();
                    System.out.print("hit or stay? -- ");
                    hitOrStay = userInput.next();
                }
                while (myDealer.h.totalValue<=16) {
                    myDealer.h.hit(myDeck);
                }
                myDealer.h.printHand();
                if (myHand.totalValue <= 21 && myHand.totalValue > myDealer.h.totalValue){
                    System.out.println("Player wins");
                } else {
                    System.out.println("Dealer wins");
                }
                System.out.println("Play again? (yes or no) -- ");
                conditional = userInput.next();
                gameState = false;
            }
        }
    }
}
