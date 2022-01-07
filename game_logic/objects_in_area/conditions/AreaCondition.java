package game_logic.objects_in_area.conditions;

import game_logic.abstractions.interfaces.Area;
import game_logic.objects_in_area.conditions.interfaces.AreaConditionImp;

public class AreaCondition implements AreaConditionImp {
    private Area<?> area;

    public AreaCondition(Area<?> a) {
        area = a;
    }

    public Area<?> getValue() {
        return area;
    }
}
