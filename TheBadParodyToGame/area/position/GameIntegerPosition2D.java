package TheBadParodyToGame.area.position;

import java.io.Serializable;

public class GameIntegerPosition2D implements IntegerPosition2D, Serializable {
    private int x;
    private int y;
    private static final long serialVersionUID = 7L;

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
