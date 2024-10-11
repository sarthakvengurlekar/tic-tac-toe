public class GameBoard {
    private char[][] board;

    public GameBoard(){
        this.board = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.board[i][j] = ' ';
            }
        }
    }

    public void displayBoard(){
        System.out.println("-------------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean makeMove(int row, int column, char player){
        if(board[row][column] == ' '){
            board[row][column] = player;
            return true;
        }else {
            return false;
        }
    }

    public boolean checkWin(char player){
        //Check rows, column and diagonal wins
        //true if player wins
        //Rows and columns
        for(int i = 0; i < 3; i++){
            if((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)){
                return true;
            }
        }
        //diagonals
        if(board[0][0] == player &&board[1][1] == player && board[2][2] == player ||
        board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }
        return false;
    }

    public boolean isBoardFull(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

}
