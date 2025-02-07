package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class TicTacToeTest {

    private final ArrayList<Integer> moves = new ArrayList<>();

    @Test
    public void makeFirstMove() {
        /*
        1. test = wenn ich feld 5 markiere, dann ist feld 5 vom ersten spieler markiert
        2. test = wenn ich feld 7 markiere, dann ist feld 7 vom andern spieler markiert
         */
        move(5);
        move(7);

        char actual = getState(5);
        assertThat(actual).isEqualTo('X');

        char actual2 = getState(7);
        assertThat(actual2).isEqualTo('O');
    }

    private char getState(int field) {
        return moves.indexOf(field) % 2 == 0 ? 'X' : 'O';
    }

    private void move(int field) {
        moves.add(field);
    }

}