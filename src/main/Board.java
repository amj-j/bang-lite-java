package main;

import java.util.ArrayList;
import utils.KeyboardInput;
import utils.Constants;
import cards.Card;
import cards.blue.*;
import cards.brown.*;

public class Board {
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Player> lostPlayers = new ArrayList<>();

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
        Card card;
        for (Player player : players) {
            for (int i = 0; i < Constants.START_CARDS; i++) {
                card = (Card)deck.takeFromTop();
                player.addCard(card);
            }
        }
    }
}
