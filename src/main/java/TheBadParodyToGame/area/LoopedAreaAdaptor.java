package TheBadParodyToGame.area;

import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

// TODO: write docs
// TODO: create tests
public class LoopedAreaAdaptor<OBJ extends ObjectInArea> extends ConstantLoopedArea<OBJ> implements Area<OBJ> {
    private final Area<OBJ> areaItself;

    public LoopedAreaAdaptor(Area<OBJ> area, int xMax, int yMax) {
        super(area, xMax, yMax);
        areaItself = area;
    }

    @Override
    public void set(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        areaItself.set(convertPos(pos), obj);
    }

    @Override
    public void place(Position pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException {
        areaItself.place(convertPos(pos), obj);
    }

    @Override
    public void tryPlace(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        areaItself.tryPlace(convertPos(pos), obj);
    }

    @Override
    public void replace(Position pos, OBJ obj) throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.replace(convertPos(pos), obj);
    }

    @Override
    public void tryReplace(Position pos, OBJ obj) throws PositionCannotExistInAreaException {
        areaItself.tryReplace(convertPos(pos), obj);
    }

    @Override
    public void remove(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.remove(pos);
    }

    @Override
    public void tryRemove(Position pos) throws PositionCannotExistInAreaException {
        areaItself.tryRemove(convertPos(pos));
    }

    @Override
    public void relocate(Position oldPos, Position newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        areaItself.relocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void tryRelocate(Position oldPos, Position newPos) throws PositionCannotExistInAreaException {
        areaItself.tryRelocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void relocateToEverywhere(Position oldPos, Position newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.relocateToEverywhere(convertPos(oldPos), convertPos(newPos));
    }
}
