package main.java.tools;

/**
 * Card class handling the value, suit, and display image of individual card.
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-23
 */
public class Card {

    private static final String backImageURL = "/main/resources/Gray_back.jpg";
    private final String imageURL; // Image of the card to display while playing

    private final Suit suit;
    private final int number; // 1 = Ace | 2-10 = 2-10 | 11 = Jack | 12 = Queen | 13 = King

    // Allows for quick conversion from number to abbreviated card type
    private static final String[] values = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private boolean isVisible = false;

    /**
     * Makes it easier to state which suit a card is
     */
    public enum Suit {
        SPADE,
        CLUB,
        HEART,
        DIAMOND
    }

    public Card(int number, Suit suit) throws IllegalArgumentException {

        //Exceptions
        if (number < 1 || number > 13) {
            throw new IllegalArgumentException(String.format("Number (%d) is not within valid range of [1, 13].", number));
        }

        if (suit == null) {
            throw new IllegalArgumentException("Suit cannot be null.");
        }

        // Set instance variable values
        this.number = number;
        this.suit = suit;

        // Image files are saved in the format of "{Number/AJQK}{Suit Abbreviation}.jpg"
        imageURL = String.format("/main/resources/%s%c.jpg", values[number - 1], suit.toString().charAt(0));
    }

    // Getter methods for suit, number, value, and image

    public Suit getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return values[number - 1];
    }

    public String getImageURL() {
        if (isVisible) {
            return imageURL; // Only return front-face of card if it is visible.
        }
        return backImageURL;
    }

    // Getter and Setter method for Card visibility
    public boolean getVisibility() {
        return isVisible;
    }

    public void flip() {
        isVisible = !isVisible;
    }
}
