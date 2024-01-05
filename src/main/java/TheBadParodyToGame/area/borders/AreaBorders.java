package TheBadParodyToGame.area.borders;

import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;

public class AreaBorders implements Borders {
    private final int xMin;
    private final int xMax;
    private final int yMin;
    private final int yMax;

    public AreaBorders(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public AreaBorders(int x, int y) {
        this.xMin = Math.min(0, x);
        this.xMax = Math.max(0, x);
        this.yMin = Math.min(0, y);
        this.yMax = Math.max(0, y);
    }

    @Override
    public int getXMin() {
        return xMin;
    }

    @Override
    public int getXMax() {
        return xMax;
    }

    @Override
    public int getYMin() {
        return yMin;
    }

    @Override
    public int getYMax() {
        return yMax;
    }

    @Override
    public Position getMovedInBorders(Position pos) {
        int x = pos.getX() % getXDistance();
        int y = pos.getY() % getYDistance();

        return new GamePosition(x, y);
    }

    @Override
    public boolean positionInBorders(Position pos) {
        int x = pos.getX();
        int y = pos.getY();

        if ((x >= getXMin() && x <= getXMax()) &&
                (y >= getYMin() && y <= getYMax())) {
            return true;
        } else {
            return false;
        }
    }

    protected int getXDistance() {
        return getXMax() - getXMin() + 1;
    }

    protected int getYDistance() {
        return getYMax() - getYMin() + 1;
    }
}
