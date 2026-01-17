package com.sst;

import com.sst.engine.GameEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 3;
        System.out.println("Welcome to TicTacToe!");
        GameEngine game = new GameEngine(size);

        while (game.getState() == GameEngine.State.IN_PROGRESS) {
            printBoard(game.getBoard());
            System.out.println("Player " + game.getCurrentPlayer() + ", enter row and col (0-based):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (!game.makeMove(row, col)) {
                System.out.println("Cell already taken, try again.");
            }
        }
        printBoard(game.getBoard());
        if (game.getState() == GameEngine.State.WIN) {
            System.out.println("Player " + game.getWinner() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        scanner.close();
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print((c == ' ' ? '.' : c) + " ");
            }
            System.out.println();
        }
    }
}