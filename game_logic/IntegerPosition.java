package game_logic;

import game_logic.intarfaces.IntegerPos;

public class IntegerPosition implements IntegerPos {
    private final int xPos;
    private final int yPos;

    public IntegerPosition(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    @Override
    public String toString() {
        return "(" + getX() + "; " + getY() + ")";
    }
}
