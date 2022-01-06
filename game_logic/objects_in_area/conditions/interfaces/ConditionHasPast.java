package game_logic.objects_in_area.conditions.interfaces;

public interface ConditionHasPast<T> extends ConditionCanUpdate<T> {
    T getPastValue();
}
