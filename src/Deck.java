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

    public void sort() {
        quicksort(0, deck.size() - 1);
    }

    private void quicksort(int lo, int hi) {
        if (lo <= hi) {
            int pivot = lo++;
            int index = partition(pivot, lo, hi);
            if (index > 1) {
                quicksort(pivot, index - 1);
            }
            if (index < deck.size() - 2) {
                quicksort(index + 1, hi);
            }
        }
    }

    private int partition(int pivot, int lo, int hi) {
        Card pivotVal = deck.get(pivot);
        Card loVal = deck.get(lo);
        Card hiVal = deck.get(hi);

        while (lo < deck.size() - 1 && loVal.compareTo(pivotVal) >= 0) {
            loVal = deck.get(++lo);
        }

        while (hi > pivot && hiVal.compareTo(pivotVal) <= 0) {
            hiVal = deck.get(--hi);
        }

        if (lo < hi) {
            deck.set(lo, hiVal);
            deck.set(hi, loVal);
            return partition(pivot, lo, hi);
        } else {
            deck.set(pivot, hiVal);
            deck.set(hi, pivotVal);
            return hi;
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

    public void printDeck(int start) {
        for (int i = start; i < deck.size(); i++) {
            System.out.println(deck.get(i));
        }
    }

    public void printDeck(int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.println(deck.get(i));
        }
    }

}
