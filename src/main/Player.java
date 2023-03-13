package main;

import java.util.ArrayList;
import cards.Card;
import cards.blue.BlueCard;
import cards.blue.Dynamite;
import cards.blue.Prison;
import utils.Constants;
import utils.KeyboardInput;

public class Player {
    Board board;
    String name;
    int lives = Constants.START_LIVES;
    ArrayList <Card> hand = new ArrayList<>();
    ArrayList <BlueCard> table = new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getLives() {
        return this.lives;
    }

    public void takeLife() {
        this.lives--;
    }

    public void addLife() {
        this.lives++;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addCardToTable(BlueCard card) {
        table.add(card);
    }

    public void takeCardFromHand(Card card) {
        hand.remove(card);
    }

    public Card takeCardFromHand(int index) {
        return hand.remove(index);
    }

    public void takeCardFromTable(BlueCard card) {
        table.remove(card);
    }

    public Card takeCardFromTable(int index) {
        return table.remove(index);
    }

    public <T extends Card> Card getCardOnHand(Class<T> card) {
        for (int i = 0; i < hand.size(); i++) {
            if (card.isInstance(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    public <T extends Card> BlueCard getCardOnTable(Class<T> card) {
        for (int i = 0; i < table.size(); i++) {
            if (card.isInstance(table.get(i))) {
                return table.get(i);
            }
        }
        return null;
    }

    public int getHandCardsNum() {
        return hand.size();
    }

    public int getTableCardsNum() {
        return table.size();
    }

    public boolean hasLost() {
        return (this.lives <= 0);
    }

    public void removeCards() {
        while (!hand.isEmpty()) {
            board.getDeck().addToBottom(hand.remove(0));
        }
        while (!table.isEmpty()) {
            board.getDeck().addToBottom(table.remove(0));
        }
    }

    public void playTurn() {
        System.out.println("\n---------------------------------------------------------------------\n");
        BlueCard blueCard = getCardOnTable(Dynamite.class);
        if (blueCard != null) {
            blueCard.takeEffect(this);
            if (hasLost()) {
                board.playerLost(this);
                return;
            }
        }
        blueCard = getCardOnTable(Prison.class);
        if (blueCard != null) {
            boolean cont = blueCard.takeEffect(this);
            if (!cont) {
                return;
            } 
        }
        
        KeyboardInput.readString("Press enter to draw " + Constants.DRAW_CARDS_ON_TURN + " cards.");
        for (int i = 0; i < Constants.DRAW_CARDS_ON_TURN; i++) {
            board.dealCard(this);
        }

        while (hand.size() > 0) {
            board.printStatus();
            printHand();
            if (KeyboardInput.readYesNo("Do you wish to play a card?")) {
                int cardIndex = KeyboardInput.readIntInRange(1, hand.size() + 1, "Choose a card:", "Enter valid card number!") - 1;
                hand.get(cardIndex).play(this);
                for (int i = 0; i < board.getPlayers().size(); i++) {
                    Player player = board.getPlayers().get(i);
                    if (player.hasLost()) {
                        System.out.println(player.getName() + " has lost!");
                        board.playerLost(player);
                        --i;
                    }
                }
            } 
            else {
                break;
            }
        }
        
        int throwAway = hand.size() - lives;
        while (throwAway > 0) {
            System.out.println("You have to throw away " + throwAway + " cards!");
            printHand();
            int cardIndex = KeyboardInput.readIntInRange(1, hand.size() + 1, "Choose a card:", "Enter valid card number!") - 1;
            board.getDeck().addToBottom(takeCardFromHand(cardIndex));
            throwAway--;
        }

        KeyboardInput.readString("Press enter to end your turn.");
    }

    public void printHand() {
        System.out.println("Your cards:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.print((i+1) + ". ");
            hand.get(i).printCard();
            System.out.println();
        }
    }

    public void printTable() {
        for (int i = 0; i < table.size(); i++) {
            table.get(i).printCard();
            if (i+1 == table.size()) {
                System.out.println(", ");
            }
        }
        if (table.size() > 0) {
            System.out.println();
        }
    }
}
