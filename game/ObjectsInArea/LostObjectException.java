package game.ObjectsInArea;

import game.area.position.Position2D;
import game.area.position.PositionException;

public class LostObjectException extends PositionException {
    private ObjectInArea object;

    public LostObjectException(Position2D<?> position, ObjectInArea object) {
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
