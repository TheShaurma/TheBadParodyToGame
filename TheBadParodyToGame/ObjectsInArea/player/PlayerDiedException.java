package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.ObjectException;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public class PlayerDiedException extends ObjectException {
    /**
     * @param position where problem appeared;
     * @param object   which have the problem;
     */
    public PlayerDiedException(IntegerPosition2D position, ObjectInArea object) {
        super(position, object);
    }

    @Override
    public String toString() {
        return "Player died at position: " + getPosition();
    }
}
