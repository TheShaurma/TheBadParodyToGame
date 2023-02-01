package Tests.area.position;

import TheBadParodyToGame.area.position.IntegerPosition2D;

public class IntegerPosition2DStub implements IntegerPosition2D {
    private int x;
    private int y;

    public IntegerPosition2DStub() {
        x = getX() + (int) (-1000 + Math.random() * 2000);
        y = getY() + (int) (-1000 + Math.random() * 2000);
    }

    public IntegerPosition2DStub(int x, int y) {
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

    public IntegerPosition2DStub getOther() {
        // self x and y + from -1000 to 1000
        int newX = getX() + (int) (-1000 + Math.random() * 2000);
        int newY = getY() + (int) (-1000 + Math.random() * 2000);

        return new IntegerPosition2DStub(newX, newY);
    }

    /**
     * @param pos
     * @return new position contrasts current and assigned {@code pos}
     */
    public IntegerPosition2DStub getOther(IntegerPosition2D pos) {
        IntegerPosition2DStub newPos;
        while (true) {
            newPos = getOther();
            if (getX() != newPos.getX() &&
                    getY() != newPos.getY()) {
                return newPos;
            }
        }
    }

    public static IntegerPosition2DStub getRandomPosition() {
        int x;
        int y;

        // set x and y random values from -1000 to 1000
        x = (int) (-1000 + Math.random() * 2000);
        y = (int) (-1000 + Math.random() * 2000);

        return new IntegerPosition2DStub(x, y);
    }

    public IntegerPosition2DStub getUp() {
        int newX = getX();
        int newY = getY() + 1;

        return new IntegerPosition2DStub(newX, newY);
    }

    public IntegerPosition2DStub getDown() {
        int newX = getX();
        int newY = getY() - 1;

        return new IntegerPosition2DStub(newX, newY);
    }

    public IntegerPosition2DStub getLeft() {
        int newX = getX() - 1;
        int newY = getY();

        return new IntegerPosition2DStub(newX, newY);
    }

    public IntegerPosition2DStub getRight() {
        int newX = getX() + 1;
        int newY = getY();

        return new IntegerPosition2DStub(newX, newY);
    }

    @Override
    public String toString() {
        return "IntegerPosition2DStub(" + getX() + ", " + getY() + ")";
    }
}
