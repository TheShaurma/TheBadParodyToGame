package TheBadParodyToGame.objectsInArea;

import TheBadParodyToGame.area.position.Position;

/**
 * Object cannot check if it's still at position.
 */
public abstract class ObjectKnowsPosition implements ObjectInArea {
    private final Position position;

    public ObjectKnowsPosition(Position pos) {
        position = pos;
    }

    protected Position getPosition() {
        return position;
    }
}
