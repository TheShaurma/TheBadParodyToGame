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
    public Position getUp() {
        return getUp(1);
    }

    @Override
    public Position getDown() {
        return getDown(1);
    }

    @Override
    public Position getLeft() {
        return getLeft(1);
    }

    @Override
    public Position getRight() {
        return getRight(1);
    }

    @Override
    public Position getUpLeft() {
        return getUpLeft(1, 1);
    }

    @Override
    public Position getUpRight() {
        return getUpRight(1, 1);
    }

    @Override
    public Position getDownLeft() {
        return getDownLeft(1, 1);
    }

    @Override
    public Position getDownRight() {
        return getDownRight(1, 1);
    }

    @Override
    public Position getUp(int y) {
        return new GamePosition(getX(), getY() + y);
    }

    @Override
    public Position getDown(int y) {
        return new GamePosition(getX(), getY() - y);
    }

    @Override
    public Position getLeft(int x) {
        return new GamePosition(getX() - x, getY());
    }

    @Override
    public Position getRight(int x) {
        return new GamePosition(getX() + x, getY());
    }

    @Override
    public Position getUpLeft(int n) {
        return getUpLeft(n, n);
    }

    @Override
    public Position getUpRight(int n) {
        return getUpRight(n, n);
    }

    @Override
    public Position getDownLeft(int n) {
        return getDownLeft(n, n);
    }

    @Override
    public Position getDownRight(int n) {
        return getDownRight(n, n);
    }

    @Override
    public Position getUpRight(int x, int y) {
        return new GamePosition(getX() + x, getY() + y);
    }

    @Override
    public Position getUpLeft(int x, int y) {
        return new GamePosition(getX() - x, getY() + y);
    }

    @Override
    public Position getDownRight(int x, int y) {
        return new GamePosition(getX() + x, getY() - y);
    }

    @Override
    public Position getDownLeft(int x, int y) {
        return new GamePosition(getX() - x, getY() - y);
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
        return "GamePosition(" + getX() + "; " + getY() + ")";
    }

}
