package game_logic.objects_in_area.billiard_ball;

import game_logic.IntegerPosition;
import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.ObjectInArea;
import game_logic.objects_in_area.abstractions.ObjectCanMovingByDirection;
import game_logic.objects_in_area.abstractions.exceptions.BusyPositionException;
import game_logic.objects_in_area.conditions.Direction;

public class BilliardBall extends ObjectCanMovingByDirection {
    private IntegerPos oldPosition;
    private boolean shouldPaintOverCell = true;

    public BilliardBall(CheckeredArea area, IntegerPos pos, Direction dir) throws PositionException {
        super(area, pos, dir);
    }

    public BilliardBall(CheckeredArea area) throws PositionException {
        super(area, new IntegerPosition(area.getXMinLimit(), area.getYMaxLimit()), Direction.DOWN_RIGHT);
    }

    @Override
    public String toString() {
        return "O";
    }

    public void runToEnd() throws PositionException, BusyPositionException {
        while (true) {
            try {
                step();
            } catch (InAngleException e) {
                break;
            }
        }
    }

    public void step() throws PositionException, BusyPositionException, InAngleException {
        if (movingInAngle()) {
            throw new InAngleException();
        }

        Direction newDirection = getNewDirection();

        try {
            moveToPos(getPositionAfterRebound());
        } catch (DontMovingToNearWallException e) {
            moveByDirection();
        }

        if (shouldPaintOverCell) {
            paintOverCellInPosition(getOldPosition());
            shouldPaintOverCell = false;
        } else {
            shouldPaintOverCell = true;
        }

        setDirection(newDirection);
    }

    private void paintOverCellInPosition(IntegerPos pos) throws PositionException {
        CheckeredArea area = getArea();
        area.putObject(pos, new BlackSquare());
    }

    @Override
    protected void setPosition(IntegerPos pos) {
        oldPosition = getPosition();
        super.setPosition(pos);
    }

    protected IntegerPos getOldPosition() {
        return oldPosition;
    }

    private IntegerPos getPositionAfterRebound() throws DontMovingToNearWallException {
        Direction direction = getDirection();
        int x = getPosition().getX();
        int y = getPosition().getY();

        if ((nearTopWall() && direction == Direction.UP_LEFT)
                || (nearDownWall() && direction == Direction.DOWN_LEFT)) {
            return new IntegerPosition(x - 1, y);
        }
        if ((nearTopWall() && direction == Direction.UP_RIGHT)
                || (nearDownWall() && direction == Direction.DOWN_RIGHT)) {
            return new IntegerPosition(x + 1, y);
        }
        if ((nearLeftWall() && direction == Direction.UP_LEFT)
                || (nearRightWall() && direction == Direction.UP_RIGHT)) {
            return new IntegerPosition(x, y + 1);
        }
        if ((nearLeftWall() && direction == Direction.DOWN_LEFT)
                || (nearRightWall() && direction == Direction.DOWN_RIGHT)) {
            return new IntegerPosition(x, y - 1);
        }

        throw new DontMovingToNearWallException();
    }

    private Direction getNewDirection() {
        Direction currentDirection = getDirection();

        if (!willRebound()) {
            return currentDirection;
        } else {
            if ((nearTopWall() && currentDirection.isUp())
                    || (nearDownWall() && currentDirection.isDown())) {
                return currentDirection.getShiftedVertically();
            } else { // if ((nearLeftWall() && currentDirection.isLeft())
                // || (nearRightWall() && currentDirection.isRight())) {
                return currentDirection.getShiftedHorizontally();
            }
        }
    }

    // checkers
    private boolean willRebound() {
        return movingToNearWall() && !movingInAngle();
    }

    private boolean movingToNearWall() {
        Direction direction = getDirection();

        return (nearTopWall() && direction.isUp())
                || (nearDownWall() && direction.isDown())
                || (nearLeftWall() && direction.isLeft())
                || (nearRightWall() && direction.isRight());
    }

    private boolean nearTopWall() {
        int y = getPosition().getY();
        int yMax = getArea().getYMaxLimit();

        return y == yMax;
    }

    private boolean nearDownWall() {
        int y = getPosition().getY();
        int yMin = getArea().getYMinLimit();

        return y == yMin;
    }

    private boolean nearLeftWall() {
        int x = getPosition().getX();
        int xMin = getArea().getXMinLimit();

        return x == xMin;
    }

    private boolean nearRightWall() {
        int x = getPosition().getX();
        int xMax = getArea().getXMaxLimit();

        return x == xMax;
    }

    private boolean movingInAngle() {
        Direction direction = getDirection();

        return (inTopLeftAngle() && direction == Direction.UP_LEFT)
                || (inTopRightAngle() && direction == Direction.UP_RIGHT)
                || (inDownLeftAngle() && direction == Direction.DOWN_LEFT)
                || (inDownRightAngle() && direction == Direction.DOWN_RIGHT);
    }

    private boolean inTopLeftAngle() {
        return nearTopWall() && nearLeftWall();
    }

    private boolean inTopRightAngle() {
        return nearTopWall() && nearRightWall();
    }

    private boolean inDownLeftAngle() {
        return nearDownWall() && nearLeftWall();
    }

    private boolean inDownRightAngle() {
        return nearDownWall() && nearRightWall();
    }
}

class BlackSquare implements ObjectInArea {
    @Override
    public String toString() {
        return "@";
    }
}

class DontMovingToNearWallException extends Exception {
}

