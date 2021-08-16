package main.java.modes;

import main.java.tools.Card;
import main.java.tools.Deck;

/**
 * Commonalities among all gamemodes
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-16
 */
public abstract class Game {

    protected Deck deck; // The deck of cards that will be used in each gamemode (subclass).

    /**
     * Default Constructor that creates a deck containing only one copy of each card.
     */
    protected Game() {
        deck = new Deck();
    }

    /**
     * Constructor that creates an abnormally sized deck of cards for the game.
     * @param copies : amount of copies of each card to be present in the deck
     */
    protected Game(int copies) {
        deck = new Deck(copies);
    }

    /**
     * Removes a given amount of cards from the deck and returns them in an array.
     * This gives the cards needed to set up a game of solitaire, with each gamemode doing different things with the
     * returned cards.
     * @param dealSize : amount of cards to deal
     * @return an array of Cards removed from the deck
     */
    protected Card[] deal(int dealSize) {
        Card[] dealtCards = new Card[dealSize];

        for (int i = 0; i < dealSize; i++) {
            dealtCards[i] = deck.draw();
        }

        return dealtCards;
    }

    
}
