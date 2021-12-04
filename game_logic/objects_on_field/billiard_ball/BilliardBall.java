package game_logic.objects_on_field.billiard_ball;

import game_logic.IntegerPosition;
import game_logic.basis_exceptions.GameLogicException;
import game_logic.intarfaces.IntegerPos;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.ObjectOnLocation;

public class BilliardBall implements ObjectOnLocation {
    private final Location location;
    private IntegerPos currentPosition;
    private Direction currentDirection;
    private IntegerPos pastPosition;
    private Direction pastDirection;

    public BilliardBall(Location loc) throws GameLogicException {
        location = loc;
        setCurrentPosition(new IntegerPosition(location.getXMinLimit(), location.getYMaxLimit()));
        setPastPosition(getCurrentPosition());
        setCurrentDirection(Direction.DOWN_RIGHT);
        setPastDirection(getCurrentDirection());

        location.putObject(getCurrentPosition(), this);
    }

    public void runToEnd() throws GameLogicException {
        while (canMoving()) {
            step();
        }
    }

    public void step() throws GameLogicException {
        moveByStep();
        writeLineInPastPosition();
    }

    public boolean canMoving() {
        return !movingInAngle();
    }

    @Override
    public String toString() {
        return "O";
    }

    // moving
    private void moveByStep() throws GameLogicException {
        // setCurrentDirection()'s call have to be before moveToPosition()'s call
        if (canMoving()) {
            if (!movingToNearestWall()) {
                setCurrentDirection(getNewDirection());
                moveByCurrentDirection();
            } else {
                // Have to create 2 variables and write into themselves new position
                // and new direction to don't suffer from bags.
                IntegerPos newPosition = getPositionAfterReboundWithCurrentDirection();
                Direction newDirection = getNewDirection();

                moveToPosition(newPosition);
                setCurrentDirection(newDirection);
            }
        }
    }

    private void moveByCurrentDirection() throws GameLogicException {
        moveByDirection(getCurrentDirection());
    }

    private void moveByDirection(Direction direction) throws GameLogicException {
        if (direction == Direction.UP_LEFT) {
            moveUpLeft();
        } else if (direction == Direction.UP_RIGHT) {
            moveUpRight();
        } else if (direction == Direction.DOWN_LEFT) {
            moveDownLeft();
        } else if (direction == Direction.DOWN_RIGHT) {
            moveDownRight();
        }

    }

    private Direction getNewDirection() {
        currentDirection = getCurrentDirection();

        if ((nearLeftWall() && currentDirection.isLeft()) || (nearRightWall() && currentDirection.isRight())) {
            return currentDirection.getShiftedHorizontally();
        } else if ((nearUpperWall() && currentDirection.isUpper())
                || (nearBottomWall() && currentDirection.isBottom())) {
            return currentDirection.getShiftedVertically();
        } else {
            return currentDirection;
        }
    }

    private IntegerPos getPositionAfterReboundWithCurrentDirection() throws TryToReboundWithoutWallNearException {
        if (!nearWall()) {
            throw new TryToReboundWithoutWallNearException();
        }

        Direction direction = getCurrentDirection();
        int currentX = getCurrentPosition().getX();
        int currentY = getCurrentPosition().getY();
        if (nearUpperWall()) {
            if (direction == Direction.UP_LEFT) {
                return new IntegerPosition(currentX - 1, currentY);
            } else if (direction == Direction.UP_RIGHT) {
                return new IntegerPosition(currentX + 1, currentY);
            }
        }
        if (nearBottomWall()) {
            if (direction == Direction.DOWN_LEFT) {
                return new IntegerPosition(currentX - 1, currentY);
            } else if (direction == Direction.DOWN_RIGHT) {
                return new IntegerPosition(currentX + 1, currentY);
            }
        }
        if (nearLeftWall()) {
            if (direction == Direction.UP_LEFT) {
                return new IntegerPosition(currentX, currentY + 1);
            } else {
                return new IntegerPosition(currentX, currentY - 1);
            }
        } else {
            if (direction == Direction.UP_RIGHT) {
                return new IntegerPosition(currentX, currentY + 1);
            } else {
                return new IntegerPosition(currentX, currentY - 1);
            }
        }
    }

