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

        if(isWin(x,y)){
            return lastPlayer + " is the winner";
        }else if(isDraw()){
            return "The result is draw";
        }
        return "No winner";
    }

    private boolean isWin(int x, int y){
        int playerTotal = lastPlayer * SIZE;
        char horizontal = '\0';
        char vertical = '\0';
        char diagonal1 = '\0';
        char diagonal2 = '\0';

        for(int i = 0; i < SIZE; i++){

            horizontal += board[i][y -1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }

        if(horizontal == playerTotal ||
                vertical == playerTotal ||
                diagonal1 == playerTotal ||
                diagonal2 == playerTotal){
            return true;
        }

        return false;
    }

    private boolean isDraw(){
        for(int x = 0; x < SIZE; x++)
            for(int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0'){
                    return false;
            }
        }
        return true;
    }

    private boolean isWin_2(){
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

    private boolean isWinABoolean_1(){
        int playerTotal = lastPlayer * SIZE;
        for(int i = 0; i < SIZE; i++){
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

        if(board[0][0] + board[1][1] + board[2][2]
                == playerTotal){
            return true;
        }else if(board[0][2] + board[1][1] + board[2][0]
                == playerTotal) {
            return true;
        }
        return false;
    }


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
