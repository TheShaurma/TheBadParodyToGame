package TheBadParodyToGame.area.position;

public class GamePosition implements Position {
    private int x;
    private int y;

    public GamePosition(int x, int y) {
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
        if (!(o instanceof Position)) {
            return false;
        }

        Position otherPos = (Position) o;
        if (getX() == otherPos.getX() && getY() == otherPos.getY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getX() * getY();
    }

    @Override
    public String toString() {
        return "GameIntegerPosition(" + getX() + "; " + getY() + ")";
    }
}
