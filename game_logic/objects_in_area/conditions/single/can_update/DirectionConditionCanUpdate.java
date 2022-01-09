package game_logic.objects_in_area.conditions.single.can_update;

import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.DirectionConditionCanUpdateImp;

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
