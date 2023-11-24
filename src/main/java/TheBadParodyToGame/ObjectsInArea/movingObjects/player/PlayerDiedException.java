package TheBadParodyToGame.objectsInArea.movingObjects.player;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.objectsInArea.ObjectInArea;
import TheBadParodyToGame.objectsInArea.ObjectOnPositionException;

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
