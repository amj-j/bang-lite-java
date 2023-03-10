package cards.brown;

import main.*;

public class Beer extends BrownCard {
    
    public Beer(Board board) {
        super(board);
    }

    @Override
    public void play(Player owner) {
        owner.addLife();
        System.out.println("You added yourself one life!");
    }
}