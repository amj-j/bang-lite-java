package main;

import java.util.ArrayList;
import java.util.HashMap;

import utils.KeyboardInput;
import utils.Constants;
import cards.Card;
import cards.blue.*;
import cards.brown.*;
import exceptions.CurrPlayerLostException;

public class Board {
    private final Deck deck = new Deck();
    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<Player> lostPlayers = new ArrayList<>();

    public Board(int playersNum) {
        initPlayers(playersNum);
        initDeck();
        dealCards();
    }

    private void initPlayers(int playersNum) {
        String name;
        for (int i = 0; i < playersNum; i++) {
            name = KeyboardInput.readString("Enter the name of player " + (i+1) + ": ");
            players.add(new Player(name, this));
        }
    }

    private void initDeck() {
        deck.addTypeOfCards(new Bang(this), Constants.BANG);
        deck.addTypeOfCards(new Missed(this), Constants.MISSED);
        deck.addTypeOfCards(new Barrel(this), Constants.BARREL);
        deck.addTypeOfCards(new Beer(this), Constants.BEER);
        deck.addTypeOfCards(new Stagecoach(this), Constants.STAGECOACH);
        deck.addTypeOfCards(new Indians(this), Constants.INDIANS);
        deck.addTypeOfCards(new CatBalou(this), Constants.CAT_BALOU);
        deck.addTypeOfCards(new Prison(this), Constants.PRISON);
        deck.addTypeOfCards(new Dynamite(this), Constants.DYNAMITE);

        deck.shuffle();
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < Constants.START_CARDS; i++) {
                dealCard(player);
            }
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public ArrayList<Player> getLostPlayers() {
        return this.lostPlayers;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void dealCard(Player player) {
        Card card = (Card)deck.takeFromTop();
        player.addCardToHand(card);
    }

    public void processLostPlayers(Player currPlayer) throws CurrPlayerLostException {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.hasLost()) {
                if (player == currPlayer) {
                    continue;
                }
                else {
                    System.out.println(player.getName() + " has lost!");
                    playerLost(player);
                    --i;
                }
            }
        }
        if (currPlayer.hasLost()) {
            throw new CurrPlayerLostException(this, currPlayer);
        }
    }

    public void playerLost(Player lostPlayer) {
        lostPlayer.removeCards();
        players.remove(lostPlayer);
        lostPlayers.add(lostPlayer);
    }

    public HashMap<Integer, Player> printOpponents(Player currPlayer) {
        int index = players.indexOf(currPlayer);
        HashMap<Integer, Player> opponents = new HashMap<>();
        int j = 1;
        for (int i = index+1; i < players.size(); i++) {
            System.out.println(j + ". " + players.get(i).getName());
            opponents.put(j, players.get(i));
            j++;
        }
        for (int i = 0; i < index; i++) {
            System.out.println(j + ". " + players.get(i).getName());
            opponents.put(j, players.get(i));
            j++;
        }
        return opponents;
    }

    public void printStatus() {
        for (Player player : players) {
            System.out.println(player.getName() + ":");
            System.out.println(player.getLives() + " lives");
            player.printTable();
            System.out.println();
        }        
    }
}
