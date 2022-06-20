package area;

public class IntegerPosition2D implements Position2D<Integer> {
    private int x;
    private int y;

    public IntegerPosition2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }
}
