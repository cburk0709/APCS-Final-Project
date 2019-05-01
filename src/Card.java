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
        return "";
    }
}
