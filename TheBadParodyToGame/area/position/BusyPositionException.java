package TheBadParodyToGame.area.position;

public class BusyPositionException extends PositionException {

    public BusyPositionException(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Position is busy: " + getPosition();
    }
}
