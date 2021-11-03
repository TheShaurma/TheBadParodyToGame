package game_logic;

import game_logic.intarfaces.iDot;

public class Dot implements iDot {
    private final int xPos;
    private final int yPos;

    public Dot(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }
}
