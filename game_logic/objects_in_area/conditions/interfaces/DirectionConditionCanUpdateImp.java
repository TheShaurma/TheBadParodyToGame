package game_logic.objects_in_area.conditions.interfaces;

import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;

public interface DirectionConditionCanUpdateImp extends DirectionConditionCannotUpdateImp {
    void updateDirection(Direction dir);
}
