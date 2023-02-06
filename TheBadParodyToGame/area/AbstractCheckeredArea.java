package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public abstract class AbstractCheckeredArea<OBJ extends ObjectInArea> implements CheckeredArea<OBJ> {

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
    public void tryRemove(IntegerPosition2D pos) throws PositionException {
        if (positionIsBusy(pos)) {
            remove(pos);
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
}
