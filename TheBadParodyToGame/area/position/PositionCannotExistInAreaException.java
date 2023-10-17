package TheBadParodyToGame.area.position;

public class PositionCannotExistInAreaException extends PositionException {
    public PositionCannotExistInAreaException(Position position) {
        super(position);
    }
}
