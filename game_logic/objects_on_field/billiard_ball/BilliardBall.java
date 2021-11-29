package game_logic.objects_on_field.billiard_ball;

import game_logic.IntegerPosition;
import game_logic.intarfaces.IntegerPos;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.ObjectOnLocation;

public class BilliardBall implements ObjectOnLocation {
    private final Location location;
    private IntegerPos currentPosition;
    private Direction currentDirection;
    private IntegerPos pastPosition;
    private Direction pastDirection;

    public BilliardBall(Location loc) {
        location = loc;
        setCurrentPosition(new IntegerPosition(location.getXMinLimit(), location.getYMaxLimit()));
        setPastPosition(getCurrentPosition());
        setCurrentDirection(Direction.DOWN_RIGHT);
        setPastDirection(getCurrentDirection());

        location.putObject(getCurrentPosition(), this);
    }

    public void runToEnd() throws TryReboundWithoutWallNearException {
        while (!inAngle() || inStartingPosition()) {
            moveByStep();
        }
    }

    // moving
    private void moveByStep() throws TryReboundWithoutWallNearException {
        // moving
        if (!inAngle() || inStartingPosition()) {
            if (!movingToNearestWall()) {
                moveByCurrentDirection();
            } else {
                setCurrentDirection(getNewDirection()); // have to be before moveToPosition method's call
                moveToPosition(getPositionAfterRebound());
            }
        }

        writeLineInPastPosition();
    }

    private void moveByCurrentDirection() {
        moveByDirection(getCurrentDirection());
    }

    private void moveByDirection(Direction direction) {
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

        if (!movingToNearestWall()) {
            return currentDirection;
        } else {
            if (nearHorizontalWall()) {
                return currentDirection.getShiftedVertically();
            } else {
                return currentDirection.getShiftedHorizontally();
            }
        }
    }

    private IntegerPos getPositionAfterRebound() throws TryReboundWithoutWallNearException {
        if (!nearWall()) {
            throw new TryReboundWithoutWallNearException();
        }

        Direction direction = getCurrentDirection();
        int currentX = getCurrentPosition().getX();
        int currentY = getCurrentPosition().getY();
        if (nearUpperWall()) {
            if (direction == Direction.UP_LEFT) {
                return new IntegerPosition(currentX - 1, currentY);
            } else {
                return new IntegerPosition(currentX + 1, currentY);
            }
        } else if (nearBottomWall()) {
            if (direction == Direction.DOWN_LEFT) {
                return new IntegerPosition(currentX - 1, currentY);
            } else {
                return new IntegerPosition(currentX + 1, currentY);
            }
        } else if (nearLeftWall()) {
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

    private void moveUpLeft() {
        int newX = getCurrentPosition().getX() - 1;
        int newY = getCurrentPosition().getY() + 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveUpRight() {
        int newX = getCurrentPosition().getX() + 1;
        int newY = getCurrentPosition().getY() + 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveDownLeft() {
        int newX = getCurrentPosition().getX() - 1;
        int newY = getCurrentPosition().getY() - 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveDownRight() {
        int newX = getCurrentPosition().getX() + 1;
        int newY = getCurrentPosition().getY() - 1;

        moveToPosition(new IntegerPosition(newX, newY));
    }

    private void moveToPosition(IntegerPos pos) {
        setCurrentPosition(pos);
        location.removeObject(getPastPosition());
        location.putObject(getCurrentPosition(), this);
    }

    // writing line
    private void writeLineInPastPosition() {
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

    private boolean inStartingPosition() {
        int x = getCurrentPosition().getX();
        int y = getCurrentPosition().getY();
        int xMin = location.getXMinLimit();
        int yMax = location.getYMaxLimit();

        return x == xMin && y == yMax;
    }

    private boolean inAngle() {
        return nearHorizontalWall() && nearVerticalWall();
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