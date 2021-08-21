package test.java.tools;

// Card Imports
import main.java.tools.Card;

import static main.java.tools.Card.Suit.*;

// JUnit Imports
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CardTest {

    Card card;

    @Test
    public void validNumberTest() {
        try {
            card = new Card(12, SPADE);

            assertEquals(12, card.getNumber());
            assertEquals(SPADE, card.getSuit());
            assertEquals("Q", card.getValue());
        } catch (Exception e) {
            fail("Exception should not be thrown when arguments are valid.");
        }
    }

    @Test
    public void invalidPositiveNumberTest() {
        try {
            card = new Card(14, SPADE);
            fail("Invalid Card number should throw IllegalArgumentException.");
        } catch (IllegalArgumentException exception) {
            String message = exception.getMessage();
            String expected = invalidNumberMessage(14);

            assertEquals(expected, message); // Make sure the correct error message is used.
        } catch (Exception e) {
            fail("Invalid Card number should throw IllegalArgumentException.");
        }
    }

    @Test
    public void invalidNegativeNumberTest() {
        try {
            card = new Card(-1, SPADE);
            fail("Invalid Card number should throw IllegalArgumentException.");
        } catch (IllegalArgumentException exception) {
            String message = exception.getMessage();
            String expected = invalidNumberMessage(-1);

            assertEquals(expected, message);
        } catch (Exception e) {
            fail("Invalid Card number should throw IllegalArgumentException.");
        }
    }

    private String invalidNumberMessage(int number) {
        return String.format("Number (%d) not within valid range of [1, 13].", number);
    }
}

