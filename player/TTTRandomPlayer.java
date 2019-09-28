package pl.com.sda.pawel.machos.programowanieII_Rafal.player;

import pl.com.sda.pawel.machos.programowanieII_Rafal.model.BoardModel;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.FieldState;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTPosition;

import java.util.Random;

public class TTTRandomPlayer implements TTTPlayer {

    private Random random = new Random();

    @Override
    public TTTPosition getMarkPosition(BoardModel board) {
        // to do
        while (true) {
            int value = random.nextInt(9) + 1;
            TTTPosition position = getPositionWithMagic(value);
            FieldState fieldStatus = board.getFieldStatus(position.getX(), position.getY());
            if (fieldStatus == FieldState.EMPTY) {
                return position;
            }
        }


    }

}
