package game_logic;

import java.util.HashMap;

import game_logic.intarfaces.iField;
import game_logic.intarfaces.iPos;
import game_logic.intarfaces.iObjectOnField;

public class Field implements iField {
    private FieldItself fieldItself = new FieldItself();
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    //

    public Field(int xMin, int xMax, int yMin, int yMax) {
        setLimits(xMin, xMax, yMin, yMax);
    }

    public Field() {
        setLimits(-10, 10, -10, 10);
    }

    //

    public void putObject(iPos dot, iObjectOnField obj) {
        PosOnField pos = fromDotToPos(dot);
        checkPos(pos);

        fieldItself.putObject(pos, obj);
    }

    public void putObject(int x, int y, iObjectOnField obj) {
        PosOnField pos = new PosOnField(x, y);
        checkPos(pos);

        fieldItself.putObject(pos, obj);
    }

    public iObjectOnField getObject(iPos dot) {
        PosOnField pos = fromDotToPos(dot);
        checkPos(pos);

        return fieldItself.getObject(pos);
    }

    public iObjectOnField getObject(int x, int y) {
        PosOnField pos = new PosOnField(x, y);
        checkPos(pos);

        return fieldItself.getObject(pos);
    }

    public void removeObject(iPos dot) {
        PosOnField pos = fromDotToPos(dot);
        checkPos(pos);

        fieldItself.removeObject(pos);
    }

    public void removeObject(int x, int y) {
        PosOnField pos = new PosOnField(x, y);
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
        private HashMap<Integer, HashMap<Integer, iObjectOnField>> fieldItself = new HashMap<Integer, HashMap<Integer, iObjectOnField>>();

        public void putObject(PosOnField pos, iObjectOnField obj) {
            if (fieldItself.get(pos.getX()) == null) {
                fieldItself.put(pos.getX(), new HashMap<Integer, iObjectOnField>());
            }

            fieldItself.get(pos.getX()).put(pos.getY(), obj);
        }

        public iObjectOnField getObject(PosOnField pos) {
            HashMap<Integer, iObjectOnField> xLine = fieldItself.get(pos.getX());
            if (xLine != null) {
                iObjectOnField obj = xLine.get(pos.getY());
                if (obj != null) {
                    return obj;
                }
            }

            return new NullObjectOnField();
        }

        public void removeObject(PosOnField pos) {
            fieldItself.get(pos.getX()).remove(pos.getY());
        }
    }

    private class PosOnField {
        private int x;
        private int y;

        PosOnField(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private class NullObjectOnField implements iObjectOnField {
        public boolean isNull() {
            return true;
        }

        public String toString() {
            return " ";
        }
    }

    //

    private PosOnField fromDotToPos(iPos dot) {
        return new PosOnField(dot.getX(), dot.getY());
    }

    private void checkPos(PosOnField pos) {
        if (pos.getX() < getXMinLimit() || pos.getX() > getXMaxLimit() || pos.getY() < getYMinLimit()
                || pos.getY() > getYMaxLimit()) {
            // TODO: raise a normal exeption
        }
    }

    private void setLimits(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

}