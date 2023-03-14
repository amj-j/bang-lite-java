package cards.brown;

import java.util.ArrayList;

import cards.Card;
import main.*;

public class Indians extends BrownCard {
    
    public Indians(Board board) {
        super(board);
    }

    @Override
    public void play(Player owner) {
        System.out.println("You chose Indians.");
        ArrayList<Player> players =  super.board.getPlayers();
        Player player;
        for (int i = 0; i < players.size(); i++) {
            player = players.get(i);
            if (player == owner) {
                continue;
            }
            Card bangCard = player.getCardOnHand(Bang.class);
            if (bangCard == null) {
                player.takeLife();
                System.out.println(player.getName() + " loses a life!");
            }
            else {    
                player.takeCardFromHand(bangCard);
                System.out.println(player.getName() + " plays Bang!");
                super.board.getDeck().addToBottom(bangCard);
            }
        }
    }

    @Override
    public void printCard() {
        System.out.print("Indians");
    }
}
