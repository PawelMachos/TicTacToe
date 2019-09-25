package pl.com.sda.pawel.machos.programowanieII_Rafal.model;

public enum FieldState {
    EMPTY(" "),
    X("X"),
    O("O");
    private String symbol;

    FieldState(String symbol){
        this.symbol =symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
