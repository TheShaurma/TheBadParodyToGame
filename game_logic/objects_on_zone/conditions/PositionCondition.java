package game_logic.objects_on_zone.conditions;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_zone.conditions.interfaces.PositionConditionCanUpdateImp;

public class PositionCondition implements PositionConditionCanUpdateImp {
    private IntegerPos position;

    public PositionCondition(IntegerPos pos) {
        position = pos;
    }

    public void updatePosition(IntegerPos pos) {
        position = pos;
    }

    public IntegerPos getPosition() {
        return position;
    }
}
