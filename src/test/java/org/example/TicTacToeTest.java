package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeTest {

    @Test
    void playerMakeFirstMove() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        ticTacToeBoard.makeMove(new Move(0, 0, ticTacToeBoard.getCurrentPlayer()));

        Player actual = ticTacToeBoard.getMarker(0, 0);

        assertThat(actual).isEqualTo(Player.X);
    }

    @Test
    void getSecondPlayerAfterFirstMove() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        ticTacToeBoard.makeMove(new Move(0, 0, ticTacToeBoard.getCurrentPlayer()));

        Player actual = ticTacToeBoard.getCurrentPlayer();

        assertThat(actual).isEqualTo(Player.O);
    }

    @Test
    void makeSecondMove() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        ticTacToeBoard.makeMove(new Move(0, 0, ticTacToeBoard.getCurrentPlayer()));
        ticTacToeBoard.makeMove(new Move(1, 0, ticTacToeBoard.getCurrentPlayer()));

        Player actual = ticTacToeBoard.getMarker(1, 0);

        assertThat(actual).isEqualTo(Player.O);
    }

    private enum Player {
        X, O;

        public Player not() {
            return this == X ? O : X;
        }
    }

    private static final class Move extends Coordinate {

        private final Player player;

        private Move(int x, int y, Player player) {
            super(x, y);
            this.player = player;
        }

        public Player getPlayer() {
            return player;
        }

    }

    private static abstract class Coordinate {

        final int x;

        final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    private class TicTacToeBoard {

        private static final Player FRIST_PLAYER = Player.X;

        List<Move> moves = new ArrayList<>();

        public void makeMove(Move move) {
            moves.add(move);
        }

        public Player getMarker(int x, int y) {
            for (Move move : moves) {
                if (move.getX() == x && move.getY() == y) {
                    return move.getPlayer();
                }
            }
            throw new AssertionError("Move not found");
        }

        public Player getCurrentPlayer() {
            return moves.isEmpty() ? FRIST_PLAYER :
                    moves.getLast().getPlayer().not();
        }

    }

}
