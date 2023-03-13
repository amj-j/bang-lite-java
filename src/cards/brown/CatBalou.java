package cards.brown;

import java.util.ArrayList;
import java.util.Random;

import cards.Card;
import main.*;
import utils.KeyboardInput;

public class CatBalou extends BrownCard {
    private static Random rand = new Random();
    
    public CatBalou(Board board) {
        super(board);
    }

    @Override
    public boolean canPlay(Player owner) {
        ArrayList<Player> players = super.board.getPlayers();
        Player player;
        for (int i = 0; i < players.size(); i++) {
            player = players.get(i);
            if (player == owner) {
                continue;
            }
            if (player.getHandCardsNum() != 0 || player.getTableCardsNum() != 0)  {
                return true;
            }
        }
        return false;
    }

    @Override
    public void play(Player owner) {
        System.out.println("You have chosen Cat Balou.");
        Player chosenPlayer = getPlayer(owner, "Who do you play this card on?");
        while (chosenPlayer.getHandCardsNum() == 0 && chosenPlayer.getTableCardsNum() == 0) {
            chosenPlayer = getPlayer(owner, "Choose different player. This one has no cards!");
        }

        int handNum = chosenPlayer.getHandCardsNum();
        int tableNum = chosenPlayer.getTableCardsNum();
        Card card;

        if (handNum == 0) {
            System.out.println(" loses card from his hand!");
            card = chosenPlayer.takeCardFromTable(rand.nextInt(tableNum));
        }
        else if (tableNum == 0) {
            System.out.println(" loses card from the table!");
            card = chosenPlayer.takeCardFromHand(rand.nextInt(handNum));
        }
        else {
            char input = KeyboardInput.readChar("Where do you want to take the card from? (h - hand/t - table)");
            while (input != 'h' || input != 't') {
                input = KeyboardInput.readChar("Type h for hand or t for table.");
            }
            if (input == 'h') {
                card = chosenPlayer.takeCardFromHand(rand.nextInt(handNum));
            }
            else {
                card = chosenPlayer.takeCardFromTable(rand.nextInt(tableNum));
            }
        }
        super.board.getDeck().addToBottom(card);
    }

    @Override
    public void printCard() {
        System.out.print("Cat balou");
    }
}
