package game_logic.objects_on_zone.conditions;

import game_logic.objects_on_zone.conditions.interfaces.DirectionConditionCanUpdateImp;

public class DirectionCondition implements DirectionConditionCanUpdateImp {
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
