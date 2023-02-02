package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// FIXME: shouldn't extends from PositionException
public abstract class ObjectException extends PositionException {
    private ObjectInArea object;

    /**
     * @param position where problem appeared;
     * @param object   which have the problem;
     */
    public ObjectException(IntegerPosition2D position, ObjectInArea object) {
        super(position);
        this.object = object;
    }

    public final ObjectInArea getObject() {
        return this.object;
    }
}
