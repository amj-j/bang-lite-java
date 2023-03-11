package cards.blue;

import java.util.ArrayList;

import main.*;

public class Prison extends BlueCard {
    
    public Prison(Board board) {
        super(board);
    }

    @Override
    public boolean canPlay(Player owner) {
        ArrayList<Player> players = super.board.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            if (owner.getCardOnTable(Barrel.class) == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void play(Player owner) {
        
    }

    @Override
    public void takeEffect(Player owner) {
        
    }
}
