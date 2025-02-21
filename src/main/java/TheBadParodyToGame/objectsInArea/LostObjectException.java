package TheBadParodyToGame.objectsInArea;

import TheBadParodyToGame.area.position.Position;

public class LostObjectException extends ObjectOnPositionException {
    public LostObjectException(Position pos, ObjectInArea obj) {
        super(pos, obj);
    }

    @Override
    public String toString() {
        return String.format("%s was waited on %s but it wasn't there.", getObject(), getPosition());
    }
}
