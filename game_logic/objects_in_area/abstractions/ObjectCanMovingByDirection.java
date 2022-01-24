package game_logic.objects_in_area.abstractions;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_in_area.conditions.Direction;

public abstract class ObjectCanMovingByDirection extends ObjectCanMoving<CheckeredArea, IntegerPos> {
    private Direction direction;

    public ObjectCanMovingByDirection(CheckeredArea ar, IntegerPos pos) throws PositionException {
        super(ar, pos);
    }

    protected void setDirection(Direction dir) {
        direction = dir;
    }

    protected Direction getDirection() {
        return direction;
    }
}
