package game_logic;

import java.util.HashMap;

import game_logic.intarfaces.Location;
import game_logic.intarfaces.IntegerPos;
import game_logic.intarfaces.ObjectOnField;

public class GameLocation implements Location {
    private FieldItself fieldItself = new FieldItself();
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    //

    public GameLocation(int xMin, int xMax, int yMin, int yMax) {
        setLimits(xMin, xMax, yMin, yMax);
    }

    public GameLocation() {
        setLimits(-10, 10, -10, 10);
    }

    //

    public void putObject(IntegerPos dot, ObjectOnField obj) {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(dot);
        checkPos(pos);

        fieldItself.putObject(pos, obj);
    }

    public void putObject(int x, int y, ObjectOnField obj) {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(x, y);
        checkPos(pos);

        fieldItself.putObject(pos, obj);
    }

    public ObjectOnField getObject(IntegerPos dot) {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(dot);
        checkPos(pos);

        return fieldItself.getObject(pos);
    }

    public ObjectOnField getObject(int x, int y) {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(x, y);
        checkPos(pos);

        return fieldItself.getObject(pos);
    }

    public void removeObject(IntegerPos dot) {
        PosOnFieldAdapter pos = new PosOnFieldAdapter(dot);
        checkPos(pos);

        fieldItself.removeObject(pos);
    }

    public void removeObject(int x, int y) {
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

    private class FieldItself {
        private HashMap<Integer, HashMap<Integer, ObjectOnField>> fieldItself = new HashMap<Integer, HashMap<Integer, ObjectOnField>>();

        public void putObject(PosOnFieldAdapter pos, ObjectOnField obj) {
            if (fieldItself.get(pos.getX()) == null) {
                fieldItself.put(pos.getX(), new HashMap<Integer, ObjectOnField>());
            }

            fieldItself.get(pos.getX()).put(pos.getY(), obj);
        }

        public ObjectOnField getObject(PosOnFieldAdapter pos) {
            HashMap<Integer, ObjectOnField> xLine = fieldItself.get(pos.getX());
            if (xLine != null) {
                ObjectOnField obj = xLine.get(pos.getY());
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

    private class PosOnFieldAdapter {
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

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private class NullObjectOnField implements ObjectOnField {
        public boolean isNull() {
            return true;
        }

        public String toString() {
            return " ";
        }
    }

    //

    private void checkPos(PosOnFieldAdapter pos) {
        if (pos.getX() < getXMinLimit() || pos.getX() > getXMaxLimit() || pos.getY() < getYMinLimit()
                || pos.getY() > getYMaxLimit()) {
            // TODO: raise a normal exception
        }
    }

    private void setLimits(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

}