package com.packtpublishing.tddjava.ch03tictactoe;

//静态方法导入
import static com.packtpublishing.tddjava.debug.MyDebug.myDebug;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;




public class TicTacToeSpec {

    public TicTacToeSpec(){
        myDebug("TicTacToeSpec()");
    }

    @Rule
    public ExpectedException exception =
            ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXoutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(51,2);
    }

    @Test
    public void whenYoutsideBoardTheRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,51);
    }

    @Test
    public void whenOccupiedThenRuntimeExceptoin(){
        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,1);
    }

    @Test
    public void giveFirstTureWhenNextPlayerThenX(){
        assertEquals('X',ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner(){
        String actual = ticTacToe.play(1,1);
        assertEquals("No winner", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner(){
        myDebug("whenPlayAndWholeHorizontalLineThenWinner()!!!");
        ticTacToe.play(1,1); //x
        ticTacToe.play(1,2); //o
        ticTacToe.play(2,1); //x
        ticTacToe.play(2,2); //o
        String actual = ticTacToe.play(3,1); //x
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineTheWinner(){
        myDebug("whenPlayAndWholeVerticalLineTheWinner()");
        ticTacToe.play(2,1); //x
        ticTacToe.play(1,1); //o
        ticTacToe.play(3,1); //x
        ticTacToe.play(1,2); //o
        ticTacToe.play(2,2); //x
        String actual = ticTacToe.play(1,3); //o
        assertEquals("O is the winner", actual);
    }

    @Test
    public void whenPlayAndTopBottomDiagonalLisneThenWinner(){
        myDebug("whenPlayAndTopBottomDiagonalLisneThenWinner()");
        ticTacToe.play(1,1); //x
        ticTacToe.play(1,2); //o
        ticTacToe.play(2,2); //x
        ticTacToe.play(1,3); //o
        String actual = ticTacToe.play(3,3); //x
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenPlayAndBottomTopDiagonalLisneThenWinner(){
        myDebug("whenPlayAndBottomTopDiagonalLisneThenWinner()");
        ticTacToe.play(1,3); //x
        ticTacToe.play(1,1); //o
        ticTacToe.play(2,2); //x
        ticTacToe.play(1,2); //o
        String actual = ticTacToe.play(3,1); //x
        assertEquals("X is the winner", actual);
    }

    @Test
    public void whenAllBoxesAreFilledThenDraw(){
        myDebug("whenAllBoxesAreFilledThenDraw()");
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(1,3);
        ticTacToe.play(2,1);
        ticTacToe.play(2,2);
        ticTacToe.play(2,3);
        ticTacToe.play(3,1);
        ticTacToe.play(3,3);
        String actual = ticTacToe.play(3,2);
        assertEquals("The result is draw", actual);
    }


}
