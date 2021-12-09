package game_logic.objects_on_location.conditions;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfPositionImp;

public class ConditionOfPosition implements ConditionOfPositionImp {
    private IntegerPos position;

    public ConditionOfPosition(IntegerPos pos) {
        position = pos;
    }

    public void updatePosition(IntegerPos pos) {
        position = pos;
    }

    public IntegerPos getPosition() {
        return position;
    }
}
