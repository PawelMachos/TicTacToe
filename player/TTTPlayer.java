package pl.com.sda.pawel.machos.programowanieII_Rafal.player;

import pl.com.sda.pawel.machos.programowanieII_Rafal.TicTacToe;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.BoardModel;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTPosition;

public interface TTTPlayer {

    TTTPosition getMarkPosition(BoardModel board);

    default TTTPosition getPositionWithMagic(int position){
        int x = (position -1) % TicTacToe.BOARD_SIZE;
        int y = (position -1) / TicTacToe.BOARD_SIZE;
        return new TTTPosition(x,y);
    }
}
