package game_logic.objects_on_location.conditions;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.conditions.interfaces.PositionConditionImp;

public class PositionCondition implements PositionConditionImp {
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
