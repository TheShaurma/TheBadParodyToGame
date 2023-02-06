package TheBadParodyToGame.area;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// TODO: docs
public abstract class AbstractCheckeredArea<OBJ extends ObjectInArea> implements CheckeredArea<OBJ> {
    private AreaItself<OBJ> areaItself = new AreaItself<>();

    @Override
    public OBJ get(IntegerPosition2D pos) throws PositionException {
        return areaItself.get(pos);
    }

    @Override
    public void set(IntegerPosition2D pos, OBJ obj) throws PositionException {
        areaItself.set(pos, obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws PositionException {
        areaItself.del(pos);
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionException {
        if (positionIsBusy(pos)) {
            remove(pos);
        }
    }

    @Override
    public void place(IntegerPosition2D pos, OBJ obj) throws PositionException {
        if (positionIsBusy(pos)) {
            throw new BusyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, OBJ obj) throws PositionException {
        if (positionIsEmpty(pos)) {
            place(pos, obj);
        }
    }

    @Override
    public void replace(IntegerPosition2D pos, OBJ obj) throws PositionException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, OBJ obj) throws PositionException {
        if (positionIsBusy(pos)) {
            replace(pos, obj);
        }
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        if (positionIsEmpty(oldPos)) {
            throw new EmptyPositionException(oldPos);
        } else if (positionIsBusy(newPos)) {
            throw new BusyPositionException(newPos);
        }

        OBJ obj = get(oldPos);
        remove(oldPos);
        set(newPos, obj);
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        if (positionIsBusy(oldPos) && positionIsEmpty(newPos)) {
            relocate(oldPos, newPos);
        }
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

// FIXME: Bad Code!
/**
 * AreaItself
 * 
 * This is adaptor for HashMap.
 */
class AreaItself<OBJ extends ObjectInArea> implements Serializable {
    private static final long serialVersionUID = 2L;
    // Use area.get(x).get(y) to get object from area.
    private Map<Integer, HashMap<Integer, OBJ>> area;

    public AreaItself() {
        area = new HashMap<>();
    }

    public OBJ get(IntegerPosition2D pos) throws EmptyPositionException {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            throw new EmptyPositionException(pos);
        } else {
            return area.get(x).get(y);
        }
    }

    public void set(IntegerPosition2D pos, OBJ obj) {
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