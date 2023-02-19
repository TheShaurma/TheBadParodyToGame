package Tests.area;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.abstractions.CheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public class CheckeredAreaStub implements CheckeredAreaContainsAll {
    private AreaItself areaItself = new AreaItself();

    @Override
    public ObjectInArea get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return areaItself.get(pos);
    }

    @Override
    public void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.set(pos, obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.del(pos);
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        try {
            remove(pos);
        } catch (EmptyPositionException e) {
        }
    }

    @Override
    public void place(IntegerPosition2D pos, ObjectInArea obj)
            throws BusyPositionException, PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            throw new BusyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        try {
            place(pos, obj);
        } catch (BusyPositionException e) {
        }
    }

    @Override
    public void replace(IntegerPosition2D pos, ObjectInArea obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        try {
            replace(pos, obj);
        } catch (EmptyPositionException e) {
        }
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(oldPos)) {
            throw new EmptyPositionException(oldPos);
        } else if (positionIsBusy(newPos)) {
            throw new BusyPositionException(newPos);
        }

        ObjectInArea obj = get(oldPos);
        remove(oldPos);
        set(newPos, obj);
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws PositionCannotExistInAreaException {
        try {
            relocate(oldPos, newPos);
        } catch (EmptyPositionException e) {
        } catch (BusyPositionException e) {
        }
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsEmpty(pos);
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsBusy(pos);
    }

    @Override
    public Iterator<IntegerPosition2D> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}

/**
 * AreaItself
 * 
 * This is adaptor for HashMap.
 */
class AreaItself implements Serializable {
    private static final long serialVersionUID = 2L;
    // Use area.get(x).get(y) to get object from area.
    private HashMap<Integer, HashMap<Integer, ObjectInArea>> area;

    public AreaItself() {
        area = new HashMap<>();
    }

    public ObjectInArea get(IntegerPosition2D pos) throws EmptyPositionException {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            throw new EmptyPositionException(pos);
        } else {
            return area.get(x).get(y);
        }
    }

    public void set(IntegerPosition2D pos, ObjectInArea obj) {
        int x = pos.getX();
        int y = pos.getY();

        try {
            area.get(x).put(y, obj);
        } catch (NullPointerException e) {
            area.put(x, new HashMap<>());
            area.get(x).put(y, obj);
        }
    }

    public void del(IntegerPosition2D pos) throws EmptyPositionException {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            throw new EmptyPositionException(pos);
        }

        area.get(x).remove(y);
    }

    public boolean positionIsEmpty(IntegerPosition2D pos) {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean positionIsBusy(IntegerPosition2D pos) {
        return !positionIsEmpty(pos);
    }
}
