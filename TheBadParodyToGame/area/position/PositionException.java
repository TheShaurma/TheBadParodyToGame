package TheBadParodyToGame.area.position;

public abstract class PositionException extends Exception {
    private final Position2D<?> position;

    public PositionException(Position2D<?> position) {
        this.position = position;
    }

    public Position2D<?> getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Problems with position: " + getPosition();
    }
}
