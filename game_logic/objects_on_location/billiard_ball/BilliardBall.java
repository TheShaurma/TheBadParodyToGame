package game_logic.objects_on_location.billiard_ball;

import game_logic.IntegerPosition;
import game_logic.abstractions.basis_exceptions.ObjectOnLocationException;
import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.ObjectOnLocation;
import game_logic.objects_on_location.conditions.Direction;
import game_logic.objects_on_location.object_abstractions.ObjectWithFoolConditionWithPast;

public class BilliardBall extends ObjectWithFoolConditionWithPast {
    boolean haveToWriteLine = false;

    public BilliardBall(Location loc) throws PositionException {
        super(loc, new IntegerPosition(loc.getXMinLimit(), loc.getYMaxLimit()), Direction.DOWN_RIGHT);
    }

    public void moveByEnd() throws PositionException {
        while (true) {
            try {
                step();
            } catch (InAngleException e) {
                break;
            }
        }
    }

    public void step() throws PositionException, InAngleException {
        moveToStep();
        if (haveToWriteLine) {
            writeLineInPastBallPosition();
        }
    }

    public boolean canMoving() {
        return !movingInAngle();
    }

    @Override
    public String toString() {
        return "O";
    }

    private void writeLineInPastBallPosition() throws PositionException {
        Location location = getLocationCondition().getLocation();
        IntegerPos pastPosition = getPositionCondition().getPast().getPosition();
        Direction pastDirection = getDirectionCondition().getPast().getDirection();

        location.putObject(pastPosition, new Line(pastDirection));
    }

    // moving
    private void moveToStep() throws PositionException, InAngleException {
        IntegerPos newPos = getNewPosition();
        Direction newDir = getNewDirection();

        moveToPosition(newPos);
        getDirectionCondition().updateDirection(newDir);

        haveToWriteLine = !haveToWriteLine;
    }

    private Direction getNewDirection() {
        Direction currentDirection = getDirectionCondition().getDirection();

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

    private void moveToPosition(IntegerPos pos) throws PositionException {
        getPositionCondition().updatePosition(pos);
        IntegerPos pastPos = getPositionCondition().getPast().getPosition();
        IntegerPos newPos = getPositionCondition().getPosition();

        getLocationCondition().getLocation().removeObject(pastPos);
        getLocationCondition().getLocation().putObject(newPos, this);
    }

    private IntegerPos getNewPosition() throws InAngleException {
        if (movingInAngle()) {
            throw new InAngleException();
        }

        try {
            return getPositionAfterRebound();
        } catch (WillNotReboundException e) {
            return getPositionByDirection(getDirectionCondition().getDirection());
        }
    }

    private IntegerPos getPositionByDirection(Direction direction) {
        IntegerPos currentPosition = getPositionCondition().getPosition();
        int x = currentPosition.getX();
        int y = currentPosition.getY();

        if (direction == Direction.UP_LEFT) {
            return new IntegerPosition(x - 1, y + 1);
        } else if (direction == Direction.UP_RIGHT) {
            return new IntegerPosition(x + 1, y + 1);
        } else if (direction == Direction.DOWN_LEFT) {
            return new IntegerPosition(x - 1, y - 1);
        } else {
            return new IntegerPosition(x + 1, y - 1);
        }
    }

    private IntegerPos getPositionAfterRebound() throws WillNotReboundException {
        if (!willRebound()) {
            throw new WillNotReboundException();
        }

        Direction direction = getDirectionCondition().getDirection();
        int x = getPositionCondition().getPosition().getX();
        int y = getPositionCondition().getPosition().getY();

        if (nearHorizontalWall()) {
            if (direction.isLeft()) {
                return new IntegerPosition(x - 1, y);
            } else { // if (direction.isRight()) {
                return new IntegerPosition(x + 1, y);
            }
        } else { // if (nearVerticalWall()) {
            if (direction.isUp()) {
                return new IntegerPosition(x, y + 1);
            } else { // if (direction.isDown()) {
                return new IntegerPosition(x, y - 1);
            }
        }
    }

    // checkers
    private boolean willRebound() {
        return movingToNearWall() && !movingInAngle();
    }

    private boolean movingToNearWall() {
        Direction direction = getDirectionCondition().getDirection();

        return (nearTopWall() && direction.isUp())
                || (nearDownWall() && direction.isDown())
                || (nearLeftWall() && direction.isLeft())
                || (nearRightWall() && direction.isRight());
    }

    private boolean nearHorizontalWall() {
        return nearTopWall() || nearDownWall();
    }

    private boolean nearTopWall() {
        int y = getPositionCondition().getPosition().getY();
        int yMax = getLocationCondition().getLocation().getYMaxLimit();

        return y == yMax;
    }

    private boolean nearDownWall() {
        int y = getPositionCondition().getPosition().getY();
        int yMin = getLocationCondition().getLocation().getYMinLimit();

        return y == yMin;
    }

    private boolean nearLeftWall() {
        int x = getPositionCondition().getPosition().getX();
        int xMin = getLocationCondition().getLocation().getXMinLimit();

        return x == xMin;
    }

    private boolean nearRightWall() {
        int x = getPositionCondition().getPosition().getX();
        int xMax = getLocationCondition().getLocation().getXMaxLimit();

        return x == xMax;
    }

    private boolean movingInAngle() {
        Direction direction = getDirectionCondition().getDirection();

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

class WillNotReboundException extends ObjectOnLocationException {
}

class InAngleException extends ObjectOnLocationException {
    @Override
    public String toString() {
        return "Ball can't move because it's in angle.";
    }
}

class Line implements ObjectOnLocation {
    private final LineType lineType;

    public Line(Direction dir) {
        if (dir == Direction.UP_LEFT || dir == Direction.DOWN_RIGHT) {
            lineType = LineType.TO_DOWN;
        } else {
            lineType = LineType.TO_UP;
        }
    }

    @Override
    public String toString() {
        if (lineType == LineType.TO_DOWN) {
            return "\\";
        } else {
            return "/";
        }
    }

    public enum LineType {
        TO_DOWN, // \
        TO_UP; // /
    }
}