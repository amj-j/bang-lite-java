package cards.brown;

import main.*;

public class Missed extends BrownCard {
    
    public Missed(Board board) {
        super(board);
    }

    @Override
    public boolean canPlay(Player owner) {
        System.out.println("Missed can only be played when you are being shot at!");
        return false;
    }

    @Override
    public void play(Player owner) {
        System.out.println(owner.getName() + " plays missed!");
    }

    @Override
    public void printCard() {
        System.out.print("Missed");
    }
}
