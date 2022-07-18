package game.area;

public interface Position2D<N extends Number> {
    /**
     * @return x coordinate
     */
    N getX();

    /**
     * @return y coordinate
     */
    N getY();
}
