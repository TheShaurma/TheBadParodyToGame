package TheBadParodyToGame.area;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

/**
 * When you call {@code get}, {@code set}, {@code place},
 * {@code tryPlace}, {@code replace}, {@code tryReplace},
 * {@code remove}, {@code tryRemove}, {@code relocate},
 * {@code tryRelocate}, {@code relocateToEverywhere},
 * {@code positionItEmpty}, {@code positionIsBusy} methods,
 * class calls {@code checkPosition()} method.
 */
public abstract class AreaChecksPosition<OBJ extends ObjectInArea>
        extends AbstractArea<OBJ> {
    @Override
    public OBJ get(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        checkPosition(pos);
        return super.get(pos);
    }

    @Override
    public void set(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.set(pos, obj);
    }

    @Override
    public void place(Position pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException {
        checkPosition(pos);
        super.place(pos, obj);
    }

    @Override
    public void tryPlace(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.tryPlace(pos, obj);
    }

    @Override
    public void replace(Position pos, OBJ obj) throws EmptyPositionException, PositionCannotExistInAreaException {
        checkPosition(pos);
        super.replace(pos, obj);
    }

    @Override
    public void tryReplace(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.tryReplace(pos, obj);
    }

    @Override
    public void remove(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        checkPosition(pos);
        super.remove(pos);
    }

    @Override
    public void tryRemove(Position pos) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.tryRemove(pos);
    }

    @Override
    public void relocate(Position oldPos, Position newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        checkPosition(oldPos);
        checkPosition(newPos);
        super.relocate(oldPos, newPos);
    }

    @Override
    public void tryRelocate(Position oldPos, Position newPos) throws PositionCannotExistInAreaException {
        checkPosition(oldPos);
        checkPosition(newPos);
        super.tryRelocate(oldPos, newPos);
    }

    @Override
    public void relocateToEverywhere(Position oldPos, Position newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        checkPosition(oldPos);
        checkPosition(newPos);
        super.relocateToEverywhere(oldPos, newPos);
    }

    @Override
    public boolean positionIsEmpty(Position pos) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        return super.positionIsEmpty(pos);
    }

    @Override
    public boolean positionIsBusy(Position pos) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        return super.positionIsBusy(pos);
    }

    /**
     * @param pos which will be checked in method
     * @throws PositionCannotExistInAreaException if any problems
     *                                            were detected.
     */
    protected abstract void checkPosition(Position pos) throws PositionCannotExistInAreaException;
}
