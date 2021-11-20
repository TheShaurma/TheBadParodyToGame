package game_logic;

import game_logic.abstract_classes.AbstractObjectOnLocation;
import game_logic.intarfaces.IntegerPos;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.ObjectOnLocation;

public class BallManager {
    private BallDirection direction = BallDirection.DOWN_RIGHT;
    Location location;
    IntegerPos ballPosition;

    public BallManager(Location location) {
        setLocation(location);
        setBallPosition(new IntegerPosition(getLocation().getXMinLimit(), getLocation().getYMaxLimit()));
    }

    public void step() {
        if (!inAngle()) {
            directionUpdate();
            moveByDirection();
        }
    }

    public String toString() {
        return "*";
    }

    //
    private void directionUpdate() {
        if (nearHorizontalWall()) {
            if (direction == BallDirection.UP_LEFT) {
                direction = BallDirection.DOWN_LEFT;
            } else if (direction == BallDirection.UP_RIGHT) {
                direction = BallDirection.DOWN_RIGHT;
            } else if (direction == BallDirection.DOWN_LEFT) {
                direction = BallDirection.UP_LEFT;
            } else {
                direction = BallDirection.UP_RIGHT;
            }
        } else {
            if (direction == BallDirection.UP_LEFT) {
                direction = BallDirection.UP_RIGHT;
            } else if (direction == BallDirection.UP_RIGHT) {
                direction = BallDirection.UP_LEFT;
            } else if (direction == BallDirection.DOWN_LEFT) {
                direction = BallDirection.DOWN_RIGHT;
            } else {
                direction = BallDirection.DOWN_LEFT;
            }
        }
    }

    private void moveByDirection() {
        if (direction == BallDirection.UP_LEFT) {
            moveToUpLeft();
        } else if (direction == BallDirection.UP_RIGHT) {
            moveToUpRight();
        } else if (direction == BallDirection.DOWN_RIGHT) {
            moveToDownRight();
        } else if (direction == BallDirection.DOWN_LEFT) {
            moveToDownLeft();
        }
    }

    private void writeLineFromBall(BallDirection lineDirection) {
        IntegerPos ballPos = getBallPosition();
        IntegerPos linePos = getNearestPositionByDirectionFromBall(lineDirection);
        getLocation().putObject(linePos, getLineByDirection(lineDirection));
    }

    // getters and setters
    private void setLocation(Location location) {
        this.location = location;
    }

    private Location getLocation() {
        return location;
    }

    private void setBallPosition(IntegerPos pos) {
        ballPosition = pos;
    }

    private IntegerPos getBallPosition() {
        return ballPosition;
    }

    // moving
    private void moveToUpLeft() {
        int newX = getBallPosition().getX() - 1;
        int newY = getBallPosition().getY() + 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        relocate(newPos);
    }

    private void moveToUpRight() {
        int newX = getBallPosition().getX() + 1;
        int newY = getBallPosition().getY() + 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        relocate(newPos);
    }

    private void moveToDownLeft() {
        int newX = getBallPosition().getX() - 1;
        int newY = getBallPosition().getY() - 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        relocate(newPos);
    }

    private void moveToDownRight() {
        int newX = getBallPosition().getX() + 1;
        int newY = getBallPosition().getY() - 1;
        IntegerPos newPos = new IntegerPosition(newX, newY);

        relocate(newPos);
    }

    private void relocate(IntegerPos newPos) {
        setBallPosition(newPos);
    }

    // writing line
    private IntegerPos getNearestPositionByDirectionFromBall(BallDirection direction) {
        int x = getBallPosition().getX();
        int y = getBallPosition().getY();
        if (direction == BallDirection.UP_LEFT) {
            x--;
            y++;
        } else if (direction == BallDirection.UP_RIGHT) {
            x++;
            y++;
        } else if (direction == BallDirection.DOWN_LEFT) {
            x--;
            y--;
        } else if (direction == BallDirection.DOWN_RIGHT) {
            x++;
            y--;
        }
        return new IntegerPosition(x, y);
    }

    public Line getLineByDirection(BallDirection direction) {
        if (direction == BallDirection.UP_LEFT || direction == BallDirection.DOWN_RIGHT) {
            return new Line('\\');
        } else {
            return new Line('/');
        }
    }

    // checkers
    private boolean inAngle() {
        if (nearHorizontalWall() && nearVerticalWall()) {
            return true;
        }
        return false;
    }

    private boolean nearHorizontalWall() {
        int x = getBallPosition().getX();
        int xMin = getLocation().getXMinLimit();
        int xMax = getLocation().getXMaxLimit();

        if (x == xMin || x == xMax) {
            return true;
        }
        return false;
    }

    private boolean nearVerticalWall() {
        int y = getBallPosition().getY();
        int yMin = getLocation().getYMinLimit();
        int yMax = getLocation().getYMaxLimit();

        if (y == yMin || y == yMax) {
            return true;
        }
        return false;
    }

    // inner classes
    private enum BallDirection {
        UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT;

        public BallDirection opposite() {
            if (this == UP_LEFT) {
                return DOWN_RIGHT;
            } else if (this == UP_RIGHT) {
                return DOWN_LEFT;
            } else if (this == DOWN_LEFT) {
                return UP_RIGHT;
            } else {
                return UP_LEFT;
            }
        }
    }

    private class Line implements ObjectOnLocation {
        private char lineType;

        public Line(char line) {
            lineType = line;
        }

        @Override
        public String toString() {
            return String.valueOf(lineType);
        }
    }
}
