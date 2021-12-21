package game_logic.objects_on_location.conditions.interfaces;

import game_logic.objects_on_location.conditions.Direction;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;

public interface DirectionConditionImp extends DirectionConditionCannotUpdateImp {
    void updateDirection(Direction dir);
}
