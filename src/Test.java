import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        ArrayList<Card> cards = d1.getDeck();
        for (int i=1; i < cards.size(); i++) {
            System.out.println(cards.get(i).compareTo(cards.get(i-1)));
        }
    }
}
