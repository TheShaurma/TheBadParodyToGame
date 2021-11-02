package field_logic;

import java.util.HashMap;

import field_logic.intarfaces.iDot;
import field_logic.intarfaces.iFieldWithIterableObjects;
import field_logic.intarfaces.iIterableObjectOnField;
import field_logic.intarfaces.iObjectOnField;

public class Field implements iFieldWithIterableObjects {
    private HashMap<iDot, iObjectOnField> fieldItself;
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

    public void putObject(iDot pos, iObjectOnField obj) {
        checkPos(pos);
        fieldItself.put(pos, obj);
    }

    public iObjectOnField getObject(iDot pos) {
        checkPos(pos);
        if (fieldItself.containsKey(pos)) {
            return fieldItself.get(pos);
        }
        // FIXME: fix this!!!
        // it will return null, if pos is empty
        return null;
    }

    public void removeObject(iDot pos) {
        checkPos(pos);
        removeObjectFromField(pos);
    }

    public void putIterableObject(String name, iIterableObjectOnField obj) {
        iterableObjects.put(name, obj);
    }

    public iIterableObjectOnField getIterableObjectOnField(String name) {
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

    private void checkPos(iDot pos) {
        if (pos.getX() < xMin || pos.getX() > xMax || pos.getY() < yMin || pos.getY() > yMax) {
            // TODO: raise a normal exeption
        }
    }

    private void removeObjectFromField(iDot pos) {
        fieldItself.remove(pos);
    }

    @Override
    public iIterableObjectOnField getIterableObject(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    // private void
    // removeIterableObjectFromIterableObjectsList(iIterableObjectOnField obj) {
    // iterableObjects.remove(obj);
    // }
}