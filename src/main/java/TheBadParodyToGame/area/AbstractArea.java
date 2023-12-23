package TheBadParodyToGame.area;

import java.util.HashMap;
import java.util.Iterator;

import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

// TODO: adapt for multi-thread
/**
 * DIDN'T adapted for multi-thread using.
 */
public abstract class AbstractArea<OBJ extends ObjectInArea> implements Area<OBJ> {
    private final HashMap<Position, OBJ> areaItself;

    public AbstractArea() {
        areaItself = new HashMap<>();
    }

    @Override
    public OBJ get(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }
        return areaItself.get(pos);
    }

    @Override
    public void set(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        areaItself.put(pos, obj);
    }

    @Override
    public void place(Position pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            throw new BusyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryPlace(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            set(pos, obj);
        }
    }

    @Override
    public void replace(Position pos, OBJ obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryReplace(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            set(pos, obj);
        }
    }

    @Override
    public void remove(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }

        areaItself.remove(pos);
    }

    @Override
    public void tryRemove(Position pos) throws PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            areaItself.remove(pos);
        }
    }

    @Override
    public void relocate(Position oldPos, Position newPos)
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
    public void tryRelocate(Position oldPos, Position newPos)
            throws PositionCannotExistInAreaException {
        if (positionIsBusy(oldPos) && positionIsEmpty(newPos)) {
            try {
                tryPlace(newPos, get(oldPos));
                remove(oldPos);
            } catch (EmptyPositionException e) {
                return;
            }
        }
    }

    @Override
    public void relocateToEverywhere(Position oldPos, Position newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(oldPos)) {
            throw new EmptyPositionException(oldPos);
        }

        set(newPos, get(oldPos));
        remove(oldPos);
    }

    @Override
    public boolean positionIsEmpty(Position pos) throws PositionCannotExistInAreaException {
        return !areaItself.containsKey(pos);
    }

    @Override
    public boolean positionIsBusy(Position pos) throws PositionCannotExistInAreaException {
        return areaItself.containsKey(pos);
    }

    @Override
    public Iterator<Position> iterator() {
        return areaItself.keySet().iterator();
    }
}
