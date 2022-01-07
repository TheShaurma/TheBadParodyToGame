package game_logic.objects_in_area.conditions.multiple.interfaces;

import game_logic.objects_in_area.conditions.ConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionCanUpdateImp;

public interface ConditionOfAreaAndPositionImp<AC extends AreaConditionImp<?>, PC extends PositionConditionCanUpdateImp<?>>
        extends ConditionImp {
    AC getAreaCondition();

    PC getPositionCondition();
}
