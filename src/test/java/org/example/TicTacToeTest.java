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

    @ParameterizedTest
    @MethodSource("provideWinningScenarios")
    void winnigScenarios(List<Integer> moves, char expectedWinner) {
        TicTacToe tictactoe = new TicTacToe();
        moves.forEach(tictactoe::move);

        char actual = tictactoe.getWinner();

        assertThat(actual).isEqualTo(expectedWinner);
    }

    @Test
    void getNoWinner() {
        TicTacToe tictactoe = new TicTacToe();
        char actual = tictactoe.getWinner();

        assertThat(actual).isEqualTo(' ');
    }

    @Test
    void ignoreInvalidMove() {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.move(0);
        tictactoe.move(0); // this move must be ignored
        tictactoe.move(3); // valid move of player 2

        tictactoe.move(1);
        tictactoe.move(4);
        tictactoe.move(2); // winning move

        char actual = tictactoe.getWinner();

        assertThat(actual).isEqualTo('X');
    }

}