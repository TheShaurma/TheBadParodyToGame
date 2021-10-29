package field_logic;

import java.util.HashMap;

import field_logic.intarfaces.iDot;
import field_logic.intarfaces.iField;
import field_logic.intarfaces.iObjectOnField;

public class Field implements iField {
    private HashMap<iDot, iObjectOnField> fieldItself;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    //

    public Field(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public void iteration() {
        for (iObjectOnField obj : fieldItself.values()) {
            obj.iteration();
        }
    }

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

    public void putObject(iDot pos, iObjectOnField obj) {
        checkPos(pos);
        fieldItself.put(pos, obj);
    }

    public iObjectOnField getObject(iDot pos) {
        checkPos(pos);
        if (fieldItself.containsKey(pos)) {
            return fieldItself.get(pos);
        }
        // it will return null, if pos is empty
        return null;
    }

    public void removeObject(iDot pos) {
        checkPos(pos);
        fieldItself.remove(pos);
    }

    //

    private void checkPos(iDot pos) {
        if (pos.getX() < xMin || pos.getX() > xMax || pos.getY() < yMin || pos.getY() > yMax) {
            // TODO: raise a normal exeption
        }
    }
}