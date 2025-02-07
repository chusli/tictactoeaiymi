package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TicTacToeTest {

    private final ArrayList<Integer> moves = new ArrayList<>();

    private static Stream<Arguments> provideWinningScenarios() {
        return Stream.of(
                arguments(List.of(0, 3, 1, 4, 2), 'X'), // X wins horizontally
                arguments(List.of(0, 3, 1, 4, 8, 5), 'O'), // O wins horizontally
                arguments(List.of(0, 1, 3, 2, 6), 'X'), // X wins vertically
                arguments(List.of(2, 0, 1, 4, 6, 8), 'O'), // O wins diagonally
                arguments(List.of(1, 6, 0, 2, 8, 4), 'O') // 0 wins diagonally
        );
    }

    @Test
    public void makeFirstMove() {
        move(5);
        move(7);

        char actual = getState(5);
        assertThat(actual).isEqualTo('X');

        char actual2 = getState(7);
        assertThat(actual2).isEqualTo('O');
    }

    @ParameterizedTest
    @MethodSource("provideWinningScenarios")
    void winnigScenarios(List<Integer> moves, char expectedWinner) {
        moves.forEach(this::move);

        var actual = getWinner();

        assertThat(actual).isEqualTo(expectedWinner);
    }

    @Test
    void getNoWinner() {
        var actual = getWinner();

        assertThat(actual).isEqualTo(' ');
    }

    private char getWinner() {
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

    private char getState(int field) {
        return moves.indexOf(field) % 2 == 0 ? 'X' : 'O';
    }

    private void move(int field) {
        moves.add(field);
    }

}