package pl.com.sda.pawel.machos.programowanieII_Rafal;

class FieldTakenException extends RuntimeException{

    public FieldTakenException() {
    }

    public FieldTakenException(String message) {
        super(message);
    }


    public FieldTakenException(int x, int y) {

        this(String.format("%dx%d is taken!", x, y));
    }
}
