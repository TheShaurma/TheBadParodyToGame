package game_logic.objects_in_area.conditions.single.interfaces;

import game_logic.objects_in_area.conditions.ConditionImp;

public interface SingleCondition<T> extends ConditionImp {
    T getValue();
}
