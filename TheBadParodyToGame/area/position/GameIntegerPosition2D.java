package TheBadParodyToGame.area.position;

public class GameIntegerPosition2D implements IntegerPosition2D {
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
    public boolean equals(Object o) {
        if (!(o instanceof IntegerPosition2D)) {
            return false;
        }

        IntegerPosition2D otherPos = (IntegerPosition2D) o;
        if (getX() == otherPos.getX() && getY() == otherPos.getY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "GameIntegerPosition(" + getX() + "; " + getY() + ")";
    }
}
