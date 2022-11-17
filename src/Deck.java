import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (int i=0; i < 4; i++) {
            deck.add(new Card("Ace", "A", 1, i));
            deck.add(new Card("Two", "2", 2, i));
            deck.add(new Card("Three", "3", 3, i));
            deck.add(new Card("Four", "4", 4, i));
            deck.add(new Card("Five", "5", 5, i));
            deck.add(new Card("Six", "6", 6, i));
            deck.add(new Card("Seven", "7", 7, i));
            deck.add(new Card("Eight", "8", 8, i));
            deck.add(new Card("Nine", "9", 9, i));
            deck.add(new Card("Ten", "10", 10, i));
            deck.add(new Card("Jack", "J", 10, i));
            deck.add(new Card("Queen", "Q", 10, i));
            deck.add(new Card("King", "K", 10, i));
        }
    }

    public Card get(int index) {
        return deck.get(index);
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

}
