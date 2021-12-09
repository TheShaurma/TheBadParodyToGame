package game_logic.objects_on_location.object_conditions.interfaces;

import game_logic.abstractions.interfaces.IntegerPos;

public interface ObjectConditionOfPositionImp {
    IntegerPos getPosition();

    void updatePosition(IntegerPos pos);
}
