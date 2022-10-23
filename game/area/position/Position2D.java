package game.area.position;

import java.io.Serializable;

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
