package cards.blue;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

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
        Player chosenPlayer = super.getPlayer(owner, "Who do you send to prison?");
        while (chosenPlayer.getCardOnTable(Prison.class) != null) {
            chosenPlayer = super.getPlayer(owner, "This player is already in prison. Choose another one!");
        }
        chosenPlayer.addCardToTable(this);
    }

    @Override
    public void takeEffect(Player owner) {
        
    }
}
