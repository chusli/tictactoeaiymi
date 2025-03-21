package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int move = scanner.nextInt();
            ticTacToe.move(move);
            List<String> print = ticTacToe.print();
            for (String s : print) {
                System.out.println(s);

            }
        }
    }

}