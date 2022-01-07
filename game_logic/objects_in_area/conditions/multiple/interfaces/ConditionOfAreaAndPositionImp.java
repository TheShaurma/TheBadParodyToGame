package game_logic.objects_in_area.conditions.multiple.interfaces;

import game_logic.objects_in_area.conditions.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.interfaces.PositionConditionImp;

public interface ConditionOfAreaAndPositionImp<AC extends AreaConditionImp, PC extends PositionConditionImp> {
    AC getAreaCondition();

    PC getPositionCondition();
}
