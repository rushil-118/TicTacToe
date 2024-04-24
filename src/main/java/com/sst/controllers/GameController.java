package com.sst.controllers;

import com.sst.exceptions.invalidMoveException;
import com.sst.exceptions.sameSymbolException;
import com.sst.models.Game;
import com.sst.models.GameState;
import com.sst.models.Player;

import java.util.List;
import java.util.*;

public class GameController {
    public Game startGame(int dimension, List<Player> players) throws sameSymbolException {
        // Checking if any symbol is repeated
        Set<Character> symbolSet = new HashSet<>();
        for(Player player : players){
            symbolSet.add(player.getSymbol().getSymbolChar());
        }
        if(symbolSet.size() != players.size()){
            throw new sameSymbolException("Two or more players have same symbol");
        }

        return new Game(dimension,players);
    }

    public void makeMove(Game game) throws invalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){
        game.printBoard();
    }


}
