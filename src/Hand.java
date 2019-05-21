import java.util.*;
public class Hand implements Controls{
    //ace will change to 1 from 11 if you bust
    int aces=0;
    int totalValue;
    ArrayList<Card> cards = new ArrayList<>();
    public Hand(Card a, Card b){
        if (a.pointValue()==11){
            aces++;
        }
        if (b.pointValue()==11){
            aces++;
        }
        totalValue=a.pointValue()+b.pointValue();
        cards.add(a);
        cards.add(b);
    }

    public void printHand(){
        for (Card card : cards){
            System.out.println(card.toString());
        }
        System.out.println("Total Value: "+totalValue);
    }

    public void hit(Deck d){
        //This might cause a problem if deck is empty; Card might not be able to be set to null
        Card c = d.deal();
        if (c==null){
            System.out.println("Deck is empty, game is over.");
        }else{
            if(c.pointValue()==11){
                aces++;
            }
            cards.add(c);
            printHand();
        }
        totalValue+=c.pointValue();
        while(totalValue>21){
            if (aces>0){
                totalValue-=10;
                aces--;
            }else{
                System.out.println("Player busts with a "+totalValue+".");
            }
        }
        System.out.println("Highest hand value is "+totalValue+".");
    }
    public void stay(){
        System.out.println("Player stays.");
    }
}
