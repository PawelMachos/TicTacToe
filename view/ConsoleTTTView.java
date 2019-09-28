package pl.com.sda.pawel.machos.programowanieII_Rafal.view;

import pl.com.sda.pawel.machos.programowanieII_Rafal.TicTacToe;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.BoardModel;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.FieldState;

import java.sql.SQLOutput;

import static pl.com.sda.pawel.machos.programowanieII_Rafal.TicTacToe.BOARD_SIZE;

public class ConsoleTTTView implements TicTacToeView{

    @Override
    public void printBoard(BoardModel board) {
        for(int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                FieldState fieldStatus = board.getFieldStatus(j, i);
                System.out.print(fieldStatus.getSymbol());

                if (j < BOARD_SIZE -1){
                    System.out.print("|");
                }

            }
            if (i < BOARD_SIZE -1) { System.out.println("\n-+-+-"); }
        }
        System.out.println();
        System.out.println();
    }
}
