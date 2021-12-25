package game_logic.objects_on_zone.conditions.interfaces;

import game_logic.objects_on_zone.conditions.Direction;
import game_logic.objects_on_zone.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;

public interface DirectionConditionCanUpdateImp extends DirectionConditionCannotUpdateImp {
    void updateDirection(Direction dir);
}
