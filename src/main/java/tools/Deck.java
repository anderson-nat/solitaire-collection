package main.java.tools;

import java.util.*;

/**
 * Deck class that includes basic functionality for initialization, shuffling, and drawing.
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-23
 */
public class Deck {

    private final Stack<Card> deck = new Stack<>();
    private final Stack<Card> discard = new Stack<>();

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
    public Deck(int copies) throws IllegalArgumentException {

        if (copies < 1) throw new IllegalArgumentException("Copies parameter must be >= 1.");

        for (int iteration = 0; iteration < copies; iteration++) {
            for (int number = 1; number <= 13; number++) {
                for (Card.Suit suit : Card.Suit.values()) {
                    deck.push(new Card(number, suit));
                }
            }
        }

        this.shuffle();
    }

    /**
     * Shuffles the cards, randomizing their order
     */
    public void shuffle() {
        final Random random = new Random(); // Initialize a Random object to allow for random number generation

        // Copy the deck into a new List
        Card[] temp = new Card[deck.size()];
        ArrayList<Card> buffer = new ArrayList<>(Arrays.asList(deck.toArray(temp)));

        // Clear the deck
        deck.clear();

        // Add the cards back into the deck randomly until the copy list is empty.
        do {
            Card removed = buffer.remove(random.nextInt(buffer.size()));
            deck.push(removed);
        } while (!buffer.isEmpty());
    }

    /**
     * Removes the top card of the deck and returns it
     * If the deck was empty, cards from the discard pile are added back into the deck
     * @return the card removed from the top of the deck
     */
    public Card draw() {
        // If the deck is empty, add every card from discard back into the deck
        if (deck.isEmpty()) {
            do {
                deck.push(discard.pop());
            } while (!discard.isEmpty());
            this.shuffle();
        }


        return deck.pop();
    }

    /**
     * Adds a card to the discard stack
     * @param card : the card to add to the discard stack
     */
    public void discard(Card card) {
        discard.push(card);
    }

    /**
     * Checks to see if a deck is equal to another object
     * @param object : The object to check against this deck
     * @return true if the object is equal, false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof Deck) {

            Deck otherDeck = (Deck)object;
            return deck.equals(otherDeck.deck) && discard.equals(otherDeck.discard);

        }

        return false;
    }

    // Getter methods for deck and discard stack sizes
    public int getDeckSize() {
        return deck.size();
    }

    public int getDiscardSize() {
        return discard.size();
    }
}
