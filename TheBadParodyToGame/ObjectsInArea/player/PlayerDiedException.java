package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class PlayerDiedException extends PositionException {
    public PlayerDiedException(IntegerPosition2D position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Player died at position: " + getPosition();
    }
}
