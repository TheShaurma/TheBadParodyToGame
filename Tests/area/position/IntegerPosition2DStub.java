package Tests.area.position;

import java.util.HashSet;
import java.util.Set;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public class IntegerPosition2DStub implements IntegerPosition2D {
    private int x;
    private int y;

    private static Set<Integer> allBusyX = new HashSet<>();
    private static Set<Integer> allBusyY = new HashSet<>();

    public IntegerPosition2DStub() {
        allBusyX.add(-1);
        allBusyY.add(-1);

        x = -1;
        y = -1;
    }

    private IntegerPosition2DStub(int x, int y) {
        allBusyX.add(x);
        allBusyY.add(y);

        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "IntegerPosition2DStub(" + getX() + ", " + getY() + ")";
    }

    public static IntegerPosition2DStub getUniqPosition() {
        int x;
        int y;
        while (true) {
            // set x and y random values from -100 to 100
            x = (int) (-100 + Math.random() * 200);
            y = (int) (-100 + Math.random() * 200);

            if (!allBusyX.contains(x) && !allBusyY.contains(y)) {
                break;
            }
        }

        return new IntegerPosition2DStub(x, y);
    }
}
