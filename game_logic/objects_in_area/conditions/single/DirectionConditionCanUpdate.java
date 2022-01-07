package game_logic.objects_in_area.conditions.single;

import game_logic.objects_in_area.conditions.Direction;

import game_logic.objects_in_area.conditions.single.interfaces.DirectionConditionCanUpdateImp;

public class DirectionConditionCanUpdate implements DirectionConditionCanUpdateImp {
    private Direction direction;

    public DirectionConditionCanUpdate(Direction dir) {
        direction = dir;
    }

    public Direction getValue() {
        return direction;
    }

    public void setValue(Direction dir) {
        direction = dir;
    }
}
