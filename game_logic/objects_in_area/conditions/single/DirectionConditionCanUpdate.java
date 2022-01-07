package game_logic.objects_in_area.conditions.single;

import game_logic.objects_in_area.conditions.single.interfaces.ConditionCanUpdate;
import game_logic.objects_in_area.conditions.single.interfaces.DirectionConditionImp;

public class DirectionConditionCanUpdate implements ConditionCanUpdate<Direction>, DirectionConditionImp {
    Direction direction;

    public Direction getValue() {
        return direction;
    }

    public void setValue(Direction dir) {
        direction = dir;
    }
}
