package game_logic.objects_in_area.conditions;

import game_logic.objects_in_area.conditions.interfaces.DirectionConditionCanUpdateImp;

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
