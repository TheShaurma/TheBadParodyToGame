package game_logic.objects_in_area.conditions.multiple;

import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaPositionAndDirectionImp;
import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionImp;

public class ConditionOfAreaPositionAndDirection<AC extends SingleConditionImp<Area<?>>, PC extends SingleConditionImp<Position<?>>, DC extends SingleConditionImp<Direction>>
        extends ConditionOfAreaAndPosition<AC, PC> implements ConditionOfAreaPositionAndDirectionImp<AC, PC, DC> {

    private DC directionCondition;

    public ConditionOfAreaPositionAndDirection(AC ac, PC pc, DC dc) {
        super(ac, pc);

        directionCondition = dc;
    }

    public DC getDirectionCondition() {
        return directionCondition;
    }
}