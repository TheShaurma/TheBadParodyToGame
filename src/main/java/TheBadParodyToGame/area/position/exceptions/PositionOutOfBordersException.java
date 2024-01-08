package TheBadParodyToGame.area.position.exceptions;

import TheBadParodyToGame.area.position.Position;

public class PositionOutOfBordersException extends PositionCannotExistInAreaException {

    public PositionOutOfBordersException(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return String.format("Position %s is out of borders in area.", getPosition());
    }
}
