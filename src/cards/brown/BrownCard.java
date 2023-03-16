package cards.brown;

import cards.Card;
import main.Board;
import main.Player;

public abstract class BrownCard extends Card {
    public BrownCard(Board board) {
        super(board);
    }

    @Override
    public void discard(Player owner) {
        super.discard(owner);
        super.board.getDeck().addToBottom(this);
    }
}
