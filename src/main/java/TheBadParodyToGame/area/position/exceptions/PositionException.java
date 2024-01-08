package TheBadParodyToGame.area.position.exceptions;

import TheBadParodyToGame.area.position.Position;

public abstract class PositionException extends Exception {
    private final Position position;

    public PositionException(Position position) {
        this.position = position;
    }

    public final Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Problems with position: " + getPosition();
    }
}
