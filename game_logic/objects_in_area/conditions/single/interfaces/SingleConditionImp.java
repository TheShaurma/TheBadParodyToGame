package game_logic.objects_in_area.conditions.single.interfaces;

import game_logic.objects_in_area.conditions.ConditionImp;

public interface SingleConditionImp<V> extends ConditionImp {
    V getValue();
}
