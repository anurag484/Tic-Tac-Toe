import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        boolean gameEnded = false;

        while (!gameEnded) {
            playerMove();
            printBoard();
            gameEnded = checkWinner();

            if (!gameEnded) {
                switchPlayer();
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int col = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column, 0-2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                validInput = true;
            } else {
                System.out.println("This move is not valid.");
            }
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private static boolean checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }

        // Check for tie
        boolean boardFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    boardFull = false;
                    break;
                }
            }
        }

        if (boardFull) {
            System.out.println("The game is a tie!");
            return true;
        }

        return false;
    }
}
