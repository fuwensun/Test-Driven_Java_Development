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
        for(int index = 0; index < 3; index++){
            if(board[0][index] == lastPlayer &&
                    board[1][index] == lastPlayer &&
                    board[2][index] == lastPlayer){
                return true;
            }
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
