package game_logic.objects_in_area.conditions.single.interfaces.has_past;

import game_logic.objects_in_area.conditions.single.interfaces.SingleCondition;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.ConditionCanUpdate;

public interface ConditionHasPast<T> extends ConditionCanUpdate<T> {
    SingleCondition<T> getPastValue();
}
