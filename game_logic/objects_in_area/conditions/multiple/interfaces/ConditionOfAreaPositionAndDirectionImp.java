package game_logic.objects_in_area.conditions.multiple.interfaces;

import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionImp;

public interface ConditionOfAreaPositionAndDirectionImp<AC extends SingleConditionImp<? extends Area<?>>, PC extends SingleConditionImp<? extends Position<?>>, DC extends SingleConditionImp<Direction>>
        extends ConditionOfAreaAndPositionImp<AC, PC> {

    DC getDirectionCondition();
}
