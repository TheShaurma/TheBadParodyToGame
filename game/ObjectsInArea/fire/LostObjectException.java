package game.ObjectsInArea.fire;

import game.area.position.Position2D;
import game.area.position.PositionException;

public class LostObjectException extends PositionException {
    public LostObjectException(Position2D<?> position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Manager lost its object in position:" + getPosition() + ".";
    }
}
