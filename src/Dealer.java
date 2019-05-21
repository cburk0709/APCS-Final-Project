public class Dealer{
    public int totalValue;

    public Hand h;

    public Dealer(Deck deck){
        h=new Hand(deck.deal(),deck.deal());
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

