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
    private final HashMap<IntegerPosition2D, OBJ> areaItself;

    public AbstractArea() {
        areaItself = new HashMap<>();
    }

    @Override
    public OBJ get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }
        return areaItself.get(pos);
    }

    @Override
    public void set(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
        areaItself.put(pos, obj);
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

        areaItself.remove(pos);
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            areaItself.remove(pos);
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

        place(newPos, get(oldPos));
        remove(oldPos);
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws PositionCannotExistInAreaException {
        if (positionIsBusy(oldPos) && positionIsEmpty(newPos)) {
            try {
                tryPlace(newPos, get(oldPos));
                remove(newPos);
            } catch (EmptyPositionException e) {
                return;
            }
        }
    }

    @Override
    public void relocateToEverywhere(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(oldPos)) {
            throw new EmptyPositionException(oldPos);
        }

        set(newPos, get(oldPos));
        remove(oldPos);
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return !areaItself.containsKey(pos);
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return areaItself.containsKey(pos);
    }
}
