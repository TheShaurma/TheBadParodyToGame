package TheBadParodyToGame.read;

@Deprecated
public class UnknownSymbolException extends Exception {
    private char ch;

    public UnknownSymbolException(char ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return "Unknown symbol \"" + ch + "\"";
    }

    public char getSymbol() {
        return ch;
    }
}
