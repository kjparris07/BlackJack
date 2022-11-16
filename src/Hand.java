import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private int handValue, numCards;

    public Hand() {
        hand = new ArrayList<>();
        handValue = 0;
        numCards = 0;
    }

    public Hand(Card[] cards) {
        hand = new ArrayList<>();
        handValue = 0;
        numCards = cards.length;

        for (int i=0; i < numCards; i++) {
            hand.add(cards[i]);
            handValue += cards[i].getValue();
        }
    }

    public Hand(ArrayList<Card> cards) {
        hand = new ArrayList<>();
        handValue = 0;
        numCards = cards.size();

        for (int i=0; i < numCards; i++) {
            hand.add(cards.get(i));
            handValue += cards.get(i).getValue();
        }
    }

    public int getHandValue() {
        return handValue;
    }

    public int getNumCards() {
        return numCards;
    }

    public void addCard(Card c) {
        hand.add(c);
        handValue += c.getValue();
        numCards++;
    }

    public Card removeCard(Card c) {
        int index = findCard(c);
        if (index != -1) {
            hand.remove(index);
            handValue -= c.getValue();
            numCards--;
            return c;
        }
        return null;
    }

    private int findCard(Card c) {
        for (int i=0; i < numCards; i++) {
            if (hand.get(i).compareTo(c) == 0) {
                return i;
            }
        }
        return -1;
    }
}
