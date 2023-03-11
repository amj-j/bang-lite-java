package cards.blue;

import main.*;

public class Barrel extends BlueCard {
    
    public Barrel(Board board) {
        super(board);
    }

    @Override
    public boolean canPlay(Player owner) {
        if (owner.getCardOnTable(Barrel.class) == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void play(Player owner) {

    }

    @Override
    public void takeEffect(Player owner) {
        
    }
}
