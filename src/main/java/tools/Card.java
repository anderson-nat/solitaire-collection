package main.java.tools;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Card {

    private final Image image;
    private final Suit suit;
    private final int number; // 1 = Ace | 2-10 = 2-10 | 11 = Jack | 12 = Queen | 13 = King

    // Allows for quick conversion from number to abbreviated card type
    private final String[] values = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public enum Suit {
        SPADE(Color.BLACK),
        CLUB(Color.BLACK),
        HEART(Color.RED),
        DIAMOND(Color.RED);

        Color color;

        Suit(Color color) {
            this.color = color;
        }
    }

    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;

        image = new Image(String.format("/main/resources/%s%c.jpg", values[number - 1], suit.toString().charAt(0)));
    }
}
