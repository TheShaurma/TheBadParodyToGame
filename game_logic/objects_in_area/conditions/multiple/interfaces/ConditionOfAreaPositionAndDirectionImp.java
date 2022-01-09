package game_logic.objects_in_area.conditions.multiple.interfaces;

import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.DirectionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.PositionConditionCanUpdateImp;

public interface ConditionOfAreaPositionAndDirectionImp<AC extends AreaConditionImp<?>, PC extends PositionConditionCanUpdateImp<?>, DC extends DirectionConditionCanUpdateImp>
        extends ConditionOfAreaAndPositionImp<AC, PC> {
    DC getDirectionCondition();
}
