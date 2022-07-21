package game.rooms;

public class UnknownSymbolException extends Exception {
    private char ch;

    public UnknownSymbolException(char ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "Unknown symbol \"" + ch + "\"";
    }
}
