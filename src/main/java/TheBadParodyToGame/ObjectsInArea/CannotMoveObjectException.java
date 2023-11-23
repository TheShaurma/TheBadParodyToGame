package TheBadParodyToGame.objectsInArea;

import TheBadParodyToGame.area.position.Position;

// TODO: create tests for CannotMoveObjectException
/**
 * CannotMoveObjectException should be thrown were object manager can't move
 * object.
 */
public class CannotMoveObjectException extends ObjectOnPositionException {
    /**
     * @param position where manager can't move object;
     * @param object   which can't be moved;
     */
    public CannotMoveObjectException(Position position, ObjectInArea object) {
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
