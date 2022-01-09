package game_logic.objects_in_area.conditions.single;

import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionImp;

public class SingleCondition<V> implements SingleConditionImp<V> {
    protected V value;

    public SingleCondition(V val) {
        value = val;
    }

    public V getValue() {
        return value;
    }
}
