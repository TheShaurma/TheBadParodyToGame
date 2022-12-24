package TheBadParodyToGame.ObjectsInArea;

import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class LostObjectException extends PositionException {
    private ObjectInArea object;

    public LostObjectException(IntegerPosition2D position, ObjectInArea object) {
        super(position);
        this.object = object;
    }

    @Override
    public String toString() {
        return "Manager lost its object in position:" + getPosition() + ".";
    }

    public ObjectInArea getObject() {
        return this.object;
    }
}
