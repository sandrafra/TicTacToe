package com.company.kolkoikrzyzyk;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TicTacTocLogic logic = new TicTacTocLogic();
        logic.printBoard();

        while (!logic.isFinished()) {
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj wiersz i kolumne:");
            int row = in.nextInt();
            int column = in.nextInt();
            logic.move("x", row - 1, column - 1);
            logic.printBoard();
            if (logic.isFinished() == true)
                break;
            logic.moveCOMP();
            System.out.println("TERAZ KOMPUTER:");
            logic.printBoard();
        }
    }


}
