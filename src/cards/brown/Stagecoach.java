package cards.brown;

import main.*;

public class Stagecoach extends BrownCard {
    private static final int CARDS_NUM = 2;
    
    public Stagecoach(Board board) {
        super(board);
    }

    @Override
    public void play(Player owner) {
        for (int i = 0; i < CARDS_NUM; i++) {
            super.board.dealCard(owner);
        }
        System.out.println("You have chosen Stagecoach and draw " + CARDS_NUM + " cards.");
    }
}
