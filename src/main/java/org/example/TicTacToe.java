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

    public void move(int field) {
        if (moves.contains(field)) {
            return;
        }
        moves.add(field);
    }

    public char[] getState() {
        char[] state = new char[9];
        for (int i = 0; i < state.length; i++) {
            if (moves.contains(i)) {
                state[i] = moves.indexOf(i) % 2 == 0 ? 'X' : 'O';
            } else {
                state[i] = ' ';
            }
        }
        return state;
    }

    public List<String> print() {
        char[] state = getState();
        return List.of(
                "%s|%s|%s".formatted(state[0], state[1], state[2]),
                "______",
                "%s|%s|%s".formatted(state[3], state[4], state[5]),
                "______",
                "%s|%s|%s".formatted(state[6], state[7], state[8])
        );

    }

}