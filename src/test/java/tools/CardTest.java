package test.java.tools;

// Card imports
import main.java.tools.Card;

import static main.java.tools.Card.Suit.*;

// JUnit imports
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    Card card;

    @Test
    public void invalidPositiveNumberTest() {

        try {
            card = new Card(14, SPADE);
            fail("Invalid card number should throw IllegalArgumentException");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass()); // Make sure it is IllegalArgumentException
        }

    }

    @Test
    public void invalidNegativeNumberTest() {

        try {
            card = new Card(-1, SPADE);
            fail("Invalid card number should throw IllegalArgumentException");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass()); // Make sure it is IllegalArgumentException
        }

    }

    @Test
    public void nullSuitTest() {

        try {
            card = new Card(12, null);
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    public void validCardTest() {

        try {
            card = new Card(12, SPADE);

            // Make sure values are set correctly
            assertEquals(12, card.getNumber());
            assertEquals(SPADE, card.getSuit());
            assertEquals("Q", card.getValue());
            assertEquals("/main/resources/Gray_back.jpg", card.getImageURL());
            card.flip();
            assertEquals("/main/resources/QS.jpg", card.getImageURL());
        } catch (Exception e) {
            fail(String.format("%s should not be thrown with valid inputs.", e.getClass().toString()));
        }
    }

    @Test
    public void cardFlipTest() {
        card = new Card(12, SPADE);

        assertFalse(card.getVisibility());
        card.flip();
        assertTrue(card.getVisibility());
    }

}
