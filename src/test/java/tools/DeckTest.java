package test.java.tools;

// Tool imports

import main.java.tools.Deck;
import main.java.tools.Card;

// JUnit imports

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck;
    Deck doubleDeck;

    @Before
    public void setup() {
        deck = new Deck();
        doubleDeck = new Deck(2);
    }

    @Test
    public void initialSizeTest() {
        assertEquals(52, deck.getDeckSize());
        assertEquals(104, doubleDeck.getDeckSize());

        assertEquals(0, deck.getDiscardSize());
        assertEquals(0, doubleDeck.getDiscardSize());
    }

    @Test
    public void discardTest() {
        assertEquals(52, deck.getDeckSize());

        Card card = deck.draw();
        assertEquals(51, deck.getDeckSize());
        assertEquals(0, deck.getDiscardSize()); // Drawing shouldn't affect discard stack

        deck.discard(card);
        assertEquals(51, deck.getDeckSize()); // Discarding shouldn't affect deck stack
        assertEquals(1, deck.getDiscardSize());
    }

    @Test
    public void shuffleTest() {
        int size = deck.getDeckSize();
        deck.shuffle();
        assertEquals(size, deck.getDeckSize());
        assertNotEquals(deck, new Deck()); // Make sure the decks are not the same after a shuffle
    }

    @Test
    public void invalidDeckSizeTest() {

        try {
            new Deck(-1);
            fail("Invalid deck sizes should throw IllegalArgumentException.");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

    }

}
