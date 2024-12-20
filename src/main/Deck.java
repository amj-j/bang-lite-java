package main;
import java.util.ArrayList;
import java.util.Random;

import cards.Card;

public class Deck {
    private final ArrayList<Card> deck = new ArrayList<Card>();
    private final Random rand = new Random();

    public Card takeFromTop() {
        return deck.remove(0);
    }

    public void addToBottom(Card newLast) {
        deck.add(newLast);
    }

    public void shuffle() {
        Card tmp;
        for (int i = 0; i < deck.size(); i++) {
            tmp = deck.get(i);
            deck.remove(i);
            deck.add(rand.nextInt(deck.size()), tmp);
        }
    }

    public void addTypeOfCards(Card card, int until) {
        for (int i = 0; i < until; i++) {
            deck.add(card);
        }
    }
}