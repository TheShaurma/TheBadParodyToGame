package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.CheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public abstract class MovingObject implements ObjectInArea {
    private final CheckeredAreaContainsAll area;
    private IntegerPosition2D startPos;

    /**
     * Call {@code area.place(pos, this)} after creating.
     * 
     * @param area where object will be after creating;
     * @param pos  in {@code area} where object will be after creating;
     * @throws BusyPositionException if {@code pos} is empty;
     * @throws PositionException     if {@code pos} can't exist in {@code area}.
     */
    public MovingObject(CheckeredAreaContainsAll area, IntegerPosition2D pos) throws PositionException {
        this.area = area;
        startPos = pos;

        area.place(pos, this);
    }

    @Override
    public String toString() {
        return "MovingObject(" + getCurrentPosition() + ")";
    }

    /**
     * Move object to 1 in up.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up is busy.
     */
    protected void moveUp() throws PositionException {
        moveUp(1);
    }

    /**
     * Move object to 1 in down.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down is busy.
     */
    protected void moveDown() throws PositionException {
        moveDown(1);
    }

    /**
     * Move object to 1 in left.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in left is busy.
     */
    protected void moveLeft() throws PositionException {
        moveLeft(1);
    }

    /**
     * Move object to 1 in right.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in right is busy.
     */
    protected void moveRight() throws PositionException {
        moveRight(1);
    }

    /**
     * Move object to 1 in up and left.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up of left is busy.
     */
    protected void moveUpLeft() throws PositionException {
        moveUpLeft(1);
    }

    /**
     * Move object to 1 in up and right.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up of right is busy.
     */
    protected void moveUpRight() throws PositionException {
        moveUpRight(1);
    }

    /**
     * Move object to 1 in down and left.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down of left is busy.
     */
    protected void moveDownLeft() throws PositionException {
        moveDownLeft(1);
    }

    /**
     * Move object to 1 in down and right.
     * 
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down of right is busy.
     */
    protected void moveDownRight() throws PositionException {
        moveDownRight(1);
    }

    /**
     * Move object to {@code n} in up.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up is busy.
     */
    protected void moveUp(int n) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() + n;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in down.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down is busy.
     */
    protected void moveDown(int n) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() - n;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in left.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in left is busy.
     */
    protected void moveLeft(int n) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - n;
        int newY = oldPos.getY();
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in right.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in right is busy.
     */
    protected void moveRight(int n) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + n;
        int newY = oldPos.getY();
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in up and left.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up of left is busy.
     */
    protected void moveUpLeft(int n) throws PositionException {
        moveUpLeft(n, n);
    }

    /**
     * Move object to {@code n} in up and right.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up of right is busy.
     */
    protected void moveUpRight(int n) throws PositionException {
        moveUpRight(n, n);
    }

    /**
     * Move object to {@code n} in down and left.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down of left is busy.
     */
    protected void moveDownLeft(int n) throws PositionException {
        moveDownLeft(n, n);
    }

    /**
     * Move object to {@code n} in down and right.
     * 
     * @param n
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down of right is busy.
     */
    protected void moveDownRight(int n) throws PositionException {
        moveDownRight(n, n);
    }

    /**
     * Move object to {@code inUp} in up and {@code inLeft} in left.
     * 
     * @param inUp
     * @param inLeft
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up of left is busy.
     */
    protected void moveUpLeft(int inUp, int inLeft) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - inLeft;
        int newY = oldPos.getY() + inUp;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code inUp} in up and {@code inRight} in right.
     * 
     * @param inUp
     * @param inRight
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in up of right is busy.
     */
    protected void moveUpRight(int inUp, int inRight) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + inRight;
        int newY = oldPos.getY() + inUp;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code inDown} in down and {@code inLeft} in left.
     * 
     * @param inDown
     * @param inLeft
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down of left is busy.
     */
    protected void moveDownLeft(int inDown, int inLeft) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() - inLeft;
        int newY = oldPos.getY() - inDown;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code inDown} in down and {@code inRight} in right.
     * 
     * @param inDown
     * @param inLeft
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if pos in down of right is busy.
     */
    protected void moveDownRight(int inDown, int inRight) throws PositionException {
        IntegerPosition2D oldPos = getCurrentPosition();
        int newX = oldPos.getX() + inRight;
        int newY = oldPos.getY() - inDown;
        IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Method moves object in {@code newPos}.
     * 
     * @param newPos
     * @throws LostObjectException       if object isn't on position which written
     *                                   in object's data;
     * @throws CannotMoveObjectException if {@code newPos} is busy.
     */
    protected void moveToPosition(IntegerPosition2D newPos) throws PositionException {
        checkForBeingInCurrentPosition();

        IntegerPosition2D oldPos = getCurrentPosition();
        try {
            getArea().relocate(oldPos, newPos);
        } catch (BusyPositionException e) {
            throw new CannotMoveObjectException(newPos, this);
        }

        setCurrentPosition(newPos);
    }

    /**
     * @return area where object is.
     */
    protected final CheckeredAreaContainsAll getArea() {
        return area;
    }

    /**
     * @return current position of object.
     */
    protected final IntegerPosition2D getCurrentPosition() {
        return startPos;
    }

    /**
     * Set current object's position.
     * 
     * @param pos
     */
    protected final void setCurrentPosition(IntegerPosition2D pos) {
        startPos = pos;
    }

    private void checkForBeingInCurrentPosition() throws PositionException {
        CheckeredAreaContainsAll area = getArea();
        IntegerPosition2D pos = getCurrentPosition();

        if (area.positionIsEmpty(pos) || area.get(pos) != this) {
            throw new LostObjectException(pos, this);
        }
    }
}
