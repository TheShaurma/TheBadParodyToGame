package game.area;

import java.io.Serializable;
import java.util.HashMap;

import game.ObjectsInArea.ObjectInArea;
import game.area.position.BusyPositionException;
import game.area.position.EmptyPositionException;
import game.area.position.IntegerPosition2D;
import game.area.position.PositionException;

public class GameArea implements Area<IntegerPosition2D>, Serializable {
    private static final long serialVersionUID = 1L;
    private AreaItself areaItself = new AreaItself();

    // TODO: more concrete documentation
    @Override
    public synchronized ObjectInArea get(IntegerPosition2D pos) throws PositionException {
        return areaItself.get(pos);
    }

    @Override
    public synchronized void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        areaItself.set(pos, obj);
    }

    @Override
    public synchronized void place(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        if (areaItself.positionIsBusy(pos)) {
            throw new BusyPositionException();
        }

        areaItself.set(pos, obj);
    }

    @Override
    public synchronized void replace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        if (areaItself.positionIsEmpty(pos)) {
            throw new EmptyPositionException();
        }

        areaItself.set(pos, obj);
    }

    @Override
    public synchronized void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        if (areaItself.positionIsEmpty(oldPos)) {
            throw new EmptyPositionException();
        } else if (areaItself.positionIsBusy(newPos)) {
            throw new BusyPositionException();
        }

        ObjectInArea obj = areaItself.get(oldPos);
        areaItself.del(oldPos);
        areaItself.set(newPos, obj);
    }

    @Override
    public synchronized void remove(IntegerPosition2D pos) throws PositionException {
        areaItself.del(pos);
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) {
        return areaItself.positionIsEmpty(pos);
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) {
        return areaItself.positionIsBusy(pos);
    }

}

/**
 * AreaItself
 */
class AreaItself implements Serializable {
    private static final long serialVersionUID = 2L;
    private HashMap<Integer, HashMap<Integer, ObjectInArea>> area;

    public AreaItself() {
        area = new HashMap<>();
    }

    public synchronized ObjectInArea get(IntegerPosition2D pos) throws EmptyPositionException {
        int x = pos.getX();
        int y = pos.getY();

        try {
            return area.get(x).get(y);
        } catch (NullPointerException e) {
            throw new EmptyPositionException();
        }
    }

    public synchronized void set(IntegerPosition2D pos, ObjectInArea obj) {
        int x = pos.getX();
        int y = pos.getY();

        try {
            area.get(x).put(y, obj);
        } catch (NullPointerException e) {
            area.put(x, new HashMap<>());
            area.get(x).put(y, obj);
        }
    }

    public synchronized void del(IntegerPosition2D pos) throws EmptyPositionException {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            throw new EmptyPositionException();
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
