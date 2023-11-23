package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.PositionException;

public class MovingObjectStub extends MovingObject {
    public MovingObjectStub(AreaContainsAll area, Position pos) throws PositionException {
        super(area, pos);
    }

    @Override
    public void moveUp() throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUp();
    }

    @Override
    public void moveDown() throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDown();
    }

    @Override
    public void moveLeft() throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveLeft();
    }

    @Override
    public void moveRight() throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveRight();
    }

    @Override
    public void moveUpLeft() throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUpLeft();
    }

    @Override
    public void moveUpRight()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUpRight();
    }

    @Override
    public void moveDownLeft()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDownLeft();
    }

    @Override
    public void moveDownRight()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDownRight();
    }

    @Override
    public void moveUp(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUp(n);
    }

    @Override
    public void moveDown(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDown(n);
    }

    @Override
    public void moveLeft(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveLeft(n);
    }

    @Override
    public void moveRight(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveRight(n);
    }

    @Override
    public void moveUpLeft(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUpLeft(n);
    }

    @Override
    public void moveUpRight(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUpRight(n);
    }

    @Override
    public void moveDownLeft(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDownLeft(n);
    }

    @Override
    public void moveDownRight(int n)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDownRight(n);
    }

    @Override
    public void moveUpLeft(int inUp, int inLeft)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUpLeft(inUp, inLeft);
    }

    @Override
    public void moveUpRight(int inUp, int inRight)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveUpRight(inUp, inRight);
    }

    @Override
    public void moveDownLeft(int inDown, int inLeft)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDownLeft(inDown, inLeft);
    }

    @Override
    public void moveDownRight(int inDown, int inRight)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveDownRight(inDown, inRight);
    }

    @Override
    public void moveToPosition(Position newPos)
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        super.moveToPosition(newPos);
    }

    public AreaContainsAll callGetArea() {
        return getArea();
    }

    public Position callGetCurrentIntegerPosition() {
        return getCurrentPosition();
    }

    public void callSetCurrentPosition(Position pos) {
        setCurrentPosition(pos);
    }
}
