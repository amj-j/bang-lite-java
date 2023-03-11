package cards.brown;

import cards.Card;
import main.*;

public class Bang extends BrownCard {
    
    public Bang(Board board) {
        super(board);
    }

    @Override
    public void play(Player owner) {
        Player shotPlayer = getPlayer(owner, "Who do you shoot on?");
        Card missedCard = shotPlayer.getCardOnHand(Missed.class);
        if (missedCard == null) {
            shotPlayer.takeLife();
            System.out.println(shotPlayer.getName() + " loses a life!");
        }
        else {
            missedCard.play(shotPlayer);
            shotPlayer.takeCardFromHand(missedCard);
            super.board.deck.addToBottom(missedCard);
        }
    }
}
