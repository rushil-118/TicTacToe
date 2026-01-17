package com.sst.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @Test
    void testValidMove() {
        GameEngine game = new GameEngine(3);
        assertTrue(game.makeMove(0, 0));
        assertEquals('X', game.getBoard()[0][0]);
    }

    @Test
    void testInvalidMove() {
        GameEngine game = new GameEngine(3);
        assertTrue(game.makeMove(0, 0));
        assertFalse(game.makeMove(0, 0)); // cell already taken
    }

    @Test
    void testWinCondition() {
        GameEngine game = new GameEngine(3);
        game.makeMove(0, 0); // X
        game.makeMove(1, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(1, 1); // O
        game.makeMove(0, 2); // X wins
        assertEquals(GameEngine.State.WIN, game.getState());
        assertEquals('X', game.getWinner());
    }

    @Test
    void testDrawCondition() {
        GameEngine game = new GameEngine(3);
        game.makeMove(0, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(0, 2); // X
        game.makeMove(1, 1); // O
        game.makeMove(1, 0); // X
        game.makeMove(1, 2); // O
        game.makeMove(2, 1); // X
        game.makeMove(2, 0); // O
        game.makeMove(2, 2); // X
        assertEquals(GameEngine.State.DRAW, game.getState());
        assertEquals(' ', game.getWinner());
    }
}
