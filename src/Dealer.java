public class Dealer implements Controls {
    private int totalValue;

    public void stay(){
        System.out.println("Stay!");
    }

    public Card hit(){
        System.out.println("Hit!");
      return Deck.deal();
    }

    public boolean toHit() {
        if (totalValue <= 16) {
            return true;
        } else
            return false;
    }



}


        //has a hand object
    //hits on 16
    //stays on anything higher
    //print statement for a card

