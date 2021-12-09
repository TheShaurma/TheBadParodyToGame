package game_logic.objects_on_location.conditions;

import game_logic.objects_on_location.conditions.interfaces.ConditionOfDirectionImp;

public class ConditionOfDirection implements ConditionOfDirectionImp {
    private Direction direction;

    public ConditionOfDirection(Direction dir) {
        direction = dir;
    }

    public void updateDirection(Direction dir) {
        direction = dir;
    }

    public Direction getDirection() {
        return direction;
    }
}
