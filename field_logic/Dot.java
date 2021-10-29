package field_logic;

import field_logic.intarfaces.iDot;

public class Dot implements iDot {
    private double xPos;
    private double yPos;

    Dot(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }
}
