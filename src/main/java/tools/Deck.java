package main.java.tools;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Deck class that includes basic functionality for initialization, shuffling, and drawing.
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-12
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
    public Deck(int copies) {
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
        final Random random = new Random();

        Card[] temp = new Card[deck.size()];
        List<Card> buffer = Arrays.asList(deck.toArray(temp));

        deck.clear();
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
}
