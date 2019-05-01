public class Dealer{
    private int totalValue;

    //Checks if dealer is going to hit or stay
    public boolean toHit() {
        if (totalValue <= 16) {
            return true;
        } else
            return false;
    }
    //prints out the cards dealer has
    public static void printCards(){
        System.out.println("Dealers Cards");
    }



}


    //has a hand object
    //hits on 16
    //stays on anything higher
    //print statement for a card

