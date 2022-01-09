package game_logic.objects_in_area.conditions.single.interfaces;

public interface SingleConditionHasPastImp<V> extends SingleConditionCanUpdateImp<V> {
    V getPastValue();
}
