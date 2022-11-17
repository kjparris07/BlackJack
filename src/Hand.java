import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private String[] prettyHand = new String[4];
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
            for (int j=0; j < 4; j++) {
                if (i == 0) {
                    prettyHand[j] = cards[i].getCard()[j];
                } else {
                    prettyHand[j] += cards[i].getCard()[j];
                }
            }
        }
    }

    public Hand(ArrayList<Card> cards) {
        hand = new ArrayList<>();
        handValue = 0;
        numCards = cards.size();

        for (int i=0; i < numCards; i++) {
            hand.add(cards.get(i));
            handValue += cards.get(i).getValue();
            for (int j=0; j < 4; j++) {
                if (i == 0) {
                    prettyHand[j] = cards.get(i).getCard()[j];
                } else {
                    prettyHand[j] += cards.get(i).getCard()[j];
                }
            }
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
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
        String[] card = c.getCard();
        for (int i=0; i < card.length; i++) {
            if (prettyHand[i] == null) {
                prettyHand[i] = card[i];
            } else {
                prettyHand[i] += card[i];
            }
        }
    }

    public Card removeCard(int index) {
        if (index >= 0 && index < numCards) {
            Card c = hand.get(index);
            hand.remove(index);
            handValue -= c.getValue();
            numCards--;

            int cardIndex = 7*index;
            for (int i=0; i < 4; i++) {
                String str = prettyHand[i];
                prettyHand[i] = str.substring(0, cardIndex) + str.substring(cardIndex+7, str.length());
            }
            return c;
        }
        return null;
    }

    public Card removeCard(Card c) {
        int index = findCard(c);
        if (index != -1) {
            return removeCard(index);
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

    public void printHand() {
        for (String s : prettyHand) System.out.println(s);
    }
}
