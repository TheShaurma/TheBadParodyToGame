package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.ObjectOnPositionException;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.Position;

public class PlayerDiedException extends ObjectOnPositionException {
    /**
     * @param position where problem appeared;
     * @param object   which have the problem;
     */
    public PlayerDiedException(Position position, ObjectInArea object) {
        super(position, object);
    }

    @Override
    public String toString() {
        return "Player died at position: " + getPosition();
    }
}
