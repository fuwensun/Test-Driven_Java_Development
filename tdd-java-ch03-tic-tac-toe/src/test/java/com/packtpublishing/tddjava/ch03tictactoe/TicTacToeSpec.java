package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

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

        System.out.println("TicTacToe");

    }
}
