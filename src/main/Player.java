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

    public void takeCardFromTable(BlueCard card) {
        table.remove(card);
    }
}
