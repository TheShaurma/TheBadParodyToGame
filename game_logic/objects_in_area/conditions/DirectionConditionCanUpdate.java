package game_logic.objects_in_area.conditions;

import game_logic.objects_in_area.conditions.interfaces.ConditionCanUpdate;

public class DirectionConditionCanUpdate implements ConditionCanUpdate<Direction> {
    Direction direction;

    public Direction getValue() {
        return direction;
    }

    public void setValue(Direction dir) {
        direction = dir;
    }
}
