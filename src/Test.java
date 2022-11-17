import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Card c1 = new Card("King", "K", 10, 0);
        Card c2 = new Card("Ten", "10", 10, 3);

        String[] c1Arr = c1.getCard();
        String[] c2Arr = c2.getCard();

        String[] hand = new String[c1Arr.length];
        for (int i=0; i < c1Arr.length; i++) {
            hand[i] = c1Arr[i] + " " + c2Arr[i];
        }

        for (String s : hand) {
            System.out.println(s);
        }
    }
}
