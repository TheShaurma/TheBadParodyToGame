package game_logic;

import game_logic.intarfaces.iDot;

public class Dot implements iDot {
    private int xPos;
    private int yPos;

    Dot(int x, int y) {
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
