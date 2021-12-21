package game_logic.objects_on_location.conditions.interfaces;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.PositionConditionCannotUpdateImp;

public interface PositionConditionImp extends PositionConditionCannotUpdateImp {
    void updatePosition(IntegerPos pos);
}
