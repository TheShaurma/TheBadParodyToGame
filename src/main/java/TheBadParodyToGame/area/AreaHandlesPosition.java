package TheBadParodyToGame.area;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

public abstract class AreaHandlesPosition<OBJ extends ObjectInArea>
        extends AreaChecksPosition<OBJ> {

    @Override
    public OBJ get(Position pos)
            throws EmptyPositionException,
            PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        return super.get(pos);
    }

    @Override
    public void set(Position pos, OBJ obj)
            throws PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        super.set(pos, obj);
    }

    @Override
    public void place(Position pos, OBJ obj)
            throws BusyPositionException,
            PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        super.place(pos, obj);
    }

    @Override
    public void tryPlace(Position pos, OBJ obj)
            throws PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        super.tryPlace(pos, obj);
    }

    @Override
    public void replace(Position pos, OBJ obj)
            throws EmptyPositionException,
            PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        super.replace(pos, obj);
    }

    @Override
    public void tryReplace(Position pos, OBJ obj)
            throws PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        super.tryReplace(pos, obj);
    }

    @Override
    public void remove(Position pos)
            throws EmptyPositionException,
            PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        super.remove(pos);
    }

    @Override
    public void tryRemove(Position pos)
            throws PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        super.tryRemove(pos);
    }

    @Override
    public void relocate(Position oldPos, Position newPos)
            throws EmptyPositionException,
            BusyPositionException,
            PositionCannotExistInAreaException {
        oldPos = handlePosition(oldPos);
        newPos = handlePosition(newPos);
        super.relocate(oldPos, newPos);
    }

    @Override
    public void tryRelocate(Position oldPos, Position newPos)
            throws PositionCannotExistInAreaException {
        oldPos = handlePosition(oldPos);
        newPos = handlePosition(newPos);
        super.tryRelocate(oldPos, newPos);
    }

    @Override
    public void relocateToEverywhere(Position oldPos, Position newPos)
            throws EmptyPositionException,
            PositionCannotExistInAreaException {
        oldPos = handlePosition(oldPos);
        newPos = handlePosition(newPos);
        super.relocateToEverywhere(oldPos, newPos);
    }

    @Override
    public boolean positionIsEmpty(Position pos)
            throws PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        return super.positionIsEmpty(pos);
    }

    @Override
    public boolean positionIsBusy(Position pos)
            throws PositionCannotExistInAreaException {
        pos = handlePosition(pos);
        return super.positionIsBusy(pos);
    }

    /**
     * Handle position then returns handled position.
     * 
     * @param pos
     * @return handled position
     */
    public abstract Position handlePosition(Position pos);
}
