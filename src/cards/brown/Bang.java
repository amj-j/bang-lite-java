package cards.brown;

import cards.Card;
import main.*;

public class Bang extends BrownCard {
    
    public Bang(Board board) {
        super(board);
    }

    @Override
    public void play(Player owner) {
        Player chosenPlayer = getPlayer(owner, "Who do you shoot on?");
        Card missedCard = chosenPlayer.getCardOnHand(Missed.class);
        if (missedCard == null) {
            chosenPlayer.takeLife();
            System.out.println(chosenPlayer.getName() + " loses a life!");
        }
        else {
            missedCard.play(chosenPlayer);
            chosenPlayer.takeCardFromHand(missedCard);
            super.board.getDeck().addToBottom(missedCard);
        }
    }
}
