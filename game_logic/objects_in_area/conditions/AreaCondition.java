package game_logic.objects_in_area.conditions;

import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.objects_in_area.conditions.interfaces.cannot_update.AreaConditionImp;

public class AreaCondition implements AreaConditionImp {
    private final CheckeredArea location;

    public AreaCondition(CheckeredArea loc) {
        location = loc;
    }

    public CheckeredArea getLocation() {
        return location;
    }
}
