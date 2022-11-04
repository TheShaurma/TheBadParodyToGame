package game.area.position;

import java.io.Serializable;

/**
 * This is 2d position for objects ia Area.
 */
public interface Position2D<N extends Number> extends Serializable {
    /**
     * @return x coordinate
     */
    N getX();

    /**
     * @return y coordinate
     */
    N getY();
}
