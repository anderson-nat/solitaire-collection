package main.java.tools;

import javafx.scene.image.Image;

/**
 * Card class handling the value, suit, and display image of individual card.
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-12
 */
public class Card {

    private final Image image; // Image of the card to display while playing
    private final Suit suit;
    private final int number; // 1 = Ace | 2-10 = 2-10 | 11 = Jack | 12 = Queen | 13 = King

    // Allows for quick conversion from number to abbreviated card type
    private final String[] values = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * Makes it easier to state which suit a card is
     */
    public enum Suit {
        SPADE,
        CLUB,
        HEART,
        DIAMOND
    }

    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;

        // Image files are saved in the format of "{Number/AJQK}{Suit Abbreviation}.jpg"
        image = new Image(String.format("/main/resources/%s%c.jpg", values[number - 1], suit.toString().charAt(0)));
    }
}
