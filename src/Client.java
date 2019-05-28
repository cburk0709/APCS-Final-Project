import java.util.Scanner;

public class Client {

    //Client code only uses a main method
    public static void main(String[] args) {

        //Initialization of standard game variables for betting and user input
        Scanner userInput = new Scanner(System.in);
        int balance = 0;
        int myBet = 0;

        //This loop checks if the player inputs a valid balance (>0) and will remind the player if they don't
        //Also records balance entered
        while (true){
            System.out.println("Welcome to Blackjack! Enter a starting balance! -- $");
            balance = userInput.nextInt();
            if(balance > 0){
                break;
            }else{
                System.out.println("Please enter a valid balance.");
            }
        }

        //This loop will run until the player goes broke or manually exits the game
        while (true){
            while (true){

                //Prints balance and updates bet
                System.out.print("You have $" + balance + "! How much do you bet? -- $");
                myBet = userInput.nextInt();

                //Checks to see if bet is valid (>0 and <balance)
                if((myBet > 0)&&(myBet<=balance)){
                    System.out.println("You bet $" + myBet + "! Good luck!");
                    break;
                }else{
                    System.out.print("Please enter a valid bet.");
                    if(myBet>balance){
                        System.out.println(" Your bet may not be greater than your balance.");
                    }else{
                        System.out.println();
                    }
                }
            }

            //Constructs a Deck object using the standard values and ranks of a card deck
            int[] myValues =   {2,   3,   4,   5,   6,   7 ,  8,   9,    10,   10,  10, 10, 11};
            String[] myRanks = {"2", "3", "4", "5", "6", "7", "8", "9",  "10", "J", "Q", "K", "A"};
            Deck myDeck = new Deck(myRanks, myValues);

            //Constructs a Dealer object using myDeck as a parameter (the dealer has a Hand object constructed by dealing two cards from myDeck)
            Dealer myDealer = new Dealer(myDeck);

            //Constructs a Hand object for the player by dealing two cards from myDeck
            Hand myHand = new Hand(myDeck.deal(), myDeck.deal());

            //gameState is the sentinel used to exit this while loop
            boolean gameState = true;
            while (gameState){

                //Prints Dealer's first card and a blank card
                System.out.println("Dealer Cards:");
                myDealer.h.printFirstCard();
                System.out.println(" ____"+"\n"+"|    |"+"\n"+"|    |"+"\n"+"|____|");
                System.out.println();

                //Prints player's first 2 cards and card value
                System.out.println("Your hand:");
                myHand.printHand();
                System.out.println();

                //Asks user to hit or stay
                System.out.print("hit or stay? -- ");
                String hitOrStay;
                hitOrStay = userInput.next();

                //Repeats until player busts or stays
                while (hitOrStay.equals("hit")){

                    //Calls hit() method in Hand with parameter of myDeck, then prints player's hand
                    myHand.hit(myDeck);
                    myHand.printHand();
                    System.out.println();

                    //Breaks loop if player busts
                    if (myHand.totalValue > 21){
                        break;
                    }
                    System.out.print("hit or stay? -- ");
                    hitOrStay = userInput.next();
                }

                if (myHand.totalValue <= 21) {
                    int hits = 0;

                    //Dealer hits on or below 16
                    while (myDealer.h.totalValue <= 16) {
                        myDealer.h.hit(myDeck);
                        hits++;
                    }

                    //Tells user how many times the dealer hits
                    if (hits == 0) {
                        System.out.println("Dealer doesn't hit.");
                    }
                    if (hits == 1) {
                        System.out.println("Dealer hits once.");
                    }
                    if (hits == 2) {
                        System.out.println("Dealer hits twice.");
                    }
                    if (hits > 2) {
                        System.out.println("Dealer hits " + hits + " times.");
                    }

                    //Prints dealer's full hand
                    myDealer.h.printHand();
                    System.out.println();
                }

                //Checks all win conditions and evaluates if myBet will be added (win) or subtracted (loss) to balance
                //Player win
                if (myHand.totalValue <= 21 && (myHand.totalValue > myDealer.h.totalValue || myDealer.h.totalValue > 21)){
                    System.out.println("Player wins!");

                    //Neither busts
                    if(myHand.totalValue>myDealer.h.totalValue){
                        System.out.println("Player had a "+myHand.totalValue+", the dealer only had a "+myDealer.h.totalValue+"!");

                    //Dealer busts
                    }else if(myDealer.h.totalValue>21){
                        System.out.println("Dealer busted with a "+myDealer.h.totalValue+"!");
                    }

                    //Evaluates balance
                    System.out.println("You won your bet of $"+myBet+".");
                    balance+=myBet;
                //Dealer win
                } else {
                    System.out.println("Dealer wins!");

                    //Neither busts
                    if(myDealer.h.totalValue>myHand.totalValue){
                        System.out.println("Dealer had a "+myDealer.h.totalValue+", the player only had a "+myHand.totalValue+"!");

                    //Tie
                    }else if(myDealer.h.totalValue==myHand.totalValue){
                        System.out.println("Player and dealer tie with a "+myHand.totalValue+"! Tie goes to the house.");
                    //Player busts
                    }else if(myHand.totalValue>21){
                        System.out.println("Player busted with a "+myHand.totalValue+"!");
                    }

                    //Evaluates balance
                    System.out.println("You lost your bet of $"+myBet+".");
                    balance-=myBet;
                }
                gameState = false;

                //Terminates the game if you go broke
                if(balance==0){
                    System.out.println("You're out of money! Guess what you win...");
                    System.exit(0);
                }
            }
        }
    }
}
