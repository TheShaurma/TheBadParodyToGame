package game_logic;

import game_logic.intarfaces.IntegerPos;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.ObjectOnLocation;

public class BallManager {
    private Ball ball;
    private Location location;

    public BallManager(Location location) {
        setLocation(location);
        ball = new Ball(new IntegerPosition(location.getXMinLimit(), location.getYMaxLimit()));
    }

    public void fly() {
        while (!inAngle()) {
            step();
        }
    }

    public void step() {
        if (!inAngle()) {
            if (shouldWriteLineInBallPosition()) {
                writeLineInBallPosition();
            }
            moveBall();
        }
    }

    private void moveBall() {
        if (ball.getDirection() == Direction.UP_LEFT) {
            moveUpLeft();
        } else if (ball.getDirection() == Direction.UP_RIGHT) {
            moveUpRight();
        } else if (ball.getDirection() == Direction.DOWN_LEFT) {
            moveDownLeft();
        } else if (ball.getDirection() == Direction.DOWN_RIGHT) {
            moveDownRight();
        }
    }

    private void writeLineInBallPosition() {
        Location location = getLocation();

        location.putObject(ball.getCurrentPosition(), new Line(ball.getDirection()));
    }

    // getters and setters
    private void setLocation(Location loc) {
        location = loc;
    }

    private Location getLocation() {
        return location;
    }

    //
    private void moveUpRight() {
        IntegerPos oldBallPos = ball.getCurrentPosition();
        int x = oldBallPos.getX() + 1;
        int y = oldBallPos.getY() + 1;

        ball.setCurrentPosition(x, y);
    }

    private void moveUpLeft() {
        IntegerPos oldBallPos = ball.getCurrentPosition();
        int x = oldBallPos.getX() - 1;
        int y = oldBallPos.getY() + 1;

        ball.setCurrentPosition(x, y);
    }

    private void moveDownLeft() {
        IntegerPos oldBallPos = ball.getCurrentPosition();
        int x = oldBallPos.getX() - 1;
        int y = oldBallPos.getY() - 1;

        ball.setCurrentPosition(x, y);
    }

    private void moveDownRight() {
        IntegerPos oldBallPos = ball.getCurrentPosition();
        int x = oldBallPos.getX() + 1;
        int y = oldBallPos.getY() - 1;

        ball.setCurrentPosition(x, y);
    }

    // checkers
    private boolean shouldWriteLineInBallPosition() {
        IntegerPos pastBallPos = ball.getPastPosition();

        if (getLocation().getObject(pastBallPos) instanceof Line) {
            return false;
        }
        return true;
    }

    private boolean inAngle() {
        return nearVerticalWall() && nearHorizontalWall();
    }

    private boolean nearHorizontalWall() {
        return nearUpperWall() || nearLowerWall();
    }

    private boolean nearVerticalWall() {
        return nearLeftWall() || nearRightWall();
    }

    private boolean nearUpperWall() {
        int ballY = ball.getCurrentPosition().getY();
        int yMax = getLocation().getYMaxLimit();

        return ballY == yMax;
    }

    private boolean nearLowerWall() {
        int ballY = ball.getCurrentPosition().getY();
        int yMin = getLocation().getYMinLimit();

        return ballY == yMin;
    }

    private boolean nearLeftWall() {
        int ballX = ball.getCurrentPosition().getX();
        int xMin = getLocation().getXMinLimit();

        return ballX == xMin;
    }

    private boolean nearRightWall() {
        int ballX = ball.getCurrentPosition().getX();
        int xMax = getLocation().getXMaxLimit();

        return ballX == xMax;
    }

    // inner classes
    protected class Ball {
        private IntegerPos currentPosition;
        private IntegerPos pastPosition;
        private Direction direction;

        public Ball(IntegerPos startPosition, Direction startDirection) {
            setCurrentPosition(startPosition);
            setDirection(startDirection);
            setPastPosition(startPosition);
        }

        /**
         * Start direction will be Direction.DOWN_RIGHT
         */
        public Ball(IntegerPos startPosition) {
            setCurrentPosition(startPosition);
            setDirection(Direction.DOWN_RIGHT);
            setPastPosition(startPosition);
        }

        public void setCurrentPosition(IntegerPos pos) {
            setPastPosition(getCurrentPosition());
            currentPosition = pos;
        }

        public void setCurrentPosition(int x, int y) {
            setCurrentPosition(new IntegerPosition(x, y));
        }

        public IntegerPos getCurrentPosition() {
            return currentPosition;
        }

        public void setDirection(Direction dir) {
            direction = dir;
        }

        public Direction getDirection() {
            return direction;
        }

        private void setPastPosition(IntegerPos pos) {
            pastPosition = pos;
        }

        public IntegerPos getPastPosition() {
            return pastPosition;
        }
    }

    private enum Direction {
        UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;
    }

    private class Line implements ObjectOnLocation {
        Direction direction;

        public Line(Direction dir) {
            direction = dir;
        }

        @Override
        public String toString() {
            if (direction == Direction.UP_LEFT || direction == Direction.DOWN_LEFT) {
                return "\\";
            } else {
                return "/";
            }
        }
    }
}
