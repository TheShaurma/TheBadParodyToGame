package game_logic.objects_in_area.conditions.single.interfaces;

public interface ConditionCanUpdate<T> extends SingleCondition<T> {
    void setValue(T val);
}
