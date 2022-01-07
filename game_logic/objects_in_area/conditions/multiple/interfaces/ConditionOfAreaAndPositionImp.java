package game_logic.objects_in_area.conditions.multiple.interfaces;

import game_logic.objects_in_area.conditions.ConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionImp;

public interface ConditionOfAreaAndPositionImp<AC extends AreaConditionImp<?>, PC extends PositionConditionImp<?>>
        extends ConditionImp {
    AC getAreaCondition();

    PC getPositionCondition();
}
