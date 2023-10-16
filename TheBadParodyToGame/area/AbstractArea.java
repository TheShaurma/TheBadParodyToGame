package TheBadParodyToGame.area;

import java.util.HashMap;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

// TODO: adapt for multi-thread
/**
 * DIDN'T adapted for multi-thread using.
 */
public abstract class AbstractArea<OBJ extends ObjectInArea> implements Area<OBJ> {
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
    public void place(IntegerPosition2D pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException {
        if (areaItself.posIsBusy(pos)) {
            throw new BusyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            set(pos, obj);
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
        if (positionIsBusy(pos)) {
            set(pos, obj);
        }
    }

    @Override
    public void remove(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }

        areaItself.del(pos);
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            areaItself.del(pos);
        }
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(oldPos)) {
            throw new EmptyPositionException(oldPos);
        }
        if (positionIsBusy(newPos)) {
            throw new BusyPositionException(newPos);
        }

        OBJ obj = areaItself.get(oldPos);
        areaItself.del(oldPos);
        areaItself.set(newPos, obj);
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws PositionCannotExistInAreaException {
        if (positionIsBusy(oldPos) && positionIsEmpty(newPos)) {
            OBJ obj;
            try {
                obj = areaItself.get(oldPos);
            } catch (EmptyPositionException e) {
                return;
            }

            areaItself.del(oldPos);
            areaItself.set(newPos, obj);
        }
    }

    @Override
    public void relocateToEverywhere(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(oldPos)) {
            throw new EmptyPositionException(oldPos);
        }

        OBJ obj = areaItself.get(oldPos);
        areaItself.del(oldPos);
        areaItself.set(newPos, obj);
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return areaItself.posIsEmpty(pos);
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return areaItself.posIsBusy(pos);
    }

    /**
     * AreaItself
     */
    private class AreaItself {
        // Use areaItself.get(x).get(y) to get object
        private HashMap<Integer, HashMap<Integer, OBJ>> areaItself = new HashMap<>();

        public void set(IntegerPosition2D pos, OBJ obj) {
            int x = pos.getX();
            int y = pos.getY();

            if (!areaItself.containsKey(x)) {
                areaItself.put(x, new HashMap<>());
            }

            areaItself.get(x).put(y, obj);
        }

        public void del(IntegerPosition2D pos) {
            areaItself.get(pos.getX()).remove(pos.getY());
        }

        public OBJ get(IntegerPosition2D pos) throws EmptyPositionException {
            if (posIsEmpty(pos)) {
                throw new EmptyPositionException(pos);
            }

            if (!areaItself.containsKey(pos.getX())) {
                areaItself.put(pos.getX(), new HashMap<>());
            }

            return areaItself.get(pos.getX()).get(pos.getY());
        }

        public boolean posIsEmpty(IntegerPosition2D pos) {
            return !posIsBusy(pos);
        }

        public boolean posIsBusy(IntegerPosition2D pos) {
            int x = pos.getX();
            int y = pos.getY();
            if (areaItself.containsKey(x)) {
                if (areaItself.get(x).containsKey(y)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
