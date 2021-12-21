package game_logic.objects_on_location.conditions.interfaces.with_past;

import game_logic.objects_on_location.conditions.interfaces.DirectionConditionImp;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;

public interface DirectionConditionWithPastImp extends DirectionConditionImp {
    DirectionConditionCannotUpdateImp getPast();
}
