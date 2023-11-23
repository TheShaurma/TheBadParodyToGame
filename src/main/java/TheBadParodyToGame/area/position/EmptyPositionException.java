package TheBadParodyToGame.area.position;

public class EmptyPositionException extends PositionException {

    public EmptyPositionException(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Position is empty: " + getPosition();
    }
}
