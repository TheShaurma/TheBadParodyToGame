package game_logic.objects_on_location.object_conditions;

public enum ObjectDirection {
    UP, DOWN,
    LEFT, RIGHT,
    UP_LEFT,
    UP_RIGHT,
    DOWN_LEFT,
    DOWN_RIGHT;

    public ObjectDirection getOpposite() {
        return this.getShiftedHorizontally().getShiftedVertically();
    }

    public ObjectDirection getShiftedVertically() {
        switch (this) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case UP_LEFT:
                return DOWN_LEFT;
            case UP_RIGHT:
                return DOWN_RIGHT;
            case DOWN_LEFT:
                return UP_LEFT;
            case DOWN_RIGHT:
                return UP_RIGHT;
            default:
                return this;
        }
    }

    public ObjectDirection getShiftedHorizontally() {
        switch (this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            case UP_LEFT:
                return UP_RIGHT;
            case UP_RIGHT:
                return UP_LEFT;
            case DOWN_LEFT:
                return DOWN_RIGHT;
            case DOWN_RIGHT:
                return DOWN_LEFT;
            default:
                return this;
        }
    }

    public boolean isUp() {
        return this == UP || this == UP_LEFT || this == UP_RIGHT;
    }

    public boolean isDown() {
        return this == DOWN || this == DOWN_LEFT || this == DOWN_RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT || this == UP_LEFT || this == DOWN_LEFT;
    }

    public boolean isRight() {
        return this == RIGHT || this == UP_RIGHT || this == DOWN_RIGHT;
    }
}
