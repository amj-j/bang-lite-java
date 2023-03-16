package cards.blue;

import main.*;
import utils.Constants;

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
            System.out.println("There already is a barrel in front of you!");
            return false;
        }
    }

    @Override
    public void play(Player owner) {
        owner.addCardToTable(this);
    }

    public boolean tryHide() {
        return Math.random() < Constants.BARREL_HIDE_CHANCE;
    }

    @Override
    public void printCard() {
        System.out.print("Barrel");
    }
}
