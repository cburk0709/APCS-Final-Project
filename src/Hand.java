import java.util.*;
public class Hand implements Controls{
    //ace will change to 1 from 11 if you bust
    int aces=0;
    int totalValue=0;
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
}
