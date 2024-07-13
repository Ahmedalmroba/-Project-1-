import java.util.InputMismatchException;
import java.util.Scanner;

class GameXO {
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;
    private int roundCount;
    private int totalRounds;
    private int playerScore;
    private int computerScore;

    public GameXO() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        roundCount = 0;
        totalRounds = 3;
        playerScore = 0;
        computerScore = 0;
        startBoard();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome  GameXO!");
        System.out.println("Select an option:");
        System.out.println("1. Play one round");
        System.out.println("2. Play three rounds and determine the winner");
        System.out.print("Enter your choice (1 or 2): ");
        try {

            int choice = scanner.nextInt();

            if (choice == 1) {
                playRound();
            } else if (choice == 2) {
                System.out.println("Let's play three rounds!");
                while (roundCount < totalRounds) {
                    playRound();
                    resetBoard();
                    roundCount++;
                }
                determineWinner();
            } else {
                System.out.println("Invalid choice. Please try again.");
                playGame();

            }
        }catch (InputMismatchException e ){
            System.out.println("invalid please inter 1 or 2");
        }
    }
    private void startBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    private void displayBoard() {
        System.out.println("..............");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("..............");
        }
    }

    private boolean isValidPosition(int position) {
        return position >= 1 && position <= 9 && getPositionValue(position) == '-';
    }

    private char getPositionValue(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return board[row][col];
    }

    private void makeMove(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board[row][col] = currentPlayer;
    }

    private void makeComputerMove() {
        int position;
        do {
            position = (int) (Math.random() * 9) + 1;
        } while (!isValidPosition(position));

        makeMove(position);
        System.out.println("Computer chose position: " + position);
    }

    private boolean checkWin(char player) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }


        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }


        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player)
                || (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void playRound() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Round " + (roundCount + 1) + "!");

        while (!gameOver) {
            displayBoard();
            System.out.println("Current Player: " + currentPlayer);
            System.out.print("Enter the position (1-9): ");
            int position = scanner.nextInt();

            if (isValidPosition(position)) {
                makeMove(position);
                if (checkWin(currentPlayer)) {
                    displayBoard();


                    System.out.println("Player " + currentPlayer + " wins!");
                    updateScores(currentPlayer);
                    gameOver = true;
                } else if (isBoardFull()) {
                    displayBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    makeComputerMove();
                    if (checkWin(currentPlayer)) {
                        displayBoard();
                        System.out.println("Computer wins!");
                        updateScores(currentPlayer);
                        gameOver = true;
                    } else if (isBoardFull()) {
                        displayBoard();
                        System.out.println("It's a draw!");
                        gameOver = true;
                    }
                }
            } else {
                System.out.println("Invalid position. Please try again.");
            }
        }
    }

    private void determineWinner() {
        System.out.println("Game over!");

        if (playerScore > computerScore) {
            System.out.println("Player wins the game!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private void updateScores(char player) {
        if (player == 'X') {
            playerScore++;
        } else {
            computerScore++;
        }
        System.out.println("Player Score: " + playerScore);
        System.out.println("Computer Score: " + computerScore);
    }

    private void resetBoard() {
        startBoard();
        currentPlayer = 'X';
        gameOver = false;
    }

    public static void main(String[] args) {
        GameXO game = new GameXO();
        game.playGame();
}
}