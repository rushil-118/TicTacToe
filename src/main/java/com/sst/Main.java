package com.sst;

import com.sst.controllers.GameController;
import com.sst.exceptions.invalidMoveException;
import com.sst.exceptions.sameSymbolException;
import com.sst.models.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws sameSymbolException, invalidMoveException {
        GameController gameController = new GameController();
        int dimension = 3;
        List<Player> players = List.of(
                new Player("Demo", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Bot", new Symbol('O'), PlayerType.BOT, BotDifficultyLevel.EASY)
        );
        Game game = gameController.startGame(dimension,players);
//        gameController.printBoard(game);

        while ((game.getGameState().equals(GameState.InProgress))){
            gameController.printBoard(game);
            gameController.makeMove(game);
        }
        gameController.printBoard(game);
        if(gameController.checkState(game).equals(GameState.ENDED)){
            System.out.println("The winner is " + gameController.getWinner(game).getName());
        }else{
            System.out.println("It is a Draw");
        }

    }
}