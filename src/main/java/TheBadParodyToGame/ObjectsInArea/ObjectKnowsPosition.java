package TheBadParodyToGame.objectsInArea;

import TheBadParodyToGame.area.position.Position;

/**
 * Object cannot check if it's still at position.
 */
public abstract class ObjectKnowsPosition extends AbstractObject {
    private Position position;

    public ObjectKnowsPosition(Position pos) {
        position = pos;
    }

    protected Position getPosition() {
        return position;
    }

    protected void setPosition(Position pos) {
        position = pos;
    }
}
