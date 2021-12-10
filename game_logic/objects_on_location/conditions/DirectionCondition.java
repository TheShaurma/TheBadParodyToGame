package game_logic.objects_on_location.conditions;

import game_logic.objects_on_location.conditions.interfaces.DirectionConditionImp;

public class DirectionCondition implements DirectionConditionImp {
    private Direction direction;

    public DirectionCondition(Direction dir) {
        direction = dir;
    }

    public void updateDirection(Direction dir) {
        direction = dir;
    }

    public Direction getDirection() {
        return direction;
    }
}
