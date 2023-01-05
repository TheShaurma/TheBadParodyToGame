package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.IntegerPosition2D;

public class LostObjectException extends ObjectException {
    public LostObjectException(IntegerPosition2D pos, ObjectInArea obj) {
        super(pos, obj);
    }

    @Override
    public String toString() {
        return "Manager lost its object in position:" + getPosition() + ".";
    }
}
