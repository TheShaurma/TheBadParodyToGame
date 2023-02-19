package TheBadParodyToGame.area.abstractions;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public abstract class CheckeredAreaWithBorders<OBJ extends ObjectInArea> extends AbstractCheckeredArea<OBJ> {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    public CheckeredAreaWithBorders(IntegerPosition2D minPos, IntegerPosition2D maxPos) {
        minX = Math.min(minPos.getX(), maxPos.getX());
        maxX = Math.max(minPos.getX(), maxPos.getX());
        minY = Math.min(minPos.getY(), maxPos.getY());
        maxY = Math.max(minPos.getY(), maxPos.getY());
    }

    @Override
    public void set(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.set(pos, obj);
    }

    @Override
    public void place(IntegerPosition2D pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException {
        checkPosition(pos);
        super.place(pos, obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.tryPlace(pos, obj);
    }

    @Override
    public void replace(IntegerPosition2D pos, OBJ obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        checkPosition(pos);
        super.replace(pos, obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.tryReplace(pos, obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        checkPosition(pos);
        super.remove(pos);
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        checkPosition(pos);
        super.tryRemove(pos);
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        checkPosition(oldPos);
        checkPosition(newPos);
        super.relocate(oldPos, newPos);
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws PositionCannotExistInAreaException {
        checkPosition(oldPos);
        checkPosition(newPos);
        super.tryRelocate(oldPos, newPos);
    }

    protected int getMinX() {
        return minX;
    }

    protected int getMaxX() {
        return maxX;
    }

    protected int getMinY() {
        return minY;
    }

    protected int getMaxY() {
        return maxY;
    }

    protected void checkPosition(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        if (!positionInBorders(pos)) {
            throw new PositionCannotExistInAreaException(pos);
        }
    }

    protected boolean positionInBorders(IntegerPosition2D pos) {
        int x = pos.getX();
        int y = pos.getY();

        if (x < getMinX() || x > getMaxX() || y < getMinY() || y > getMaxY()) {
            return false;
        } else {
            return true;
        }
    }
}
