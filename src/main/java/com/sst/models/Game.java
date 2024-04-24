package com.sst.models;

import com.sst.exceptions.invalidMoveException;
import com.sst.strategy.winningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moveList;
    private GameState gameState;
    private winningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players){
        this.board = new Board(dimension);
        this.playerList = players;
        this.nextPlayerMoveIndex = 0;
        this.winner = null;
        this.moveList = new ArrayList<>();
        this.gameState = GameState.InProgress;
        this.winningAlgorithm = new winningAlgorithm();
    }

    public void printBoard(){
        this.board.printBoard();
    }

    public boolean validateMove(Move move){
        if(move == null){
            return true;
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || col < 0 || row >= getBoard().getSize() || col >= getBoard().getSize()){
            return true;
        }

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED);
    }

    public void makeMove() throws invalidMoveException {
        Player currentPlayer = playerList.get(nextPlayerMoveIndex);

        System.out.println(currentPlayer.getName() + " turn");

        Move move = currentPlayer.makeMove(board);

        if(validateMove(move)){
            throw new invalidMoveException("Invalid Move");
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currentPlayer);

        Move finalMove = new Move(cellToChange,currentPlayer);
        moveList.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex+1) % playerList.size();

        if(winningAlgorithm.checkWInner(board, finalMove)){
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }
        else if(moveList.size() == board.getSize() * board.getSize()){
            gameState = GameState.DRAW;
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
