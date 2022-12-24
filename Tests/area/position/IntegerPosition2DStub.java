package Tests.area.position;

import TheBadParodyToGame.area.position.IntegerPosition2D;

public class IntegerPosition2DStub implements IntegerPosition2D {
    private int x;
    private int y;

    public IntegerPosition2DStub() {
        x = -1;
        y = -1;
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

    @Override
    public String toString() {
        return "IntegerPosition2DStub(" + getX() + ", " + getY() + ")";
    }
}
