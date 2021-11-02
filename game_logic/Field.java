package game_logic;

import java.util.HashMap;

import game_logic.intarfaces.iDot;
import game_logic.intarfaces.iFieldWithIterableObjects;
import game_logic.intarfaces.iIterableObjectOnField;
import game_logic.intarfaces.iObjectOnField;

public class Field implements iFieldWithIterableObjects {
    private HashMap<PosOnField, iObjectOnField> fieldItself;
    private HashMap<String, iIterableObjectOnField> iterableObjects;
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
        for (iIterableObjectOnField iterableObject : iterableObjects.values()) {
            iterableObject.iteration();
        }
    }

    public void putObject(iDot dot, iObjectOnField obj) {
        PosOnField pos = fromDotToPos(dot);
        checkPos(pos);
        fieldItself.put(pos, obj);
    }

    public iObjectOnField getObject(iDot dot) {
        PosOnField pos = fromDotToPos(dot);
        checkPos(pos);
        if (fieldItself.containsKey(pos)) {
            return fieldItself.get(pos);
        }
        // FIXME: fix this!!!
        // it will return null, if pos is empty
        return null;
    }

    public void removeObject(iDot dot) {
        PosOnField pos = fromDotToPos(dot);
        checkPos(pos);
        removeObjectFromField(pos);
    }

    public void putIterableObject(String name, iIterableObjectOnField obj) {
        iterableObjects.put(name, obj);
    }

    public iIterableObjectOnField getIterableObject(String name) {
        return iterableObjects.get(name);
    }

    public void removeIterableObject(String name) {
        iterableObjects.remove(name);
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

    private PosOnField fromDotToPos(iDot dot) {
        return new PosOnField(dot.getX(), dot.getY());
    }

    private void checkPos(PosOnField pos) {
        if (pos.getX() < getXMinLimit() || pos.getX() > getXMaxLimit() || pos.getY() < getYMinLimit()
                || pos.getY() > getYMaxLimit()) {
            // TODO: raise a normal exeption
        }
    }

    private void removeObjectFromField(PosOnField pos) {
        fieldItself.remove(pos);
    }
}