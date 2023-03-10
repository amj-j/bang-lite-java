package cards;

import java.util.HashMap;

import main.*;
import utils.KeyboardInput;

public abstract class Card {
    protected Board board;

    public Card(Board board) {
        this.board = board;
    }

    public void play(Player owner) {}

    protected Player getPlayer(Player currPlayer, String textToDisplay) {
        HashMap<Integer, Player> opponents = board.printOpponents(currPlayer);
        int index = KeyboardInput.readIntInRange(1, opponents.size()+1, textToDisplay, "Player with this number doesn't exist!");        
        return opponents.get(index);
    }
}
