package pl.com.sda.pawel.machos.programowanieII_Rafal.player;

import pl.com.sda.pawel.machos.programowanieII_Rafal.TicTacToe;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTPosition;

import java.util.Scanner;

public class TTTScannerPlayer implements TTTPlayer {
    @Override
    public TTTPosition getMarkPosition() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                String input = sc.next();
                int position = Integer.valueOf(input);
                if (position >0  && position <=9) {
                    return getPositionWithMagic(position);
                }
            } catch (Exception ignore){
                System.out.println("le!");
                ignore.printStackTrace();
            }
        } while (true);

    }

    private TTTPosition getPositionWithMagic(int position){
        int x = (position -1) % TicTacToe.BOARD_SIZE;
        int y = (position -1) / TicTacToe.BOARD_SIZE;
        return new TTTPosition(x,y);
    }

    private TTTPosition getPositionWithSwitch(int position) {
        switch (position) {
            default:
            case 1:
                return new TTTPosition(0, 0);
            case 2:
                return new TTTPosition(1, 0);
            case 3:
                return new TTTPosition(2, 0);
            case 4:
                return new TTTPosition(0, 1);
            case 5:
                return new TTTPosition(1, 1);
            case 6:
                return new TTTPosition(2, 1);
            case 7:
                return new TTTPosition(0, 2);
            case 8:
                return new TTTPosition(1, 2);
            case 9:
                return new TTTPosition(2, 2);
        }
    }


}
