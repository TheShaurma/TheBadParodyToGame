package TheBadParodyToGame.area.position;

public interface Position {
    /**
     * @return x coordinate
     */
    int getX();

    /**
     * @return y coordinate
     */
    int getY();

    /**
     * @return position upper to 1
     */
    Position getUp();

    /**
     * @return position below to 1
     */
    Position getDown();

    /**
     * @return position lefter to 1
     */
    Position getLeft();

    /**
     * @return position upper to 1
     */
    Position getRight();

    /**
     * @return position upper to 1 and lefter to 1
     */
    Position getUpLeft();

    /**
     * @return position upper to 1 and righter to 1
     */
    Position getUpRight();

    /**
     * @return position below to 1 and lefter to 1
     */
    Position getDownLeft();

    /**
     * @return position below to 1 and righter to 1
     */
    Position getDownRight();

    /**
     * @param y
     * @return position upper to {@code y}
     */
    Position getUp(int y);

    /**
     * @param y
     * @return position below to {@code y}
     */
    Position getDown(int y);

    /**
     * @param x
     * @return position lefter to {@code x}
     */
    Position getLeft(int x);

    /**
     * @param x
     * @return position upper to {@code x}
     */
    Position getRight(int x);

    /**
     * @param n
     * @return position upper and lefter to {@code n}
     */
    Position getUpLeft(int n);

    /**
     * @param n
     * @return position upper and righter to {@code n}
     */
    Position getUpRight(int n);

    /**
     * @param n
     * @return position below and lefter to {@code n}
     */
    Position getDownLeft(int n);

    /**
     * @param n
     * @return position below and righter to {@code n}
     */
    Position getDownRight(int n);

    /**
     * @param x
     * @param y
     * @return position righter to {@code x} and upper to {@code y}
     */
    Position getUpRight(int x, int y);

    /**
     * @param x
     * @param y
     * @return position lefter to {@code x} and upper to {@code y}
     */
    Position getUpLeft(int x, int y);

    /**
     * @param x
     * @param y
     * @return position righter to {@code x} and below to {@code y}
     */
    Position getDownRight(int x, int y);

    /**
     * @param x
     * @param y
     * @return position lefter to {@code x} and below to {@code y}
     */
    Position getDownLeft(int x, int y);
}
