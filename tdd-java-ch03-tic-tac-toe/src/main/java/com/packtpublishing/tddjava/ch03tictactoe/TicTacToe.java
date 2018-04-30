package com.packtpublishing.tddjava.ch03tictactoe;

//静态方法导入
import static com.packtpublishing.tddjava.debug.MyDebug.myDebug;

public class TicTacToe {

    public TicTacToe() {
        myDebug("TicTacToe()");
    }

    private Character[][] board = {{'\0','\0','\0'},
        {'\0','\0','\0'},{'\0','\0','\0'}};

    public void play(int x, int y){
        checkAxis(x);
        checkAxis(y);
        setBox(x,y);

        myDebug("paly()");
    }

    private void checkAxis(int axis){
        myDebug("checkAxis()");

        if(axis < 1 || axis > 3){
            throw new RuntimeException("X is outside board");
        }
    }

    private void setBox(int x, int y){
        if(board[x-1][y -1] != '\0'){
            throw new RuntimeException("Box is occupied");
        }else{
            board[x - 1][y - 1] = 'X';
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
