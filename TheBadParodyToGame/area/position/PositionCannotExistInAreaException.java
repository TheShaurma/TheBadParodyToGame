package TheBadParodyToGame.area.position;

public class PositionCannotExistInAreaException extends PositionException {
    public PositionCannotExistInAreaException(IntegerPosition2D position) {
        super(position);
    }
}
