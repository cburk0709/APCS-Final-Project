 public class Card {

    private String rank;
    private int pointValue;

    public Card(String cardRank, int cardPointValue) {
        rank = cardRank;
        pointValue = cardPointValue;
    }
    public String rank() { return rank; }
    public int pointValue() { return pointValue; }

    public boolean matches(Card otherCard) {
        if(otherCard.rank().equals(this.rank()) && otherCard.pointValue() == this.pointValue())
            return true;
        else
            return false;
    }
    //Make it ascii
    public String toString() {

        String top= " ____";
        String topTen= " ____";
        String midTopx= "|"+rank+"   |";
        String tenmidTopx= "|"+rank+"  |";
        String midBot="|    |";
        String Botx="|___" + rank + "|";
        String tenBotx="|__" + rank + "|";
        String midBotTen="|    |";
        if(rank != "10") {
            return top + "\n" + midTopx + "\n" + midBot + "\n" + Botx;
        }else{
            return topTen + "\n" + tenmidTopx + "\n" + midBotTen + "\n" + tenBotx;

        }
    }
}

 /* ____
   |K   |
   |    |
   |___K| */

 /* _____
   |10   |
   |     |
   |___10|  */

 /* _____
   |     |
   |     |
   |_____|

  */