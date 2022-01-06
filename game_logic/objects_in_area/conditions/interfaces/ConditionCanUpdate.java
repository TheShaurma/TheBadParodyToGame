package game_logic.objects_in_area.conditions.interfaces;

public interface ConditionCanUpdate<T> extends ConditionCannotUpdate<T> {
    void setValue(T val);
}
