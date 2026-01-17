package com.sst.engine;

public class GameEngine {
    public enum State { IN_PROGRESS, WIN, DRAW }
    private final char[][] board;
    private final int size;
    private char currentPlayer;
    private State state;
    private char winner;
    private int moves;

    public GameEngine(int size) {
        if (size < 3) throw new IllegalArgumentException("Board size must be >= 3");
        this.size = size;
        this.board = new char[size][size];
        this.currentPlayer = 'X';
        this.state = State.IN_PROGRESS;
        this.winner = ' ';
        this.moves = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public State getState() {
        return state;
    }

    public char getWinner() {
        return winner;
    }

    public char[][] getBoard() {
        char[][] copy = new char[size][size];
        for (int i = 0; i < size; i++)
            System.arraycopy(board[i], 0, copy[i], 0, size);
        return copy;
    }

    public boolean makeMove(int row, int col) {
        if (state != State.IN_PROGRESS)
            throw new IllegalStateException("Game is over");
        if (row < 0 || row >= size || col < 0 || col >= size)
            throw new IllegalArgumentException("Invalid cell");
        if (board[row][col] != ' ')
            return false;
        board[row][col] = currentPlayer;
        moves++;
        if (checkWinner(row, col)) {
            state = State.WIN;
            winner = currentPlayer;
        } else if (moves == size * size) {
            state = State.DRAW;
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        return true;
    }

    private boolean checkWinner(int row, int col) {
        char p = board[row][col];
        boolean winRow = true, winCol = true, winDiag = true, winAntiDiag = true;
        for (int i = 0; i < size; i++) {
            if (board[row][i] != p) winRow = false;
            if (board[i][col] != p) winCol = false;
            if (board[i][i] != p) winDiag = false;
            if (board[i][size - 1 - i] != p) winAntiDiag = false;
        }
        return winRow || winCol || winDiag || winAntiDiag;
    }
}
