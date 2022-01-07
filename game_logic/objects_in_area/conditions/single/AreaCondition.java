package game_logic.objects_in_area.conditions.single;

import game_logic.abstractions.interfaces.Area;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;

public class AreaCondition<T extends Area<?>> implements AreaConditionImp<T> {
    private T area;

    public AreaCondition(T a) {
        area = a;
    }

    public T getValue() {
        return area;
    }
}
