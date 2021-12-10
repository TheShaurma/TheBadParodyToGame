package game_logic.objects_on_location.conditions.interfaces.with_past;

import game_logic.objects_on_location.conditions.interfaces.DirectionConditionImp;

public interface DirectionConditionWithPastImp extends DirectionConditionImp {
    DirectionConditionImp getPast();
}
