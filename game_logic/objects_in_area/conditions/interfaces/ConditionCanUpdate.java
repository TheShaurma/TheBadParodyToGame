package game_logic.objects_in_area.conditions.interfaces;

public interface ConditionCanUpdate<T> extends Condition<T> {
    void setValue(T val);
}
