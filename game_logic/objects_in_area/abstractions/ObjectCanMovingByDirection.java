package game_logic.objects_in_area.abstractions;

import game_logic.IntegerPosition;
import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_in_area.abstractions.exceptions.BusyPositionException;
import game_logic.objects_in_area.conditions.Direction;

public abstract class ObjectCanMovingByDirection extends ObjectCanMoving<CheckeredArea, IntegerPos> {
    private Direction direction;

    public ObjectCanMovingByDirection(CheckeredArea ar, IntegerPos pos, Direction dir) throws PositionException {
        super(ar, pos);
        direction = dir;
    }

    public void moveByDirection() throws PositionException, BusyPositionException {
        switch (getDirection()) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case UP_LEFT:
                moveUpLeft();
                break;
            case UP_RIGHT:
                moveUpRight();
                break;
            case DOWN_LEFT:
                moveDownLeft();
                break;
            case DOWN_RIGHT:
                moveDownRight();
                break;
        }
    }

    protected void setDirection(Direction dir) {
        direction = dir;
    }

    protected Direction getDirection() {
        return direction;
    }

    private void moveUp() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() + 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }

    private void moveDown() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX();
        int newY = oldPos.getY() - 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }

    private void moveLeft() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }

    private void moveRight() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }

    private void moveUpLeft() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY() + 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }

    private void moveUpRight() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY() + 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }

    private void moveDownLeft() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX() - 1;
        int newY = oldPos.getY() - 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }

    private void moveDownRight() throws PositionException, BusyPositionException {
        IntegerPos oldPos = getPosition();
        int newX = oldPos.getX() + 1;
        int newY = oldPos.getY() - 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPos(newPos);
    }
}
