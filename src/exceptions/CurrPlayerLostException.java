package exceptions;

import main.Board;
import main.Player;
import utils.KeyboardInput;

public class CurrPlayerLostException extends Exception {
    private Player nextPlayer;

    public CurrPlayerLostException(Board board, Player lostPlayer) {
        int index = board.getPlayers().indexOf(lostPlayer);
        board.playerLost(lostPlayer);
        if (index >= board.getPlayers().size()) {
            index = 0;
        }
        this.nextPlayer = board.getPlayers().get(index);
        System.out.println("You have lost!");
        KeyboardInput.readString("Press enter to continue.");
    }

    public Player getNextPlayer() {
        return this.nextPlayer;
    }
}
