import java.util.ArrayList;

public class BlackJack {
    public static void main(String[] args) {
        Deck d = new Deck();
        Card c1 = new Card("Ace", "A", 11 ,3);
        Card c2 = new Card("Ten", "10", 10, 1);
        Card c3 = new Card("Queen", "Q", 10, 3);
        d.get(0).setValue(11);
        Hand h = new Hand(new Card[] {c1, c2, c3});
        h.printHand();
        System.out.println(h.getHandValue());
        hit(h, d);
        h.printHand();
        System.out.println(h.getHandValue());
    }

    // returns the value of the hand after a hit
    private static int hit(Hand h, Deck d) {
        h.addCard(d.get(0));
        d.discard(d.get(0));

        if (h.getHandValue() > 21) {
            ArrayList<Integer[]> aces = checkForAces(h);
            while (aces.size() > 0 && h.getHandValue() > 21) {
                int index = aces.get(0)[0];
                int value = aces.get(0)[1];
                if (value == 11) {
                    toggleAce(h, index);
                }
                aces.remove(0);
            }
        }
        return h.getHandValue();
    }

    private static ArrayList<Integer[]> checkForAces(Hand h) {
        ArrayList<Integer[]> aces = new ArrayList<>();
        ArrayList<Card> hand = h.getHand();

        for (int i=0; i < hand.size(); i++) {
            Card c = hand.get(i);
            if (c.getName().equals("Ace")) {
                aces.add(new Integer[] {i, c.getValue()});
            }
        }
        return aces;
    }

    private static void toggleAce(Hand h, int index) {
        Card c = h.getHand().get(index);
        if (c.getName().equals("Ace")) {
            if (c.getValue() == 1) {
                c.setValue(11);
            } else {
                c.setValue(1);
            }
        }
    }
}
