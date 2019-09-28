package pl.com.sda.pawel.machos.programowanieII_Rafal.view;

import pl.com.sda.pawel.machos.programowanieII_Rafal.player.TTTPlayer;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTPosition;
import pl.com.sda.pawel.machos.programowanieII_Rafal.TicTacToe;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTResult;
import pl.com.sda.pawel.machos.programowanieII_Rafal.player.TTTRandomPlayer;
import pl.com.sda.pawel.machos.programowanieII_Rafal.player.TTTScannerPlayer;

public class MainTTTGame {

    public static void main(String[] args) {
        TTTPlayer playerX = new TTTScannerPlayer(); //X
        TTTPlayer playerO = new TTTRandomPlayer(); //O
        TicTacToe game = new TicTacToe(new ConsoleTTTView());

        TTTPosition position;
        do {
            if(game.isPlayerXTurn()){
                position = playerX.getMarkPosition(game);
            } else {
                position = playerO.getMarkPosition(game);
            }
            game.putMark(position.getX(), position.getY());
            game.refreshView();
        } while (game.checkGameResult() == TTTResult.PENDING);

        // test
        /*do {
            if(game.isPlayerOTurn()){
                position = playerO.getMarkPosition();
            } else {
                position = playerX.getMarkPosition();
            }
            game.putMark(position.getX(), position.getY());
            game.refreshView();
        } while (game.checkGameResult() == TTTResult.PENDING);*/

    }
}
