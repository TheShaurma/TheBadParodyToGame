package game_logic.objects_on_zone.conditions.interfaces;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_zone.conditions.interfaces.cannot_update.PositionConditionCannotUpdateImp;

public interface PositionConditionCanUpdateImp extends PositionConditionCannotUpdateImp {
    void updatePosition(IntegerPos pos);
}
