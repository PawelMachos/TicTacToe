package pl.com.sda.pawel.machos.programowanieII_Rafal;


import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTPosition;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTResult;
import pl.com.sda.pawel.machos.programowanieII_Rafal.player.TTTPlayer;
import pl.com.sda.pawel.machos.programowanieII_Rafal.player.TTTRandomPlayer;
import pl.com.sda.pawel.machos.programowanieII_Rafal.player.TTTScannerPlayer;
import pl.com.sda.pawel.machos.programowanieII_Rafal.view.ConsoleTTTView;

public class MainTTTGame {

    public static void main(String[] args) {
        TTTPlayer playerX = new TTTScannerPlayer();
        TTTPlayer playerO = new TTTRandomPlayer();
        TicTacToe game = new TicTacToe(new ConsoleTTTView());

        TTTPosition position;
        TTTResult result;
        do {
            if (game.isPlayerXTurn()) {
                position = playerX.getMarkPosition(game);
            } else {
                position = playerO.getMarkPosition(game);
            }
            try {
                game.putMark(position.getX(), position.getY());
                game.refreshView();
            } catch (FieldTakenException field) {
                System.out.println("To pole jest zajête!");
            }
            result = game.checkGameResult();
        } while (result == TTTResult.PENDING);

        switch (result) {
            case PLAYER_X_WIN:
                System.out.println("Gracz X wygrywa!");
                break;
            case PLAYER_O_WIN:
                System.out.println("Gracz O wygrywa!");
                break;
            case DRAW:
                System.out.println("Remis!");
                break;
        }
    }
}
