import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        d1.shuffle();
        Hand h1 = new Hand();
        h1.addCard(d1.get(0));
        d1.discard(0);
        h1.printHand();
        h1.addCard(d1.get(0));
        d1.discard(0);
        h1.printHand();
        h1.removeCard(0);
        h1.printHand();
    }
}
