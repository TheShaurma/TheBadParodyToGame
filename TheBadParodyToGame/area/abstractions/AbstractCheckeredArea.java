package TheBadParodyToGame.area.abstractions;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

/**
 * This is abstract class implements of CheckeredArea.
 * OBJ showld extend from ObjectInArea.
 */
public abstract class AbstractCheckeredArea<OBJ extends ObjectInArea> implements CheckeredArea<OBJ> {
    private AreaItself areaItself = new AreaItself();

    @Override
    public OBJ get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return areaItself.get(pos);
    }

    @Override
    public void set(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
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
    public void place(IntegerPosition2D pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            throw new BusyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
        try {
            place(pos, obj);
        } catch (BusyPositionException e) {
        }
    }

    @Override
    public void replace(IntegerPosition2D pos, OBJ obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
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

        OBJ obj = get(oldPos);
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
        return new AreaIterator();
    }

    private class AreaIterator implements Iterator<IntegerPosition2D> {
        private Iterator<Integer> xIterator;
        private Iterator<Integer> yIterator;
        private int currentX;

        public AreaIterator() {
            xIterator = areaItself.area.keySet().iterator();
            currentX = xIterator.next();

            yIterator = areaItself.area.get(currentX).keySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return xIterator.hasNext();
        }

        @Override
        public IntegerPosition2D next() {
            int x, y;

            if (yIterator.hasNext()) {
                x = currentX;
                y = yIterator.next();
            } else {
                x = xIterator.next();
                currentX = x;

                yIterator = areaItself.area.get(x).keySet().iterator();
                y = yIterator.next();
            }

            return new GameIntegerPosition2D(x, y);
        }
    }

    // FIXME: Bad Code!
    /**
     * AreaItself
     * 
     * This is adaptor for HashMap.
     */
    private class AreaItself implements Serializable {
        private static final long serialVersionUID = 2L;
        // Use area.get(x).get(y) to get object from area.
        private Map<Integer, Map<Integer, OBJ>> area;

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
}