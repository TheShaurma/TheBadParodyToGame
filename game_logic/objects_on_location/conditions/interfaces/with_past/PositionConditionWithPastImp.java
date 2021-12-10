package game_logic.objects_on_location.conditions.interfaces.with_past;

import game_logic.objects_on_location.conditions.interfaces.PositionConditionImp;

public interface PositionConditionWithPastImp extends PositionConditionImp {
    PositionConditionImp getPast();
}
