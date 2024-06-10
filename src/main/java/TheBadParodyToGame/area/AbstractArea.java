package TheBadParodyToGame.area;

import java.util.HashMap;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

// TODO: adapt for multi-thread
// TODO: equals and hashCode tests
/**
 * DIDN'T adapted for multi-thread using.
 */
public abstract class AbstractArea<OBJ extends ObjectInArea>
        implements Area<OBJ> {
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
    public Iterable<Position> getAllBusyPositions() {
        return areaItself.keySet();
    }

    @Override
    public Iterable<OBJ> getAllObjects() {
        return areaItself.values();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ConstantArea<?>)) {
            return false;
        } else {

            ConstantArea<?> otherArea = (ConstantArea<?>) obj;
            try {

                for (Position pos : getAllBusyPositions()) {
                    if (otherArea.positionIsEmpty(pos) ||
                            !get(pos).equals(otherArea.get(pos))) {
                        return false;
                    }

                }

                for (Position pos : otherArea.getAllBusyPositions()) {
                    if (positionIsEmpty(pos) ||
                            !get(pos).equals(otherArea.get(pos))) {
                        return false;
                    }
                }

            } catch (PositionCannotExistInAreaException | EmptyPositionException e) {
                return false;
            }

            return true;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Position pos : getAllBusyPositions()) {
            result += pos.getX();
            result += pos.getY();
        }

        return result;
    }
}