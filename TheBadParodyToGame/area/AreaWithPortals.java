package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public class AreaWithPortals extends GameArea {
    private PortalsArea portalsArea = new PortalsArea();

    public PortalsArea getPortalsArea() {
        return portalsArea;
    }

    @Override
    public ObjectInArea get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return super.get(convertPositionLookingPortals(pos));
    }

    @Override
    public void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        super.set(convertPositionLookingPortals(pos), obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        super.remove(convertPositionLookingPortals(pos));
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        super.tryRemove(convertPositionLookingPortals(pos));
    }

    @Override
    public void place(IntegerPosition2D pos, ObjectInArea obj)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super.place(convertPositionLookingPortals(pos), obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        super.tryPlace(convertPositionLookingPortals(pos), obj);
    }

    @Override
    public void replace(IntegerPosition2D pos, ObjectInArea obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        super.replace(convertPositionLookingPortals(pos), obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        super.tryReplace(convertPositionLookingPortals(pos), obj);
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        super.relocate(
                convertPositionLookingPortals(oldPos),
                convertPositionLookingPortals(newPos));
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws PositionCannotExistInAreaException {
        super.tryRelocate(
                convertPositionLookingPortals(oldPos),
                convertPositionLookingPortals(newPos));
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return super.positionIsEmpty(convertPositionLookingPortals(pos));
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return super.positionIsBusy(convertPositionLookingPortals(pos));
    }

    protected IntegerPosition2D convertPositionLookingPortals(IntegerPosition2D pos)
            throws PositionCannotExistInAreaException {
        try {
            return portalsArea.get(pos).getTeleportPosition();
        } catch (EmptyPositionException e) {
            return pos;
        }
    }

    protected final boolean portalInPosition(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return portalsArea.positionIsBusy(pos);
    }
}
