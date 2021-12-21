package game_logic.objects_on_location.conditions.interfaces.with_past;

import game_logic.objects_on_location.conditions.interfaces.PositionConditionCanUpdateImp;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.PositionConditionCannotUpdateImp;

public interface PositionConditionWithPastImp extends PositionConditionCanUpdateImp {
    PositionConditionCannotUpdateImp getPast();
}
