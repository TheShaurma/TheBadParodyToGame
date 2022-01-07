package game_logic.objects_in_area.objects_abstractions.has_conditions;

import game_logic.abstractions.interfaces.ObjectInArea;
import game_logic.objects_in_area.conditions.ConditionImp;

public abstract class ObjectInAreaHasCondition<C extends ConditionImp> implements ObjectInArea {
    private final C condition;

    protected ObjectInAreaHasCondition(C cond) {
        condition = cond;
    }

    protected C getCondition() {
        return condition;
    }
}
