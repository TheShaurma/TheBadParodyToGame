package game_logic.objects_in_area.conditions.single;

import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionCanUpdateImp;

public class SingleConditionCanUpdate<V> extends SingleCondition<V> implements SingleConditionCanUpdateImp<V> {

    public SingleConditionCanUpdate(V val) {
        super(val);
    }

    public void setValue(V val) {
        value = val;
    }

}
