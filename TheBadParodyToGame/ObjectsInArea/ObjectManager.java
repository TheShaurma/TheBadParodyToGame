package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

/**
 * ObjectManager is abstract class with logic to move one object in
 * CheckeredArea.
 */
@Deprecated
public abstract class ObjectManager {
    private IntegerPosition2D currentPosition;
    private final CheckeredArea area;
    private final ObjectInArea object;

    /**
     * Constructor of ObjectManager.
     * obj should be in area at pos already.
     *
     * @param pos
     * @param area
     * @param obj
     * @throws PositionException
     */
    public ObjectManager(IntegerPosition2D pos, CheckeredArea area, ObjectInArea obj) throws PositionException {
        this.area = area;
        currentPosition = pos;
        object = obj;

        checkObjectAvailability();
    }

    /**
     * Move object 1 step up.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX();
     * int newY = oldPos.getY() + 1;
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectUp() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() + 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object 1 step down.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX();
     * int newY = oldPos.getY() - 1;
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectDown() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() - 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object 1 step left.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX() + 1;
     * int newY = oldPos.getY();
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectLeft() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY();
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object 1 step right.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX() + 1;
     * int newY = oldPos.getY();
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectRight() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY();
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object 1 step up and left.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX() - 1;
     * int newY = oldPos.getY() + 1;
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectUpLeft() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY() + 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object 1 step up and right.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX() + 1;
     * int newY = oldPos.getY() + 1;
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectUpRight() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY() + 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object 1 step down and left.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX() - 1;
     * int newY = oldPos.getY() - 1;
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectDownLeft() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY() - 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object 1 step down and right.
     * 
     * Logic of generating of new position:
     * {@code
     * int newX = oldPos.getX() + 1;
     * int newY = oldPos.getY() - 1;
     * }
     * 
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
    protected void moveObjectDownRight() throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY() - 1;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveObjectToPosition(newPos);
    }

    /**
     * Move object to assigned position in checkered area.
     * 
     * @param pos
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     */
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

    /**
     * This method is final.
     * 
     * @return Area where object is.
     */
    protected final CheckeredArea getArea() {
        return area;
    }

    /**
     * This method is final.
     * 
     * @return object where object is.
     */
    protected final ObjectInArea getObject() {
        return object;
    }

    /**
     * This method is final.
     * 
     * @return position where object is for now.
     */
    protected final IntegerPosition2D getCurrentPosition() {
        return currentPosition;
    }

    private void setCurrentPosition(IntegerPosition2D pos) {
        currentPosition = pos;
    }

    private void checkObjectAvailability() throws PositionException {
        CheckeredArea area = getArea();
        ObjectInArea obj = getObject();
        IntegerPosition2D pos = getCurrentPosition();
        ObjectInArea objInPos;

        try {
            objInPos = area.get(pos);
        } catch (EmptyPositionException e) {
            throw new LostObjectException(e.getPosition(), obj);
        }

        if (obj != objInPos) {
            throw new LostObjectException(pos, obj);
        }
    }
}
