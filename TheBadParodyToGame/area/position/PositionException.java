package TheBadParodyToGame.area.position;

public abstract class PositionException extends Exception {
    private final IntegerPosition2D position;

    public PositionException(IntegerPosition2D position) {
        this.position = position;
    }

    public final IntegerPosition2D getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Problems with position: " + getPosition();
    }
}
