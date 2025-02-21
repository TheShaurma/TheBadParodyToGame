package TheBadParodyToGame.objectsInArea.movingObjects.entities;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;

public class DiedMobCannotMoveException extends CannotMoveObjectException {
    public DiedMobCannotMoveException(Position position, ObjectWithHP object) {
        super(position, object);
    }

    @Override
    public String toString() {
        return String.format(
                "Cannot move %s to %s cause it has died.",
                getObject().toString(),
                getPosition().toString());
    }
}
