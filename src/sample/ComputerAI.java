package sample;


import javafx.scene.control.Button;

public class ComputerAI {
    static class Move
    {
        int row, col;
    };
    int MAX_DEPTH=0;
    Button [][] board = new Button[3][3];
//    String player;
    String opponent = "O";
    public ComputerAI(Button [] board){
        this.board[0][0]=board[0] ;
        this.board[0][1]=board[1];
        this.board[0][2]=board[2];
        this.board[1][0]=board[3];
        this.board[1][1]=board[4] ;
        this.board[1][2]=board[5];
        this.board[2][0]=board[6];
        this.board[2][1]= board[7] ;
        this.board[2][2]=board[8] ;

//        this.board[0][0].setText("X");
//        this.board[0][1].setText("O");
//        this.board[0][2].setText("X");
//        this.board[1][0].setText("O");
//        this.board[1][1].setText("O");
//        this.board[1][2].setText("X");



//        System.out.println( board[0].getId());

    }
    public void getPlayer(){
        System.out.println(board[0][0].getId());
    }
    public Boolean isMovesLeft(Button board[][])
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].getText().equals(""))
                    return true;
        return false;
    }
    public  int miniMax(Button [] [] board, int depth, boolean isMax) {
        int boardVal = evaluateBoard(board, depth);

        // Terminal node (win/lose/draw) or max depth reached.
        if (Math.abs(boardVal) > 0 || depth == 0
                || !isMovesLeft(board)) {
            return boardVal;
        }

        // Maximising player, find the maximum attainable value.
        if (isMax) {
            int highestVal =-100;  //Integer.MIN_VALUE;
            for (int row = 0; row <3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col].getText().equals("")) {
                        board[row][col].setText(Controller.button.getText());
                        highestVal = Math.max(highestVal, miniMax(board,
                                depth -1, false));
                        board[row][col].setText("");
                    }
                }
            }
            return highestVal;
            // Minimising player, find the minimum attainable value;
        } else {
            int lowestVal = 100;  //Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col].getText().equals("")) {
                        board[row][col].setText("O");
                        lowestVal = Math.min(lowestVal, miniMax(board,
                                depth - 1, true));
                        board[row][col].setText("");
                    }
                }
            }
            return lowestVal;
        }
    }


    public  Move getBestMove() {
        Button [][] board=this.board;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;
        int bestValue = -100;        //Integer.MIN_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].getText().equals("")) {
                    board[row][col].setText(Controller.button.getText());
                    int moveValue = miniMax(board, MAX_DEPTH, false);
                    board[row][col].setText("");
                    if (moveValue > bestValue) {
                        bestMove.row = row;
                        bestMove.col= col;
                        bestValue = moveValue;
                    }
                }
            }
        }
        if(bestMove.row==-1 || bestMove.col==-1){
            return  bestMove;
        }else{
            board[bestMove.row][bestMove.col].setText("O");
//            System.out.printf("ROW: %d COL: %d\n\n",
//                    bestMove.row, bestMove.col );
            return bestMove;
        }
    }


    private  int evaluateBoard(Button [] [] b, int depth) {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++) {
            if (b[row][0].getText() == b[row][1].getText() &&
                    b[row][1].getText() == b[row][2].getText()) {
                if (b[row][0].getText() == Controller.button.getText())
                    return +10 + depth;
                else if (b[row][0].getText() == opponent)
                    return -10 - depth;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++) {
            if (b[0][col].getText() == b[1][col].getText() &&
                    b[1][col].getText() == b[2][col].getText()) {
                if (b[0][col].getText() == Controller.button.getText())
                    return +10 + depth;

                else if (b[0][col].getText() == opponent)
                    return -10 - depth;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0].getText() == b[1][1].getText() && b[1][1].getText() == b[2][2].getText()) {
            if (b[0][0].getText() == Controller.button.getText())
                return +10 + depth;
            else if (b[0][0].getText() == opponent)
                return -10 - depth;
        }

        if (b[0][2].getText() == b[1][1].getText() && b[1][1].getText() == b[2][0].getText()) {
            if (b[0][2].getText() == Controller.button.getText())
                return +10 + depth;
            else if (b[0][2].getText() == opponent)
                return -10 - depth;
        }

        // Else if none of them have won then return 0
        return 0;
    }

}
