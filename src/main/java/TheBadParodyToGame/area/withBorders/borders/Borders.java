package TheBadParodyToGame.area.withBorders.borders;

import TheBadParodyToGame.area.position.Position;

public interface Borders {
    /**
     * @return min x value
     */
    int getXMin();

    /**
     * @return max x value
     */
    int getXMax();

    /**
     * @return min y value
     */
    int getYMin();

    /**
     * @return max y value
     */
    int getYMax();

    Position getMovedInBorders(Position pos);

    /**
     * @param pos
     * @return {@code true} if {@code getMinX()} <= {@code pos.getX()} <=
     *         {@code getMaxX()}
     *         and {@code getMinY()} <= {@code pos.getY()} <=
     *         {@code getMaxY()}
     *         else {@code false}
     */
    boolean positionInBorders(Position pos);
}
