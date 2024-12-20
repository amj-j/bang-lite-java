package cards.blue;

import cards.Card;
import main.Board;
import main.Player;

public abstract class BlueCard extends Card {
    public BlueCard(Board board) {
        super(board);
    }

    public boolean takeEffect(Player owner) {
        return true;
    }
}
