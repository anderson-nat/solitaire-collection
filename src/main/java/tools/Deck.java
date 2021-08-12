package main.java.tools;

import java.util.Stack;

/**
 * Abstract Deck class that includes basic functionality for initialization, shuffling, and drawing.
 * Individual solitaire types may have different functionalities for things such as a discard pile, so each one will
 * have a separate sub-class to handle those differences
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-12
 */
public abstract class Deck {

    private final Stack<Card> deck = new Stack<>();

    /**
     * Default Constructor
     * Creates a standard deck of cards with only 1 copy of each card inside it.
     */
    public Deck() {
        this(1);
    }

    /**
     * Creates a deck of cards which contains n copies of each card, as specified by the copies parameter
     * @param copies : the number of copies of each card that should appear in this deck
     */
    public Deck(int copies) {
        for (int iteration = 0; iteration < copies; iteration++) {
            for (int number = 1; number <= 13; number++) {
                for (Card.Suit suit : Card.Suit.values()) {
                    deck.push(new Card(number, suit));
                }
            }
        }
    }

    /**
     * Shuffles the cards, randomizing their order
     */
    public void shuffle() {

    }

    /**
     * Removes the top card of the deck and returns it
     * @return the card removed from the top of the deck
     */
    public Card draw() {
        return deck.pop();
    }
}
