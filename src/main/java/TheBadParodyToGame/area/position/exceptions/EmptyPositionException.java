package TheBadParodyToGame.area.position.exceptions;

import TheBadParodyToGame.area.position.Position;

public class EmptyPositionException extends PositionException {

    public EmptyPositionException(Position position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Position is empty: " + getPosition();
    }
}
