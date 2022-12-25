package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// TODO: write documentation fo ObjectManager
public abstract class ObjectManager {
    private IntegerPosition2D currentPosition;
    private final CheckeredArea area;
    private final ObjectInArea object;

    public ObjectManager(IntegerPosition2D pos, CheckeredArea area, ObjectInArea obj) throws PositionException {
        this.area = area;
        currentPosition = pos;
        object = obj;

        checkObjectAvailability();
    }

    protected void moveObjectUp() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() + 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectDown() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() - 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectLeft() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY();
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectRight() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY();
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectUpLeft() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY() + 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectUpRight() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY() + 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectDownLeft() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY() - 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectDownRight() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY() - 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    protected void moveObjectToPosition(IntegerPosition2D newPos) throws PositionException {
        checkObjectAvailability();

        CheckeredArea area = getArea();
        IntegerPosition2D oldPos = getCurrentPosition();

        try {
            area.relocate(oldPos, newPos);
        } catch (BusyPositionException e) {
            throw new CannotMoveObjectException(newPos, getObject());
        }

        setCurrentPosition(newPos);
    }

    protected final CheckeredArea getArea() {
        return area;
    }

    protected final ObjectInArea getObject() {
        return object;
    }

    protected final IntegerPosition2D getCurrentPosition() {
        return currentPosition;
    }

    private void setCurrentPosition(IntegerPosition2D pos) {
        currentPosition = pos;
    }

    private void checkObjectAvailability() throws LostObjectException {
        CheckeredArea area = getArea();
        ObjectInArea obj = getObject();
        IntegerPosition2D pos = getCurrentPosition();
        ObjectInArea objInPos;

        try {
            objInPos = area.get(pos);
        } catch (PositionException e) {
            throw new LostObjectException(e.getPosition(), obj);
        }

        if (obj != objInPos) {
            throw new LostObjectException(pos, obj);
        }
    }
}
