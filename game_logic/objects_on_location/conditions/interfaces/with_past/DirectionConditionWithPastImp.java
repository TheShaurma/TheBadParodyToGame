package game_logic.objects_on_location.conditions.interfaces.with_past;

import game_logic.objects_on_location.conditions.interfaces.DirectionConditionCanUpdateImp;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;

public interface DirectionConditionWithPastImp extends DirectionConditionCanUpdateImp {
    DirectionConditionCannotUpdateImp getPast();
}
