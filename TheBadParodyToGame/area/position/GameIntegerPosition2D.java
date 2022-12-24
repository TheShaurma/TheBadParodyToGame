package TheBadParodyToGame.area.position;

public class GameIntegerPosition2D implements IntegerPosition2D {
    private static final long serialVersionUID = 3L;

    private int x;
    private int y;

    public GameIntegerPosition2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "GameIntegerPosition(" + getX() + "; " + getY() + ")";
    }
}