    private void moveUpLeft() throws GameLogicException {
        int newX = getCurrentPosition().getX() - 1;
        int newY = getCurrentPosition().getY() + 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveUpRight() throws GameLogicException {
        int newX = getCurrentPosition().getX() + 1;
        int newY = getCurrentPosition().getY() + 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveDownLeft() throws GameLogicException {
        int newX = getCurrentPosition().getX() - 1;
        int newY = getCurrentPosition().getY() - 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveDownRight() throws GameLogicException {
        int newX = getCurrentPosition().getX() + 1;
        int newY = getCurrentPosition().getY() - 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveToPosition(IntegerPos pos) throws GameLogicException {
        setCurrentPosition(pos);
        location.removeObject(getPastPosition());
        location.putObject(getCurrentPosition(), this);
    }

    // writing line
    private void writeLineInPastPosition() throws GameLogicException {
        location.putObject(getPastPosition(), new BallLine(getPastDirection()));
    }

    // setters and getters
    private IntegerPos getCurrentPosition() {
        return currentPosition;
    }

    private void setCurrentPosition(IntegerPos pos) {
        setPastPosition(getCurrentPosition());
        currentPosition = pos;
    }

    private IntegerPos getPastPosition() {
        return pastPosition;
    }

    private void setPastPosition(IntegerPos pos) {
        pastPosition = pos;
    }

    private Direction getCurrentDirection() {
        return currentDirection;
    }

    private void setCurrentDirection(Direction dir) {
        setPastDirection(getCurrentDirection());
        currentDirection = dir;
    }

    private Direction getPastDirection() {
        return pastDirection;
    }

    private void setPastDirection(Direction dir) {
        pastDirection = dir;
    }

    // checkers
    private boolean movingToNearestWall() {
        if (!nearWall()) {
            return false;
        } else {
            Direction direction = getCurrentDirection();
            return (nearUpperWall() && direction.isUpper()) || (nearBottomWall() && direction.isBottom())
                    || (nearLeftWall() && direction.isLeft()) || (nearRightWall() && direction.isRight());
        }
    }

    private boolean movingInAngle() {
        Direction direction = getCurrentDirection();
        return (inUpperLeftAngle() && direction == Direction.UP_LEFT)
                || (inUpperRightAngle() && direction == Direction.UP_RIGHT)
                || (inBottomLeftAngle() && direction == Direction.DOWN_LEFT)
                || (inBottomRightAngle() && direction == Direction.DOWN_RIGHT);
    }

    private boolean nearWall() {
        return nearHorizontalWall() || nearVerticalWall();
    }

    private boolean nearVerticalWall() {
        return nearLeftWall() || nearRightWall();
    }

    private boolean nearHorizontalWall() {
        return nearUpperWall() || nearBottomWall();
    }

    private boolean nearLeftWall() {
        int x = getCurrentPosition().getX();
        int xMin = location.getXMinLimit();

        return x == xMin;
    }

    private boolean nearRightWall() {
        int x = getCurrentPosition().getX();
        int xMax = location.getXMaxLimit();

        return x == xMax;
    }

    private boolean nearBottomWall() {
        int y = getCurrentPosition().getY();
        int yMin = location.getYMinLimit();

        return y == yMin;
    }

    private boolean nearUpperWall() {
        int y = getCurrentPosition().getY();
        int yMax = location.getYMaxLimit();

        return y == yMax;
    }

    private boolean inUpperLeftAngle() {
        return nearUpperWall() && nearLeftWall();
    }

    private boolean inUpperRightAngle() {
        return nearUpperWall() && nearRightWall();
    }

    private boolean inBottomLeftAngle() {
        return nearBottomWall() && nearLeftWall();
    }

    private boolean inBottomRightAngle() {
        return nearBottomWall() && nearRightWall();
    }
}

enum Direction {
    UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;

    public boolean isLeft() {
        return this == UP_LEFT || this == DOWN_LEFT;
    }

    public boolean isRight() {
        return this == UP_RIGHT || this == DOWN_RIGHT;
    }

    public boolean isUpper() {
        return this == UP_LEFT || this == UP_RIGHT;
    }

    public boolean isBottom() {
        return this == DOWN_LEFT || this == DOWN_RIGHT;
    }

    public Direction getShiftedHorizontally() {
        if (this == UP_LEFT) {
            return UP_RIGHT;
        } else if (this == UP_RIGHT) {
            return UP_LEFT;
        } else if (this == DOWN_LEFT) {
            return DOWN_RIGHT;
        } else {
            return DOWN_LEFT;
        }
    }

    public Direction getShiftedVertically() {
        if (this == UP_LEFT) {
            return DOWN_LEFT;
        } else if (this == UP_RIGHT) {
            return DOWN_RIGHT;
        } else if (this == DOWN_LEFT) {
            return UP_LEFT;
        } else {
            return UP_RIGHT;
        }
    }
}

class BallLine implements ObjectOnLocation {
    private final String str;

    protected BallLine(Direction direction) {
        if (direction == Direction.UP_LEFT || direction == Direction.DOWN_RIGHT) {
            str = "\\";
        } else {
            str = "/";
        }
    }

    @Override
    public String toString() {
        return str;
    }
}