public class Deck {
    private Card[] deck;

    public Deck() {
        deck = new Card[52];
        for (int i=0; i < 4; i++) {
            int index = 0;
            deck[13*i + index++] = new Card("Ace", "A", 1, i);
            deck[13*i + index++] = new Card("Two", "2", 2, i);
            deck[13*i + index++] = new Card("Three", "3", 3, i);
            deck[13*i + index++] = new Card("Four", "4", 4, i);
            deck[13*i + index++] = new Card("Five", "5", 5, i);
            deck[13*i + index++] = new Card("Six", "6", 6, i);
            deck[13*i + index++] = new Card("Seven", "7", 7, i);
            deck[13*i + index++] = new Card("Eight", "8", 8, i);
            deck[13*i + index++] = new Card("Nine", "9", 9, i);
            deck[13*i + index++] = new Card("Ten", "10", 10, i);
            deck[13*i + index++] = new Card("Jack", "J", 10, i);
            deck[13*i + index++] = new Card("Queen", "Q", 10, i);
            deck[13*i + index] = new Card("King", "K", 10, i);
        }
    }

    public Card at(int index) {
        return deck[index];
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public Card[] getDeck() {
        return deck;
    }

}
