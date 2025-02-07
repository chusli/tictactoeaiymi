package org.example;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    private final ArrayList<Integer> moves = new ArrayList<>();

    public TicTacToe() {
    }

    public char getWinner() {
        List<List<Integer>> winningMask = List.of(
                List.of(0, 1, 2), List.of(3, 4, 5), List.of(6, 7, 8), // horizontal
                List.of(0, 3, 6), List.of(1, 4, 7), List.of(2, 5, 8), // vertical
                List.of(0, 4, 8), List.of(2, 4, 6)); // diagonal
        ArrayList<Integer> movesByX = new ArrayList<>();
        ArrayList<Integer> movesByO = new ArrayList<>();

        for (int i = 0; i < moves.size(); i++) {
            if (i % 2 == 0) {
                movesByX.add(moves.get(i));
            } else {
                movesByO.add(moves.get(i));
            }

        }
        if (winningMask.stream().anyMatch(movesByX::containsAll)) {
            return 'X';
        }
        if (winningMask.stream().anyMatch(movesByO::containsAll)) {
            return 'O';
        }
        return ' ';
    }

    public char getState(int field) {
        return moves.indexOf(field) % 2 == 0 ? 'X' : 'O';
    }

    public void move(int field) {
        moves.add(field);
    }

}