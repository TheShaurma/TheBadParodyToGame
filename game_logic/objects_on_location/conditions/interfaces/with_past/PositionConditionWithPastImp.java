package game_logic.objects_on_location.conditions.interfaces.with_past;

import game_logic.objects_on_location.conditions.interfaces.PositionConditionImp;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.PositionConditionCannotUpdateImp;

public interface PositionConditionWithPastImp extends PositionConditionImp {
    PositionConditionCannotUpdateImp getPast();
}
