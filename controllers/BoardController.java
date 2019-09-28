package pl.com.sda.pawel.machos.programowanieII_Rafal.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.com.sda.pawel.machos.programowanieII_Rafal.TicTacToe;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.FieldState;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTPosition;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTResult;

public class BoardController {

    private TicTacToe logic;

    @FXML
    private TextField field;

    @FXML
    private GridPane gridBoard;

    @FXML
    public void  initialize(){
        logic = new TicTacToe(null);
        refreshInfoText();
    }

    private void refreshInfoText() {
        TTTResult gameResult = logic.checkGameResult();
        switch (gameResult) {
            case PLAYER_X_WIN:
                field.setText("Player X wins!");
                disableBoard();
                break;
            case PLAYER_O_WIN:
                field.setText("Player O wins!");
                disableBoard();
                break;
            case PENDING:
                if (logic.isPlayerXTurn()) {
                    field.setText("Player X turn");
                } else {
                    field.setText("Player O turn");
                }
                break;
            case DRAW:
                field.setText("Draw!");
                disableBoard();
                break;
        }
    }

    private void disableBoard() {
        gridBoard.setDisable(true);
    }

    @FXML
    private void handleBoardClick(ActionEvent event){
        System.out.println(event);

        Object source = event.getSource();

        if (source instanceof Button){
            Button button = (Button) source;
            String id = button.getId();
            button.getId();
            TTTPosition position = idToPosition(id);
            //boolean turnText = logic.isPlayerXTurn() ? "X" : "O";
            logic.putMark(position.getX(), position.getY());
            FieldState state = logic.getFieldStatus(position.getX(), position.getY());
            button.setText(state.name());
            button.setDisable(true);
            refreshInfoText();
        }

    }

    private TTTPosition idToPosition(String id){
        String input = id.replace("button","");
        String [] split = input.split("_");
        if(split.length == 2){
            int x = Integer.valueOf(split[0]);
            int y = Integer.valueOf(split[1]);
            return new TTTPosition(x,y);
        }
        return new TTTPosition(-1,-1);
    }
}
