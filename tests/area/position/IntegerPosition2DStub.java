package tests.area.position;

import game.area.position.IntegerPosition2D;

public class IntegerPosition2DStub implements IntegerPosition2D {
    @Override
    public Integer getX() {
        return -1;
    }

    @Override
    public Integer getY() {
        return -1;
    }

    @Override
    public String toString() {
        return "IntegerPosition2DStub(" + getX() + ", " + getY() + ")";
    }
}
