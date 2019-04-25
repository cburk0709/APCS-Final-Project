import java.util.ArrayList;
import java.lang.Math;

public class Deck {
    //cards array is the deck itself, a collection of card objects
    private ArrayList<Card> cards = new ArrayList<>();
    private int size;
    //constructor
    public Deck(String[] ranks, String[] suits, int[] values) {
        //two-deep for loop to ensure that all fields are assigned correctly
        for(int i = 0; i < ranks.length; i++){
            for(int j = 0; j < suits.length; j++){
                cards.add(new Card(ranks[i], suits[j], values[i]));
            }
        }
        //sets the size variable
        size = cards.size();
        //shuffle for good measure
        shuffle();
    }
    //checks whether or not the deck is empty
    public boolean isEmpty() {
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    public int getSize(){
        return size;
    }

    //shuffles the remaining deck
    public void shuffle() {
        for(int k = size - 1; k >= 0; k--) {
            int rand = (int)(Math.random() * k);
            Card temp = cards.get(rand);
            Card swap = cards.get(k);
            cards.set(rand, swap);
            cards.set(k, temp);
        }
    }

    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        //takes one off the top in a sense, the actual card isn't removed from the array, but rather the index is moved
        //so that it might as well have been
        size--;
        //returns the new top card
        return cards.get(size);
    }

    public String toString() {
        String deckDescription = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            deckDescription = deckDescription + cards.get(k);
            if (k != 0) {
                deckDescription = deckDescription + ", ";
            }
            if ((size - k) % 2 == 0) {
                deckDescription = deckDescription + "\n";
            }
        }

        deckDescription = deckDescription + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            deckDescription = deckDescription + cards.get(k);
            if (k != size) {
                deckDescription = deckDescription + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                deckDescription = deckDescription + "\n";
            }
        }

        deckDescription = deckDescription + "\n";
        return deckDescription;
    }
}