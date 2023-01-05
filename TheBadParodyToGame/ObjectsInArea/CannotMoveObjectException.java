package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.IntegerPosition2D;

// TODO: create tests for CannotMoveObjectException
/**
 * CannotMoveObjectException should be thrown were object manager can't move
 * object.
 */
public class CannotMoveObjectException extends ObjectException {
    /**
     * @param position where manager can't move object;
     * @param object   which can't be moved;
     */
    public CannotMoveObjectException(IntegerPosition2D position, ObjectInArea object) {
        super(position, object);
    }

    /**
     * Return information in string.
     * 
     * @return {@code "Cannot move " + getObject() + " to " + getPosition() + "."}
     */
    @Override
    public String toString() {
        return "Cannot move " + getObject() + " to " + getPosition() + ".";
    }
}
