package main;

import java.util.ArrayList;
import java.util.HashMap;

import utils.KeyboardInput;
import utils.Constants;
import cards.Card;
import cards.blue.*;
import cards.brown.*;

public class Board {
    private Deck deck = new Deck();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Player> lostPlayers = new ArrayList<>();

    public Board(int playersNum) {
        initPlayers(playersNum);
        initDeck();
        dealCards();
    }

    private void initPlayers(int playersNum) {
        String name;
        for (int i = 0; i < playersNum; i++) {
            name = KeyboardInput.readString("Enter the name of player " + (i+1));
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
}
