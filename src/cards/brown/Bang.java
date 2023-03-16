package cards.brown;

import cards.Card;
import cards.blue.Barrel;
import main.*;

public class Bang extends BrownCard {
    
    public Bang(Board board) {
        super(board);
    }

    @Override
    public void play(Player owner) {
        System.out.println("You have chosen Bang");
        Player chosenPlayer = getPlayer(owner, "Who do you shoot on? ");
        Barrel barrel = (Barrel) chosenPlayer.getCardOnTable(Barrel.class);
        if (barrel != null) {
            if (barrel.tryHide()) {
                System.out.println(chosenPlayer.getName() + " managed to hide in a barrel!");
                return;
            }
            else {
                System.out.println(chosenPlayer.getName() + "unsuccessfully tried to hide in a barel!");
            }
        }
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

    @Override
    public void printCard() {
        System.out.print("Bang");
    }
}
