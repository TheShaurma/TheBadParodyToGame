package game_logic.objects_in_area.conditions.multiple.interfaces;

import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.ConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionImp;

public interface ConditionOfAreaAndPositionImp<AC extends SingleConditionImp<? extends Area<?>>, PC extends SingleConditionImp<? extends Position<?>>>
        extends ConditionImp {

    AC getAreaCondition();

    PC getPositionCondition();
}
