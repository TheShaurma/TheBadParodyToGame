package TheBadParodyToGame.objectsInArea.movingObjects;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.exceptions.PositionException;
import TheBadParodyToGame.objectsInArea.AbstractObject;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;

public abstract class MovingObject extends AbstractObject {
    private final AreaContainsAll area;
    private Position currentPos;

    /**
     * Call {@code area.place(pos, this)} after creating.
     * 
     * @param area where object will be after creating;
     * @param pos  in {@code area} where object will be after creating;
     * @throws PositionCannotExistInAreaException
     * @throws BusyPositionException              if {@code pos} is empty;
     * @throws PositionException                  if {@code pos} can't exist in
     *                                            {@code area}.
     */
    public MovingObject(AreaContainsAll area, Position pos)
            throws BusyPositionException, PositionCannotExistInAreaException {
        this.area = area;
        currentPos = pos;

        // TODO: revome placing
        area.place(pos, this);
    }

    @Override
    public String toString() {
        return "MovingObject(" + getCurrentPosition() + ")";
    }

    /**
     * Move object to 1 in up.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up is busy.
     */
    protected void moveUp()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveUp(1);
    }

    /**
     * Move object to 1 in down.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down is busy.
     */
    protected void moveDown()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveDown(1);
    }

    /**
     * Move object to 1 in left.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in left is busy.
     */
    protected void moveLeft()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveLeft(1);
    }

    /**
     * Move object to 1 in right.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in right is busy.
     */
    protected void moveRight()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveRight(1);
    }

    /**
     * Move object to 1 in up and left.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up of left is busy.
     */
    protected void moveUpLeft()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveUpLeft(1);
    }

    /**
     * Move object to 1 in up and right.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up of right is busy.
     */
    protected void moveUpRight()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveUpRight(1);
    }

    /**
     * Move object to 1 in down and left.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down of left is busy.
     */
    protected void moveDownLeft()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveDownLeft(1);
    }

    /**
     * Move object to 1 in down and right.
     * 
     * @throws PositionCannotExistInAreaException
     * 
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down of right is busy.
     */
    protected void moveDownRight()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveDownRight(1);
    }

    /**
     * Move object to {@code n} in up.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up is busy.
     */
    protected void moveUp(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() + n;
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in down.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down is busy.
     */
    protected void moveDown(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() - n;
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in left.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in left is busy.
     */
    protected void moveLeft(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX() - n;
        int newY = oldPos.getY();
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in right.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in right is busy.
     */
    protected void moveRight(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX() + n;
        int newY = oldPos.getY();
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code n} in up and left.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up of left is busy.
     */
    protected void moveUpLeft(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveUpLeft(n, n);
    }

    /**
     * Move object to {@code n} in up and right.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up of right is busy.
     */
    protected void moveUpRight(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveUpRight(n, n);
    }

    /**
     * Move object to {@code n} in down and left.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down of left is busy.
     */
    protected void moveDownLeft(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveDownLeft(n, n);
    }

    /**
     * Move object to {@code n} in down and right.
     * 
     * @param n
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down of right is busy.
     */
    protected void moveDownRight(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        moveDownRight(n, n);
    }

    /**
     * Move object to {@code inUp} in up and {@code inLeft} in left.
     * 
     * @param inUp
     * @param inLeft
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up of left is busy.
     */
    protected void moveUpLeft(int inUp, int inLeft)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX() - inLeft;
        int newY = oldPos.getY() + inUp;
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code inUp} in up and {@code inRight} in right.
     * 
     * @param inUp
     * @param inRight
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in up of right is busy.
     */
    protected void moveUpRight(int inUp, int inRight)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX() + inRight;
        int newY = oldPos.getY() + inUp;
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code inDown} in down and {@code inLeft} in left.
     * 
     * @param inDown
     * @param inLeft
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down of left is busy.
     */
    protected void moveDownLeft(int inDown, int inLeft)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX() - inLeft;
        int newY = oldPos.getY() - inDown;
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Move object to {@code inDown} in down and {@code inRight} in right.
     * 
     * @param inDown
     * @param inLeft
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if pos in down of right is busy.
     */
    protected void moveDownRight(int inDown, int inRight)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position oldPos = getCurrentPosition();
        int newX = oldPos.getX() + inRight;
        int newY = oldPos.getY() - inDown;
        Position newPos = new GamePosition(newX, newY);

        moveToPosition(newPos);
    }

    /**
     * Method moves object in {@code newPos}.
     * 
     * @param newPos
     * @throws PositionCannotExistInAreaException
     * @throws LostObjectException                if object isn't on position which
     *                                            written
     *                                            in object's data;
     * @throws CannotMoveObjectException          if {@code newPos} is busy.
     */
    protected void moveToPosition(Position newPos)
            throws LostObjectException, PositionCannotExistInAreaException, CannotMoveObjectException {
        checkForBeingInCurrentPosition();

        Position oldPos = getCurrentPosition();
        try {
            try {
                getArea().relocate(oldPos, newPos);
            } catch (EmptyPositionException e) {
                throw new LostObjectException(oldPos, this);
            }
        } catch (BusyPositionException e) {
            throw new CannotMoveObjectException(newPos, this);
        }

        setCurrentPosition(newPos);
    }

    /**
     * @return area where object is.
     */
    protected final AreaContainsAll getArea() {
        return area;
    }

    /**
     * @return current position of object.
     */
    protected final Position getCurrentPosition() {
        return currentPos;
    }

    /**
     * Set current object's position.
     * 
     * @param pos
     */
    protected final void setCurrentPosition(Position pos) {
        currentPos = pos;
    }

    protected void checkForBeingInCurrentPosition() throws LostObjectException, PositionCannotExistInAreaException {
        AreaContainsAll area = getArea();
        Position pos = getCurrentPosition();

        try {
            if (area.get(pos) != this) {
                throw new LostObjectException(pos, this);
            }
        } catch (EmptyPositionException e) {
            throw new LostObjectException(pos, this);
        }
    }
}
