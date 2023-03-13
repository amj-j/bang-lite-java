package main;

import java.util.ArrayList;

import exceptions.CurrPlayerLostException;
import utils.Constants;
import utils.KeyboardInput;

public class Game {
    Board board;

    public Game() {
        int playersNum = KeyboardInput.readIntInRange(
            Constants.MIN_PLAYERS, 
            Constants.MAX_PLAYERS+1,
            "How many players will there be?", 
            "Enter valid number of players"
        );
        this.board = new Board(playersNum);
        mainCycle();
    }

    private void mainCycle() {
        ArrayList<Player> players = board.getPlayers();
        int i = 0;
        while (players.size() > 1) {
            try {
                Player currPlayer = players.get(i);
                currPlayer.playTurn();
                i = players.indexOf(currPlayer);
                ++i;
                if (i >= players.size()) {
                    i = 0;
                }
            } catch (CurrPlayerLostException e) {
                i = players.indexOf(e.getNextPlayer());
            }
        }
        board.getLostPlayers().add(board.getPlayers().get(0));
        printLostPlayers();
    }
    
    private void printLostPlayers() {
        int place = 1;
        for (int i = board.getLostPlayers().size() -1; i >= 0; i--) {
            System.out.println(place + ". " + board.getLostPlayers().get(i).getName());
            place++;
        }
    }
}
