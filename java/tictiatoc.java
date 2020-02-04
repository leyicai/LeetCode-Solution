import java.util.Scanner;

import javax.management.RuntimeErrorException;

class TicTacToc {
    private char[][] board = new char[][] { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

    public void addToken(char token, int row, int col) {
        board[row][col] = token;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }
        System.out.println();

    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void aiMove() {
        if (isFull()) {
            throw new RuntimeException("Board is full!");
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                    return;
                }
            }
        }
    }

    public boolean validateMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Index Out of range! Shoule between 0 and 2");
            return false;
        }
        if (board[row][col] != '-') {
            System.out.println("Occupied! Please try again!");
            return false;
        }
    }

    public static void main(String[] args) {
        TicTacToc t = new TicTacToc();
        t.printBoard();
        // t.addToken('X', 0, 0);
        // t.printBoard();
        // t.aiMove();
        // t.aiMove();
        // t.aiMove();
        // t.aiMove();
        // t.aiMove();
        // t.aiMove();
        // t.aiMove();
        // t.aiMove();
        // t.aiMove();
        // game loop

        t.printBoard();
        Scanner in = new Scanner(System.in);
        int row, col;

        while (in.hasNext()) {
            row = in.nextInt();
            col = in.nextInt();
            if (!t.validateMove(row, col)) {
                continue;
            }
            t.addToken('X', row, col);
            t.printBoard();
            if (t.isFull()) {
                System.out.println("End Game!");
                return;
            }
            t.aiMove();
            t.printBoard();
        }
        in.close();
    }
}
