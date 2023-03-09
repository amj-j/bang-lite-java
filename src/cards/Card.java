package cards;

import main.*;

public abstract class Card {
    protected Board board;

    public Card(Board board) {
        this.board = board;
    }

    public void play(Player owner) {}
}
