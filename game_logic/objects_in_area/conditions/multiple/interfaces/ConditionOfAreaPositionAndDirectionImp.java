package game_logic.objects_in_area.conditions.multiple.interfaces;

import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.DirectionConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionImp;

public interface ConditionOfAreaPositionAndDirectionImp<AC extends AreaConditionImp<?>, PC extends PositionConditionImp<?>, DC extends DirectionConditionImp>
        extends ConditionOfAreaAndPositionImp<AC, PC> {
    DC getDirectionCondition();
}
