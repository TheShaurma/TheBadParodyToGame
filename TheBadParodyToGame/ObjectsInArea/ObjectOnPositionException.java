package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionException;

public abstract class ObjectOnPositionException extends PositionException {
    private ObjectInArea object;

    /**
     * @param position where problem appeared;
     * @param object   which have the problem;
     */
    public ObjectOnPositionException(Position position, ObjectInArea object) {
        super(position);
        this.object = object;
    }

    public final ObjectInArea getObject() {
        return this.object;
    }
}
