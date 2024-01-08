package TheBadParodyToGame.area.withBorders.borders;

import TheBadParodyToGame.area.position.Position;

public interface Borders {
    int getXMin();

    int getXMax();

    int getYMin();

    int getYMax();

    Position getMovedInBorders(Position pos);

    boolean positionInBorders(Position pos);
}
