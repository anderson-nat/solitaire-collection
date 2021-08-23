package test.java.tools;

// Tool imports

import main.java.tools.TargetStack;
import main.java.tools.Card;

import static main.java.tools.Card.Suit.*;

// JUnit imports

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class TargetStackTest {

    TargetStack[] stacks = new TargetStack[4];

    @Before
    public void setup() {
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new TargetStack(Card.Suit.values()[i]); // Create a TargetStack of each suit
        }
    }

    // Test the return values when playing the wrong suit and make sure the stack progresses if the correct
    // Card is played.
    @Test
    public void playTest1() {
        Card card = new Card(1, SPADE);

        for (TargetStack stack : stacks) {
            Card result = stack.play(card);

            if (stack.getSuit() == SPADE) {
                assertNull(result);
                assertEquals(2, stack.getProgression());
            } else {
                assertEquals(card, result);
            }
        }
    }

    // Tests playing a card lower than a stack's progression
    // This throws an exception because this should never be possible
    @Test
    public void playTest2() {
        for (TargetStack stack : stacks) {
            stack.play(new Card(stack.getProgression(), stack.getSuit())); // Progress each stack to needing a 2.
        }

        for (TargetStack stack : stacks) {

            try {
                stack.play(new Card(1, stack.getSuit()));
                fail("Stack should throw IllegalArgumentException when card number is lower than progression.");
            } catch (Exception e) {
                assertEquals(IllegalArgumentException.class, e.getClass());
            }

        }
    }

    // Tests playing a card that is higher than the stacks progression
    @Test
    public void playTest3() {

        Card card = new Card(2, SPADE);

        for (TargetStack stack : stacks) {
            Card result = stack.play(card);

            assertEquals(card, result);
        }
    }

    @Test
    public void nullSuitTest() {
        try {
            TargetStack stack = new TargetStack(null);
            fail("Providing a null suit should throw IllegalArgumentException.");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

}
