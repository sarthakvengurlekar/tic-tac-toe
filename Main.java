import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameEnded = false;

        while(!gameEnded){
            game.displayBoard();
            // Prompt the current player for input
            // Validate and make the move
            // Check for win or draw
            // Switch players if the game continues
            System.out.println("Player " + currentPlayer + ", enter your move [1-9]: ");
            int move = scanner.nextInt();
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            if(move < 1 || move > 9){
                System.out.println("Invalid move, try again");
                continue;
            }
            if(!game.makeMove(row, col, currentPlayer)){
                System.out.println("Invalid move. Try again.");
                continue;
            }
            if (game.checkWin(currentPlayer)) {
                game.displayBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (game.isBoardFull()) {
                game.displayBoard();
                System.out.println("The game is a draw!");
                gameEnded = true;
            } else {
                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }
}
