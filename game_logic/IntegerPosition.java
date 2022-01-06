package game_logic;

import game_logic.abstractions.interfaces.IntegerPos;

public class IntegerPosition implements IntegerPos {
    private final int xPos;
    private final int yPos;

    public IntegerPosition(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public Integer getX() {
        return xPos;
    }

    public Integer getY() {
        return yPos;
    }

    @Override
    public String toString() {
        return "(" + getX() + "; " + getY() + ")";
    }
}
