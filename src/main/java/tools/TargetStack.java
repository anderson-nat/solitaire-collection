package main.java.tools;

import java.util.Stack;

/**
 * A Stack of a specific suit of cards. Used in modes such as Klondike where the goal is to fill all 4 target stacks.
 * Cards from the correct suit must be played in increasing order based on their number.
 *
 * @author Nat Anderson
 * Date Last Modified: 2021-08-23
 */
public class TargetStack {

    private final Card.Suit suit;
    private int progression = 1;
    private final Stack<Card> stack = new Stack<>();
    // TODO: Insert background image when empty, and top card when not

    /**
     * Default Constructor. Sets the suit for the stack.
     * @param suit : The suit that this stack will hold.
     */
    public TargetStack(Card.Suit suit) throws IllegalArgumentException {
        if (suit == null) throw new IllegalArgumentException("Suit must be non-null.");

        this.suit = suit;
    }

    /**
     * If the card played onto the stack is the correct one, it will progress this stack and return null,
     * removing the Card from where it was played.
     * If the card is incorrect it will be returned, being placed back where it came from.
     * If the card is lower than the progression, it throws an exception because this should never happen
     * in regular gameplay.
     * @param card : The card to attempt to play onto the stack.
     * @return the given card if invalid, null if valid
     * @throws IllegalArgumentException if the number of the card is lower than the stack's progression value
     */
    public Card play(Card card) throws IllegalArgumentException {

        if (card.getSuit() != suit) {
            return card;
        }

        if (card.getNumber() < progression) {
            throw new IllegalArgumentException("Card number must not be lower than progression if suits are equal.");
        }

        if (card.getNumber() == progression) {
            progression++;
            stack.push(card);
            return null;
        } else {
            return card;
        }
    }

    // Getter methods
    public Card.Suit getSuit() {
        return suit;
    }

    public int getProgression() {
        return progression;
    }

    public Stack<Card> getStack() {
        return stack;
    }
}
