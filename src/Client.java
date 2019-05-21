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
        int[] myValues = {1, 2, 3, 4, 5, 6, 7 , 8, 9, 10, 11};
        String[] myRanks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A"};
        Deck myDeck = new Deck(myRanks, myValues);
        while (conditional != "quit"){
            System.out.println("Welcome to Blackjack. To play, enter any token besides \"Q\"");
            conditional = userInput.next();

       //     while(totalCount <= 21){

         //   }
        }
    }
}
