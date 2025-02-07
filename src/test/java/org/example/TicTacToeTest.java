package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TicTacToeTest {

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
    public void makeTwoMoves() {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.move(5);
        tictactoe.move(7);

        char actual = tictactoe.getState(5);
        assertThat(actual).isEqualTo('X');

        char actual2 = tictactoe.getState(7);
        assertThat(actual2).isEqualTo('O');
    }

    @ParameterizedTest
    @MethodSource("provideWinningScenarios")
    void winnigScenarios(List<Integer> moves, char expectedWinner) {
        TicTacToe tictactoe = new TicTacToe();
        moves.forEach(tictactoe::move);

        var actual = tictactoe.getWinner();

        assertThat(actual).isEqualTo(expectedWinner);
    }

    @Test
    void getNoWinner() {
        TicTacToe tictactoe = new TicTacToe();
        var actual = tictactoe.getWinner();

        assertThat(actual).isEqualTo(' ');
    }

}