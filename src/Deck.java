import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;

    public Deck() {
        deck = new ArrayList<>();
        discard = new ArrayList<>();
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

    public Card discard(Card c) {
        int index = findCard(c);
        if (index != -1) {
            return discard(index);
        }
        return null;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Card temp = deck.get(index);
            deck.set(index, deck.get(i));
            deck.set(i, temp);
        }
    }

    public Card discard(int index) {
        if (index > -1 && index < deck.size()) {
            Card c = deck.get(index);
            deck.remove(index);
            discard.add(c);
            return c;
        }
        return null;
    }

    // does not shuffle, just adds the cards to the bottom of the deck
    public void restoreDiscards() {
        deck.addAll(discard);
        discard = new ArrayList<>();
    }

    private int findCard(Card c) {
        for (int i=0; i < deck.size(); i++) {
            if (deck.get(i).compareTo(c) != -1) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

}
