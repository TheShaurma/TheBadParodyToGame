package TheBadParodyToGame.area.position;

public class EmptyPositionException extends PositionException {

    public EmptyPositionException(Position2D<?> position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Position is empty: " + getPosition();
    }
}
