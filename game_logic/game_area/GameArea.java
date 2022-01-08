package game_logic.game_area;

import java.util.HashMap;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.ObjectInArea;
import game_logic.game_area.exceptions.Limit;
import game_logic.game_area.exceptions.PositionOutOfLimitException;

public class GameArea implements CheckeredArea {
    private FieldItself fieldItself = new FieldItself();
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    //
    public GameArea(int xMin, int xMax, int yMin, int yMax) {
        setLimits(xMin, xMax, yMin, yMax);
    }

    public GameArea(IntegerPos minPos, IntegerPos maxPos) {
        setLimits(minPos.getX(), maxPos.getY(), minPos.getY(), maxPos.getY());
    }

    public GameArea(int xLength, int yLength) {
        setLimits(0, xLength - 1, 0, yLength - 1);
    }

    public GameArea() {
        setLimits(-10, 10, -10, 10);
    }

    public boolean posIsEmpty(IntegerPos pos) throws PositionOutOfLimitException {
        checkPos(new PosOnFieldAdapter(pos));
        return getObject(pos).isNull();
    }

    //
    public void putObject(IntegerPos dot, ObjectInArea obj) throws PositionOutOfLimitException {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(dot);
        checkPos(pos);

        fieldItself.putObject(pos, obj);
    }

    public void putObject(int x, int y, ObjectInArea obj) throws PositionOutOfLimitException {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(x, y);
        checkPos(pos);

        fieldItself.putObject(pos, obj);
    }

    public ObjectInArea getObject(IntegerPos dot) throws PositionOutOfLimitException {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(dot);
        checkPos(pos);

        return fieldItself.getObject(pos);
    }

    public ObjectInArea getObject(int x, int y) throws PositionOutOfLimitException {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(x, y);
        checkPos(pos);

        return fieldItself.getObject(pos);
    }

    public void removeObject(IntegerPos dot) throws PositionOutOfLimitException {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(dot);
        checkPos(pos);

        fieldItself.removeObject(pos);
    }

    public void removeObject(int x, int y) throws PositionOutOfLimitException {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(x, y);
        checkPos(pos);

        fieldItself.removeObject(pos);
    }

    //
    public int getXMinLimit() {
        return xMin;
    }

    public int getXMaxLimit() {
        return xMax;
    }

    public int getYMinLimit() {
        return yMin;
    }

    public int getYMaxLimit() {
        return yMax;
    }

    //
    private void checkPos(PosOnFieldAdapter pos) throws PositionOutOfLimitException {
        int x = pos.getX();
        int y = pos.getY();

        if (x < getXMinLimit()) {
            throw new PositionOutOfLimitException(pos, Limit.X_MIN);
        } else if (x > getXMaxLimit()) {
            throw new PositionOutOfLimitException(pos, Limit.X_MAX);
        } else if (y < getYMinLimit()) {
            throw new PositionOutOfLimitException(pos, Limit.Y_MIN);
        } else if (y > getYMaxLimit()) {
            throw new PositionOutOfLimitException(pos, Limit.Y_MAX);
        }
    }

    private void setLimits(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

}

class FieldItself {
    // FIXME: fix this code!
    private HashMap<Integer, HashMap<Integer, ObjectInArea>> fieldItself = new HashMap<Integer, HashMap<Integer, ObjectInArea>>();

    public void putObject(PosOnFieldAdapter pos, ObjectInArea obj) {
        if (fieldItself.get(pos.getX()) == null) {
            fieldItself.put(pos.getX(), new HashMap<Integer, ObjectInArea>());
        }

        fieldItself.get(pos.getX()).put(pos.getY(), obj);
    }

    public ObjectInArea getObject(PosOnFieldAdapter pos) {
        HashMap<Integer, ObjectInArea> xLine = fieldItself.get(pos.getX());
        if (xLine != null) {
            ObjectInArea obj = xLine.get(pos.getY());
            if (obj != null) {
                return obj;
            }
        }

        return new NullObjectOnField();
    }

    public void removeObject(PosOnFieldAdapter pos) {
        fieldItself.get(pos.getX()).remove(pos.getY());
    }
}

class PosOnFieldAdapter implements IntegerPos {
    private final int x;
    private final int y;

    public PosOnFieldAdapter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PosOnFieldAdapter(IntegerPos pos) {
        x = pos.getX();
        y = pos.getY();
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}

class NullObjectOnField implements ObjectInArea {
    public boolean isNull() {
        return true;
    }

    public String toString() {
        return ".";
    }
}