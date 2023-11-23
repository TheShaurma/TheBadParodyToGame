package TheBadParodyToGame.area;

import java.util.HashMap;
import java.util.Iterator;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public class AreaStub implements AreaContainsAll {
    private AreaItself areaItself = new AreaItself();

    @Override
    public ObjectInArea get(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return areaItself.get(pos);
    }

    @Override
    public void set(Position pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.set(pos, obj);
    }

    @Override
    public void remove(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.del(pos);
    }

    @Override
    public void tryRemove(Position pos) throws PositionCannotExistInAreaException {
        try {
            remove(pos);
        } catch (EmptyPositionException e) {
        }
    }

    @Override
    public void place(Position pos, ObjectInArea obj)
            throws BusyPositionException, PositionCannotExistInAreaException {
        if (positionIsBusy(pos)) {
            throw new BusyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryPlace(Position pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        try {
            place(pos, obj);
        } catch (BusyPositionException e) {
        }
    }

    @Override
    public void replace(Position pos, ObjectInArea obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        if (positionIsEmpty(pos)) {
            throw new EmptyPositionException(pos);
        }

        set(pos, obj);
    }

    @Override
    public void tryReplace(Position pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        try {
            replace(pos, obj);
        } catch (EmptyPositionException e) {
        }
    }

    @Override
    public void relocate(Position oldPos, Position newPos)
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
    public void tryRelocate(Position oldPos, Position newPos)
            throws PositionCannotExistInAreaException {
        try {
            relocate(oldPos, newPos);
        } catch (EmptyPositionException e) {
        } catch (BusyPositionException e) {
        }
    }

    @Override
    public boolean positionIsEmpty(Position pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsEmpty(pos);
    }

    @Override
    public boolean positionIsBusy(Position pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsBusy(pos);
    }

    @Override
    public void relocateToEverywhere(Position oldPos, Position newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'relocateToEverywhere'");
    }

    @Override
    public Iterator<Position> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}

/**
 * AreaItself
 * 
 * This is adaptor for HashMap.
 */
class AreaItself {
    // Use area.get(x).get(y) to get object from area.
    private HashMap<Integer, HashMap<Integer, ObjectInArea>> area;

    public AreaItself() {
        area = new HashMap<>();
    }

    public ObjectInArea get(Position pos) throws EmptyPositionException {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            throw new EmptyPositionException(pos);
        } else {
            return area.get(x).get(y);
        }
    }

    public void set(Position pos, ObjectInArea obj) {
        int x = pos.getX();
        int y = pos.getY();

        try {
            area.get(x).put(y, obj);
        } catch (NullPointerException e) {
            area.put(x, new HashMap<>());
            area.get(x).put(y, obj);
        }
    }

    public void del(Position pos) throws EmptyPositionException {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            throw new EmptyPositionException(pos);
        }

        area.get(x).remove(y);
    }

    public boolean positionIsEmpty(Position pos) {
        int x = pos.getX();
        int y = pos.getY();

        if (area.get(x) == null || area.get(x).get(y) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean positionIsBusy(Position pos) {
        return !positionIsEmpty(pos);
    }
}
