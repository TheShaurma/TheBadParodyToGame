package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.Position;

public class LostObjectException extends ObjectOnPositionException {
    public LostObjectException(Position pos, ObjectInArea obj) {
        super(pos, obj);
    }

    @Override
    public String toString() {
        return "Manager lost its object in position:" + getPosition() + ".";
    }
}
