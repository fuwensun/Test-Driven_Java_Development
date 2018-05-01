package com.packtpublishing.tddjava.ch03tictactoe;

//静态方法导入
import static com.packtpublishing.tddjava.debug.MyDebug.myDebug;

public class TicTacToe {

    public TicTacToe() {
        myDebug("TicTacToe()");
    }

    private Character[][] board = {{'\0','\0','\0'},
        {'\0','\0','\0'},{'\0','\0','\0'}};

    private char lastPlayer = '\0';
    private static final int SIZE = 3;

    public String play(int x, int y){
        myDebug("paly(x = %d, y = %d)",x,y);
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x,y,lastPlayer);

        if(isWin()){
            return lastPlayer + " is the winner";
        }
        return "No winner";
    }

    private boolean isWin(){
        int playerTotal = lastPlayer * SIZE;
        char diagonal1 = '\0';
        char diagonal2 = '\0';

        for(int i = 0; i < SIZE; i++){

            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];

            if(board[0][i] + board[1][i] + board[2][i]
                    == playerTotal){
                return true;
            }else if(board[i][0] + board[i][1] + board[i][2]
                    == playerTotal){
                return true;
            }
            else if(playerTotal == '\0') {
                return true;
            }
        }

        if(diagonal1 == playerTotal || diagonal2 == playerTotal){
            return true;
        }

        return false;
    }

//    private boolean isWin(){
//        int playerTotal = lastPlayer * SIZE;
//        for(int i = 0; i < SIZE; i++){
//            if(board[0][i] + board[1][i] + board[2][i]
//                    == playerTotal){
//                return true;
//            }else if(board[i][0] + board[i][1] + board[i][2]
//                    == playerTotal){
//                return true;
//            }
//            else if(playerTotal == '\0') {
//                return true;
//            }
//        }
//
//        if(board[0][0] + board[1][1] + board[2][2]
//                == playerTotal){
//            return true;
//        }else if(board[0][2] + board[1][1] + board[2][0]
//                == playerTotal) {
//            return true;
//        }
//        return false;
//    }

    public char nextPlayer(){
        if(lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }

    private void checkAxis(int axis){
        myDebug("checkAxis()");

        if(axis < 1 || axis > 3){
            throw new RuntimeException("X is outside board");
        }
    }

    private void setBox(int x, int y,char lastPlayer){
        if(board[x-1][y -1] != '\0'){
            throw new RuntimeException("Box is occupied");
        }else{
            board[x - 1][y - 1] = lastPlayer;
        }
    }





//---------------------------------------------------------
//    private Character[][] board = {{'\0','\0','\0'},
//            {'\0','\0','\0'},{'\0','\0','\0'}};
//
//    public void play(int x, int y){
//        if(x < 1 || x > 3){
//            throw new RuntimeException("X is outside board");
//        }else if (y < 1 || y > 3){
//            throw new RuntimeException("Y is outside board");
//        }
//
//        if(board[x-1][y -1] != '\0'){
//            throw new RuntimeException("Box is occupied");
//        }else{
//            board[x - 1][y - 1] = 'X';
//        }
//    }
}
