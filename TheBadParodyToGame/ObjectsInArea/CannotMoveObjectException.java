package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.IntegerPosition2D;

public class CannotMoveObjectException extends ManageObjectException {
    public CannotMoveObjectException(IntegerPosition2D position, ObjectInArea object) {
        super(position, object);
    }

    @Override
    public String toString() {
        return "Cannot move " + getObject() + " to " + getPosition() + ".";
    }
}
