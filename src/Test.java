import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        d1.shuffle();
        d1.printDeck();
        System.out.println("- - - - - - - - - -");
        d1.sort();
        d1.printDeck();
    }
}
