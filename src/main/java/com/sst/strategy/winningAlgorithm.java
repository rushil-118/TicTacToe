package com.sst.strategy;

import com.sst.models.Board;
import com.sst.models.Move;
import com.sst.models.Player;

import java.util.HashMap;

public class winningAlgorithm {
    HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();

    HashMap<Character, Integer> leftDiagonal = new HashMap<>();
    HashMap<Character,Integer> rightDiagonal = new HashMap<>();

    public int insertSymbol(HashMap<Integer, HashMap<Character, Integer>> map, int key, Player player){
        if(!map.containsKey(key)){
            map.put(key, new HashMap<>());
        }
        HashMap<Character, Integer> currMap = map.get(key);
        Character symbol = player.getSymbol().getSymbolChar();
        currMap.put(symbol,currMap.getOrDefault(symbol,0)+1);
        return currMap.get(symbol);
    }

    public int insertDiagonalMap(HashMap<Character, Integer> map, Player player){
        Character symbol = player.getSymbol().getSymbolChar();
        map.put(symbol,map.getOrDefault(symbol,0)+1);
        return map.get(symbol);
    }

    public boolean checkWInner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        int rowCount = insertSymbol(rowMaps, row, move.getPlayer());
        int colCount = insertSymbol(colMaps, col, move.getPlayer());

        if(rowCount==board.getSize() || colCount==board.getSize()) return true;

        if(row == col){
            int leftDiagonalCount = insertDiagonalMap(leftDiagonal, move.getPlayer());
            if(leftDiagonalCount == board.getSize()) return true;
        }

        if(row + col == board.getSize()-1){
            int rightDiagonalCount = insertDiagonalMap(rightDiagonal,move.getPlayer());
            return rightDiagonalCount == board.getSize();
        }

        return false;
    }

}
