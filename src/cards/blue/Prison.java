package cards.blue;

import java.util.ArrayList;

import main.*;
import utils.Constants;
import utils.KeyboardInput;

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
        System.out.println("All players are already in prison!");
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

    public boolean escaped() {
        if (Math.random() < Constants.PRISONBREAK_CHANCE) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean takeEffect(Player owner) {
        System.out.println("You are in prison!");
        KeyboardInput.readString("Press enter to try to escape.");
        owner.takeCardFromTable(this);
        board.getDeck().addToBottom(this);
        if (!this.escaped()) {
            System.out.println("You didn't manage to escape from the prison!");
            return false;
        }
        else {
            System.out.println("You managed to escape from the prison!");
            return true;
        }
    }

    @Override
    public void printCard() {
        System.out.print("Prison");
    }
}
