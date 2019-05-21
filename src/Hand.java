import java.util.*;
public class Hand implements Controls{

    //aces will change from 1 to 11 if you bust; each ace can decrease totalValue by 10 if you bust
    int aces=0;

    //totalValue is the highest value the hand can have that's less than or equal to 21
    int totalValue;

    //cards stores all of the Card objects that belong in a Hand object
    ArrayList<Card> cards = new ArrayList<>();

    //the constructor for Hand takes two Cards, anticipating use of <deck name>.deal() within constructor
    public Hand(Card a, Card b){
        //records if either Card is an ace
        if (a.pointValue()==11){
            aces++;
        }
        if (b.pointValue()==11){
            aces++;
        }
        //updates totalValue; if you have 22 assumes you have an ace and updates
        totalValue=a.pointValue()+b.pointValue();
        if(totalValue==22){
            aces--;
            totalValue-=10;
        }
        //adds both Cards to cards
        cards.add(a);
        cards.add(b);
    }

    //prints first Card in cards; used for Dealer
    public void printFirstCard(){
        System.out.println(cards.get(0).toString());
    }


    //prints each Card in Hand object
    public void printHand(){
        for (Card card : cards){
            System.out.println(card.toString());
        }
        System.out.println("Total Value: "+totalValue);
    }


    //hit uses a Deck parameter to deal from that Deck

    //might cause problems with not changing the actual Deck class in client code
    public void hit(Deck d){
        //might cause a problem if deck is empty; Card might not be able to be set to null
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
        //updates totalValue; checks for bust and if the player busts changes aces, if any, from 11 to 1
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


    //stay just prints something, might have to change
    public void stay(){
        System.out.println("Player stays.");
    }
}
