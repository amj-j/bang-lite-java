package cards;

import java.util.HashMap;

import main.*;
import utils.KeyboardInput;

public abstract class Card {
    protected Board board;

    public Card(Board board) {
        this.board = board;
    }

    public boolean canPlay(Player owner) {
        return true;
    }

    public void play(Player owner) {}

    protected Player getPlayer(Player currPlayer, String textToDisplay) {
        HashMap<Integer, Player> opponents = board.printOpponents(currPlayer);
        int index = KeyboardInput.readIntInRange(1, opponents.size()+1, textToDisplay, "Enter a valid number!");        
        return opponents.get(index);
    }

    public void printCard() {}
}
