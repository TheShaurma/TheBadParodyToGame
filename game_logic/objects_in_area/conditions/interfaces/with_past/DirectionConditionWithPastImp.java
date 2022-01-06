package game_logic.objects_in_area.conditions.interfaces.with_past;

import game_logic.objects_in_area.conditions.interfaces.DirectionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;

public interface DirectionConditionWithPastImp extends DirectionConditionCanUpdateImp {
    DirectionConditionCannotUpdateImp getPast();
}
