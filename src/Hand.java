import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private String[] prettyHand = new String[4];

    public Hand() {
        hand = new ArrayList<>();
    }

    public Hand(Card[] cards) {
        hand = new ArrayList<>();

        for (int i=0; i < cards.length; i++) {
            hand.add(cards[i]);
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

        for (int i=0; i < cards.size(); i++) {
            hand.add(cards.get(i));
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
        int val = 0;
        for (Card c : hand) val += c.getValue();
        return val;
    }

    public void addCard(Card c) {
        hand.add(c);
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
        if (index >= 0 && index < hand.size()) {
            Card c = hand.get(index);
            hand.remove(index);

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
        for (int i=0; i < hand.size(); i++) {
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
