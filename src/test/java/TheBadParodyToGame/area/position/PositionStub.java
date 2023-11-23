package TheBadParodyToGame.area.position;

public class PositionStub implements Position {
    private int x;
    private int y;

    public PositionStub() {
        x = getX() + (int) (-1000 + Math.random() * 2000);
        y = getY() + (int) (-1000 + Math.random() * 2000);
    }

    public PositionStub(int x, int y) {
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

    public PositionStub getOther() {
        // self x and y + from -1000 to 1000
        int newX = getX() + (int) (-1000 + Math.random() * 2000);
        int newY = getY() + (int) (-1000 + Math.random() * 2000);

        return new PositionStub(newX, newY);
    }

    /**
     * @param pos
     * @return new position contrasts current and assigned {@code pos}
     */
    public PositionStub getOther(Position pos) {
        PositionStub newPos;
        while (true) {
            newPos = getOther();
            if (getX() != newPos.getX() &&
                    getY() != newPos.getY()) {
                return newPos;
            }
        }
    }

    public static PositionStub getRandomPosition() {
        int x;
        int y;

        // set x and y random values from -1000 to 1000
        x = (int) (-1000 + Math.random() * 2000);
        y = (int) (-1000 + Math.random() * 2000);

        return new PositionStub(x, y);
    }

    public PositionStub getUp() {
        int newX = getX();
        int newY = getY() + 1;

        return new PositionStub(newX, newY);
    }

    public PositionStub getDown() {
        int newX = getX();
        int newY = getY() - 1;

        return new PositionStub(newX, newY);
    }

    public PositionStub getLeft() {
        int newX = getX() - 1;
        int newY = getY();

        return new PositionStub(newX, newY);
    }

    public PositionStub getRight() {
        int newX = getX() + 1;
        int newY = getY();

        return new PositionStub(newX, newY);
    }

    @Override
    public String toString() {
        return "PositionStub(" + getX() + ", " + getY() + ")";
    }
}
