package game_logic.objects_in_area.conditions.single;

import game_logic.objects_in_area.conditions.single.interfaces.ConditionCanUpdate;
import game_logic.objects_in_area.conditions.single.interfaces.DirectionConditionImp;

public class DirectionConditionCanUpdate implements ConditionCanUpdate<Direction>, DirectionConditionImp {
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
