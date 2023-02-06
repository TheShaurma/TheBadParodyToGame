package TheBadParodyToGame.area;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class GameArea extends AbstractCheckeredArea<ObjectInArea> implements CheckeredAreaContainsAll, Serializable {
    private static final long serialVersionUID = 1L;
    private AreaItself areaItself = new AreaItself();

    @Override
    public ObjectInArea get(IntegerPosition2D pos) throws PositionException {
        return areaItself.get(pos);
    }

    @Override
    public void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        areaItself.set(pos, obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws PositionException {
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
 * 
 * This is adaptor for HashMap.
 */
class AreaItself implements Serializable {
    private static final long serialVersionUID = 2L;
    // Use area.get(x).get(y) to get object from area.
    private Map<Integer, HashMap<Integer, ObjectInArea>> area;

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
