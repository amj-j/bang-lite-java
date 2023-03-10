package cards.brown;

import main.*;

public class Bang extends BrownCard {
    
    public Bang(Board board) {
        super(board);
    }

    @Override
    public void play(Player owner) {
        Player shot = getPlayer(owner, "Who do you shoot on?");
        
    }
}
