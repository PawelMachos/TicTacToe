package pl.com.sda.pawel.machos.programowanieII_Rafal;

import pl.com.sda.pawel.machos.programowanieII_Rafal.model.BoardModel;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.FieldState;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTPosition;
import pl.com.sda.pawel.machos.programowanieII_Rafal.model.TTTResult;
import pl.com.sda.pawel.machos.programowanieII_Rafal.view.TicTacToeView;

public class TicTacToe  implements BoardModel {

    public static final int BOARD_SIZE = 3;
    private FieldState[][] board;
    private boolean isPlayerXTurn = true;
    private boolean isPlayerOTurn;
    private TicTacToeView view;



    public TicTacToe(TicTacToeView view) {
        this.view = view;
        board = new FieldState[BOARD_SIZE][BOARD_SIZE];
        initBoard();
    }

    private void initBoard() {

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = FieldState.EMPTY;
            }
        }
        System.out.println("Podaj liczbe od 1-9:");
    }

    @Override
    public FieldState getFieldStatus ( int x, int y){
            return board[y][x];
    }

    public void putMark(int x, int y) {
        if (x< 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE){
            throw new IllegalArgumentException();
        }

        try {
            if (getFieldStatus(x, y) != FieldState.EMPTY) {
                throw new FieldTakenException(x,y);
            }
        }
        catch (FieldTakenException ftke) {
            isPlayerXTurn = !isPlayerXTurn;
            System.err.println("Wybierz inne pole.");
        }

        if (isPlayerXTurn) {
            board[y][x] = FieldState.X;
        } else {
            board[y][x] = FieldState.O;
        }
        isPlayerXTurn = !isPlayerXTurn;

    }

    public void refreshView() {
        view.printBoard(this);
    }

    public TTTResult checkGameResult() {
        if(isPlayerXWin()){
            return TTTResult.PLAYER_X_WIN;
        }

        if(isPlayerOWin()){
            return TTTResult.PLAYER_O_WIN;
        }

        if(isDraw()){
            return TTTResult.DRAW;
        }


        return TTTResult.PENDING;
    }

    private boolean isDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(getFieldStatus(i,j) == FieldState.EMPTY){
                    return false;
                }
            }
        }

        return true;
    }

    // zabezpiecznie przed ponownym wybraniem zajetego miejsca
//    private boolean isTaken(int x, int y) {
//                if (getFieldStatus(x, y) != FieldState.EMPTY) {
//                    System.out.println("Wybierz inne pole.");
//                }
//
//        return true;
//    }

    private boolean isPlayerXWin() {
        FieldState checkedField = FieldState.X;

        if (isPlayerWinner(checkedField)) return true;

        return false;
    }

    private boolean isPlayerOWin() {
        FieldState checkedField = FieldState.O;

        if (isPlayerWinner(checkedField)) return true;

        return false;
    }

    private boolean isPlayerWinner(FieldState checkedField) {
        for(int i =0; i < BOARD_SIZE; i++){
            if (getFieldStatus(i, 0 ) == checkedField &&
                    getFieldStatus(i, 1 )== checkedField &&
                    getFieldStatus(i, 2 ) == checkedField ){
                return true;
            }
        }
        //check vertically
        for(int i =0; i < BOARD_SIZE; i++){
            if (getFieldStatus(0, i ) == checkedField &&
                    getFieldStatus(1, i )== checkedField &&
                    getFieldStatus(2, i ) == checkedField ){
                return true;
            }
        }
        // diagonally from left
        if(getFieldStatus(0,0) == checkedField &&
                getFieldStatus(1,1) == checkedField &&
                getFieldStatus(2,2) == checkedField ){
            return true;
        }
        // diagonally from right
        if(getFieldStatus(2,0) == checkedField &&
                getFieldStatus(1,1) == checkedField &&
                getFieldStatus(0,2) == checkedField ){
            return true;
        }
        return false;
    }

    public boolean isPlayerXTurn() {
        return isPlayerXTurn;
    }

    public boolean isPlayerOTurn() {
        return isPlayerOTurn;
    }
}