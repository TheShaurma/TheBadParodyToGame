package game_logic.objects_on_location.object_conditions;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.object_conditions.interfaces.ObjectConditionOfPositionImp;

public class ObjectConditionOfPosition implements ObjectConditionOfPositionImp {
    private IntegerPos position;

    public ObjectConditionOfPosition() {
    }

    public ObjectConditionOfPosition(IntegerPos pos) {
        position = pos;
    }

    public void updatePosition(IntegerPos pos) {
        position = pos;
    }

    public IntegerPos getPosition() {
        return position;
    }
}
