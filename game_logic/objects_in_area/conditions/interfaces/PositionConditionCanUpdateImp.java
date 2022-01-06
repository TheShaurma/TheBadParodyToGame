package game_logic.objects_in_area.conditions.interfaces;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_in_area.conditions.interfaces.cannot_update.PositionConditionCannotUpdateImp;

public interface PositionConditionCanUpdateImp extends PositionConditionCannotUpdateImp {
    void updatePosition(IntegerPos pos);
}
