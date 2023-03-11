package main;

import java.util.ArrayList;
import cards.Card;
import cards.blue.BlueCard;
import utils.Constants;

public class Player {
    Board board;
    String name;
    int lives = Constants.START_LIVES;
    ArrayList <Card> hand = new ArrayList<>();
    ArrayList <BlueCard> table = new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLives() {
        return this.lives;
    }

    public void takeLife() {
        this.lives--;
    }

    public void addLife() {
        this.lives++;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addCardToTable(BlueCard card) {
        table.add(card);
    }

    public void takeCardFromHand(Card card) {
        hand.remove(card);
    }

    public Card takeCardFromHand(int index) {
        return hand.remove(index);
    }

    public void takeCardFromTable(BlueCard card) {
        table.remove(card);
    }

    public Card takeCardFromTable(int index) {
        return table.remove(index);
    }

    public <T extends Card> Card getCardOnHand(Class<T> card) {
        for (int i = 0; i < hand.size(); i++) {
            if (card.isInstance(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    public <T extends Card> Card getCardOnTable(Class<T> card) {
        for (int i = 0; i < table.size(); i++) {
            if (card.isInstance(table.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    public int getHandCardsNum() {
        return hand.size();
    }

    public int getTableCardsNum() {
        return table.size();
    }
}
