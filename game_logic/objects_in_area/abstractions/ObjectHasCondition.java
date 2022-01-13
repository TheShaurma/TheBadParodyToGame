package game_logic.objects_in_area.abstractions;

import game_logic.abstractions.interfaces.ObjectInArea;
import game_logic.objects_in_area.conditions.ConditionImp;

public abstract class ObjectHasCondition<C extends ConditionImp> implements ObjectInArea {
    private C condition;

    protected ObjectHasCondition(C cond) {
        condition = cond;
    }

    protected C getCondition() {
        return condition;
    }
}
