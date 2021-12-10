package game_logic.objects_on_location.conditions.interfaces;

import game_logic.abstractions.interfaces.IntegerPos;

public interface PositionConditionImp {
    IntegerPos getPosition();

    void updatePosition(IntegerPos pos);
}
