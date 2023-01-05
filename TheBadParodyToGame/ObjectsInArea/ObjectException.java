package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// FIXME: showldn't extend from PositionException
public abstract class ObjectException extends PositionException {
    private ObjectInArea object;

    public ObjectException(IntegerPosition2D position, ObjectInArea object) {
        super(position);
        this.object = object;
    }

    public final ObjectInArea getObject() {
        return this.object;
    }
}
