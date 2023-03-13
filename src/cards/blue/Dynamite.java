package cards.blue;

import main.*;
import utils.Constants;
import utils.KeyboardInput;

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

    public boolean hasBlown() {
        if (Math.random() < Constants.DYNAMITE_BLOW_CHANCE) {
            return true;
        }
        else {
            return false;
        }
    }

    public void move(Player previousOwner) {
        previousOwner.takeCardFromTable(this);
        int playerIndex = board.getPlayers().indexOf(previousOwner);
        if (playerIndex > 0) {
            super.board.getPlayers().get(playerIndex-1).addCardToTable(this);
        }
        else {
            super.board.getPlayers().get(super.board.getPlayers().size() - 1).addCardToTable(this);
        }
    }

    @Override
    public boolean takeEffect(Player owner) {
        System.out.println("You are endangered by a dynamite!");
        KeyboardInput.readString("Press enter to see wheter it goes off.");
        if (this.hasBlown()) {
            System.out.println("BOOOM!!! You lose " + Constants.DYNAMITE_DAMAGE + " lives!");
            for (int i = 0; i < Constants.DYNAMITE_DAMAGE; i++) {
                owner.takeLife();
            }
            board.getDeck().addToBottom(this);
            owner.takeCardFromTable(this);
        }
        else {
            System.out.println("The dynamite did not do of!");
            this.move(owner);
        }
        return true;
    }

    @Override
    public void printCard() {
        System.out.print("Dynamite");
    }
}
