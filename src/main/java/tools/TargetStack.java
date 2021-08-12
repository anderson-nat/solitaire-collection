package main.java.tools;

import java.util.Stack;

/**
 * A Stack of a specific suit of cards. Used in modes such as Klondike where the goal is to fill all 4 target stacks.
 * Cards from the correct suit must be played in increasing order based on their number.
 */
public class TargetStack {

    private final Card.Suit suit;
    private int progression = 0;
    private final Stack<Card> stack = new Stack<>();
    // TODO: Insert background image when empty, and top card when not

    /**
     * Default Constructor. Sets the suit for the stack.
     * @param suit : The suit that this stack will hold.
     */
    public TargetStack(Card.Suit suit) {
        this.suit = suit;
    }

    /**
     * If the card played onto the stack is the correct one, it will progress this stack and return null,
     * removing the Card from where it was played.
     * If the card is incorrect it will be returned, being placed back where it came from.
     * @param card : The card to attempt to play onto the stack.
     * @return the given card if invalid, null if valid
     */
    public Card play(Card card) {
        if (card.getSuit() != suit) {
            return card;
        }

        if (card.getNumber() == progression + 1) {
            progression++;
            stack.push(card);
            return null;
        } else {
            return card;
        }
    }
}
