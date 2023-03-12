package cards.blue;

import main.*;

public class Dynamite extends BlueCard {
    
    public Dynamite(Board board) {
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
        owner.addCardToTable(this);
    }

    @Override
    public void takeEffect(Player owner) {
        
    }
}
