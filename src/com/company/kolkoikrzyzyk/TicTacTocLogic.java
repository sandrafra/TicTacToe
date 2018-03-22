package com.company.kolkoikrzyzyk;

import java.util.Random;

public class TicTacTocLogic {


    private final int SIZE = 3; // final- stałej nie da sie zmienić, jak coś jest stałą to lepiej oznaczyć wielkimi literami
    private final String o = "o";
    private final String x = "x";
    private final String empty = "-";
    public String ktory = "-";

    Random gen = new Random(); // funkcja która będzie losować przy ruchu komputera

    private String[][] board;

    public TicTacTocLogic() {
        init();
    }

    private void init() {
        board = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) { // wypełnienie tablicy danymi - "-"
                board[i][j] = "-";
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }

    }

    public boolean move(String symbol, int rowIndex, int columnIndex) {
        boolean good = true;
        if ((rowIndex > 2) || (columnIndex) > 2) {
            System.out.println("NIE MA TAKIEGO POLA!");
            good = false;
        } else {
            if (symbol.equals(x) || symbol.equals(o) && board[rowIndex][columnIndex].equals(empty)) {
                if (board[rowIndex][columnIndex] == "-") {
                    board[rowIndex][columnIndex] = symbol;
                    ktory = symbol;
                    good = true;
                } else System.out.println("Zajęte pole!");
                good = false;
            } else {
                System.out.println("Zły znak!");
                good = false;
            }
        }
        return good;
    }

    public void moveCOMP() {
        int a = 0;
        do {
            int row = gen.nextInt(3);
            int col = gen.nextInt(3);
            if (board[row][col] == "-") {
                board[row][col] = "o";
                a++;
                ktory = "o";
            }
        }
        while (a == 0);

    }

    public boolean equalRow() {
        boolean equal = false;
        if (board[0][0].equals(board[0][1]) && board[0][2].equals(board[0][1]) && !board[0][0].equals("-")) {
            equal = true;
        } else if (board[1][0].equals(board[1][1]) && board[1][2].equals(board[1][1]) && !board[1][0].equals("-")) {
            equal = true;
        } else if (board[2][0].equals(board[2][1]) && board[2][2].equals(board[2][0]) && !board[2][0].equals("-")) {
            equal = true;
        }
        return equal;
    }


    public boolean equalColumn() {
        boolean equal = false;
        if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && !board[0][0].equals("-")) {
            equal = true;
        } else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && !board[0][1].equals("-")) {
            equal = true;
        } else if (board[0][2].equals(board[1][2]) && board[2][2].equals(board[1][2]) && !board[0][2].equals("-")) {
            equal = true;
        }
        return equal;
    }

    public boolean equalCross() {
        boolean equal = false;
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("-")) {
            equal = true;
        } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[1][1].equals("-")) {
            equal = true;
        }

        return equal;
    }


    public boolean isFinished() {
        boolean end = false;
        if (equalRow() == true) {
            System.out.println("Równe wiersze");
            end = true;
            if (end == true) {
                System.out.println("WYGRAŁEŚ ZAWODNIKU " + ktory + "!");
            }
        } else if (equalColumn() == true) {
            System.out.println("Równe kolumny");
            end = true;
            if (end == true) {
                System.out.println("WYGRAŁEŚ ZAWODNIKU " + ktory + "!");
            }
        } else if (equalCross() == true) {
            System.out.println("Równa przekątna");
            end = true;
            if (end == true) {
                System.out.println("WYGRAŁEŚ ZAWODNIKU " + ktory + "!");
            }

        }
        int id = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == "-") {
                    id++;
                }
            }
        }
        if (id == 0) {
            System.out.println("nitk nie wygrał!");
        }
        return end;
    }
}
