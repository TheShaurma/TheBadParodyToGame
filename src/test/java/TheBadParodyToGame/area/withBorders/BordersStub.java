package TheBadParodyToGame.area.withBorders;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.area.withBorders.borders.Borders;

public class BordersStub implements Borders {
    /**
     * @return -10
     */
    @Override
    public int getXMin() {
        return -10;
    }

    /**
     * @return 10
     */
    @Override
    public int getXMax() {
        return 10;
    }

    /**
     * @return -10
     */
    @Override
    public int getYMin() {
        return -10;
    }

    /**
     * @return 10
     */
    @Override
    public int getYMax() {
        return 10;
    }

    @Override
    public Position getMovedInBorders(Position pos) {
        int x = pos.getX() % 21;
        int y = pos.getY() % 21;

        return new PositionStub(x, y);
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
}
