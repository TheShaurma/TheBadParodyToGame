package TheBadParodyToGame.area.position.exceptions;

import TheBadParodyToGame.area.position.Position;

public class PositionCannotExistInAreaException extends PositionException {
    public PositionCannotExistInAreaException(Position position) {
        super(position);
    }
}
