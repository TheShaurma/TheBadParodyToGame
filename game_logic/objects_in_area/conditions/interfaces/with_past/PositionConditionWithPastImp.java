package game_logic.objects_in_area.conditions.interfaces.with_past;

import game_logic.objects_in_area.conditions.interfaces.PositionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.interfaces.cannot_update.PositionConditionCannotUpdateImp;

public interface PositionConditionWithPastImp extends PositionConditionCanUpdateImp {
    PositionConditionCannotUpdateImp getPast();
}
