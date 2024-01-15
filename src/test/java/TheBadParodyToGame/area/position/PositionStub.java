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
    public Position getUpLeft() {
        throw new UnsupportedOperationException("Stub hasn't getUpLeft method.");
    }

    @Override
    public Position getUpRight() {
        throw new UnsupportedOperationException("Stub hasn't getUpRight method.");
    }

    @Override
    public Position getDownLeft() {
        throw new UnsupportedOperationException("Stub hasn't getDownLeft method.");
    }

    @Override
    public Position getDownRight() {
        throw new UnsupportedOperationException("Stub hasn't getDownRight method.");
    }

    @Override
    public Position getUp(int y) {
        throw new UnsupportedOperationException("Stub hasn't getUp method.");
    }

    @Override
    public Position getDown(int y) {
        throw new UnsupportedOperationException("Stub hasn't getDown method.");
    }

    @Override
    public Position getLeft(int x) {
        throw new UnsupportedOperationException("Stub hasn't getLeft method.");
    }

    @Override
    public Position getRight(int x) {
        throw new UnsupportedOperationException("Stub hasn't getRight method.");
    }

    @Override
    public Position getUpLeft(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUpLeft'");
    }

    @Override
    public Position getUpRight(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUpRight'");
    }

    @Override
    public Position getDownLeft(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDownLeft'");
    }

    @Override
    public Position getDownRight(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDownRight'");
    }

    @Override
    public Position getUpRight(int x, int y) {
        throw new UnsupportedOperationException("Stub hasn't getUpRight method.");
    }

    @Override
    public Position getUpLeft(int x, int y) {
        throw new UnsupportedOperationException("Stub hasn't getUpLeft method.");
    }

    @Override
    public Position getDownRight(int x, int y) {
        throw new UnsupportedOperationException("Stub hasn't getDownRight method.");
    }

    @Override
    public Position getDownLeft(int x, int y) {
        throw new UnsupportedOperationException("Stub hasn't getDownLeft method.");
    }

}
