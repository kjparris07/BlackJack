public class Card {
    private String name, face;
    private int value, suit;

    public Card(String name, String face, int value, int suit) {
        this.name = name;
        this.face = face;
        this.value = value;
        if (suit > -1 && suit < 4) {
            this.suit = suit;
        } else {
            this.suit = 0;
        }
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        if (suit > -1 && suit < 4) {
            this.suit = suit;
        }
    }

    public String[] getCard() {
        String icon;
        if (suit == 0) {
            icon = "\u2663"; // clubs
        } else if (suit == 1) {
            icon = "\u2666"; // diamonds
        } else if (suit == 2) {
            icon = "\u2665"; // hearts
        } else if (suit == 3) {
            icon = "\u2660"; // spades
        } else {
            icon = "X";
        }
        String[] card = new String[4];
            card[0] = " _____ ";
            card[2] = "|  " + icon + "  |";
            card[3] = "|_____|";
        if (this.face.equals("10")) {
            card[1] = "|" + face + "   |";
        } else {
            card[1] = "|" + face + "    |";
        }
        return card;
    }

    public int compareTo(Card c) {
        if (this.suit > c.suit) {
            return -1;
        } else if (this.suit < c.suit) {
            return 1;
        } else {
            if (this.value > c.value) {
                return -1;
            } else if (this.value < c.value) {
                return 1;
            } else {
                if (this.face.equals("10")) {
                    if (c.face.equals("10")) return 0;
                    return 1;
                }
                if (this.face.equals("J")) {
                    if (c.face.equals("10")) return -1;
                    if (c.face.equals("J")) return 0;
                    return 1;
                }
                if (this.face.equals("Q")) {
                    if (c.face.equals("Q")) return 0;
                    if (c.face.equals("K")) return 1;
                    return -1;
                }
                if (c.face.equals("K")) return 0;
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return "Card[" + "name=" + name + ", face=" + face + ", value=" + value +
                    ", suit=" + suit + ']';
    }
}
