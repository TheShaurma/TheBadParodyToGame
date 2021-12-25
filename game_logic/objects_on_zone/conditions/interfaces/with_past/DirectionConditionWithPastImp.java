package game_logic.objects_on_zone.conditions.interfaces.with_past;

import game_logic.objects_on_zone.conditions.interfaces.DirectionConditionCanUpdateImp;
import game_logic.objects_on_zone.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;

public interface DirectionConditionWithPastImp extends DirectionConditionCanUpdateImp {
    DirectionConditionCannotUpdateImp getPast();
}
