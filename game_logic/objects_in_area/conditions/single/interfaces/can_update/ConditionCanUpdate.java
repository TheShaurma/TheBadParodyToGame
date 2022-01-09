package game_logic.objects_in_area.conditions.single.interfaces.can_update;

import game_logic.objects_in_area.conditions.single.interfaces.SingleCondition;

public interface ConditionCanUpdate<T> extends SingleCondition<T> {
    void setValue(T val);
}
