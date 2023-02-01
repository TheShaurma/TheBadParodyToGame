package Tests.ObjectsInArea;

import TheBadParodyToGame.ObjectsInArea.MovingObject;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class MovingObjectStub extends MovingObject {
    public MovingObjectStub(CheckeredArea area, IntegerPosition2D pos) throws PositionException {
        super(area, pos);
    }

    @Override
    public void moveUp() throws PositionException {
        super.moveUp();
    }

    @Override
    public void moveDown() throws PositionException {
        super.moveDown();
    }

    @Override
    public void moveLeft() throws PositionException {
        super.moveLeft();
    }

    @Override
    public void moveRight() throws PositionException {
        super.moveRight();
    }

    @Override
    public void moveUpLeft() throws PositionException {
        super.moveUpLeft();
    }

    @Override
    public void moveUpRight() throws PositionException {
        super.moveUpRight();
    }

    @Override
    public void moveDownLeft() throws PositionException {
        super.moveDownLeft();
    }

    @Override
    public void moveDownRight() throws PositionException {
        super.moveDownRight();
    }

    @Override
    public void moveUp(int n) throws PositionException {
        super.moveUp(n);
    }

    @Override
    public void moveDown(int n) throws PositionException {
        super.moveDown(n);
    }

    @Override
    public void moveLeft(int n) throws PositionException {
        super.moveLeft(n);
    }

    @Override
    public void moveRight(int n) throws PositionException {
        super.moveRight(n);
    }

    @Override
    public void moveUpLeft(int n) throws PositionException {
        super.moveUpLeft(n);
    }

    @Override
    public void moveUpRight(int n) throws PositionException {
        super.moveUpRight(n);
    }

    @Override
    public void moveDownLeft(int n) throws PositionException {
        super.moveDownLeft(n);
    }

    @Override
    public void moveDownRight(int n) throws PositionException {
        super.moveDownRight(n);
    }

    @Override
    public void moveUpLeft(int inUp, int inLeft) throws PositionException {
        super.moveUpLeft(inUp, inLeft);
    }

    @Override
    public void moveUpRight(int inUp, int inRight) throws PositionException {
        super.moveUpRight(inUp, inRight);
    }

    @Override
    public void moveDownLeft(int inDown, int inLeft) throws PositionException {
        super.moveDownLeft(inDown, inLeft);
    }

    @Override
    public void moveDownRight(int inDown, int inRight) throws PositionException {
        super.moveDownRight(inDown, inRight);
    }

    @Override
    public void moveToPosition(IntegerPosition2D newPos) throws PositionException {
        super.moveToPosition(newPos);
    }

    public CheckeredArea callGetArea() {
        return getArea();
    }

    public IntegerPosition2D callGetCurrentIntegerPosition2D() {
        return getCurrentPosition();
    }

    public void callSetCurrentPosition(IntegerPosition2D pos) {
        setCurrentPosition(pos);
    }
}
