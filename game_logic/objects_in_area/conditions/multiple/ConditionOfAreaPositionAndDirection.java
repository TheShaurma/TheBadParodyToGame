package game_logic.objects_in_area.conditions.multiple;

import game_logic.objects_in_area.conditions.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.interfaces.DirectionConditionImp;
import game_logic.objects_in_area.conditions.interfaces.PositionConditionImp;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaPositionAndDirectionImp;

public class ConditionOfAreaPositionAndDirection<AC extends AreaConditionImp, PC extends PositionConditionImp, DC extends DirectionConditionImp>
        extends ConditionOfAreaAndPosition<AC, PC> implements ConditionOfAreaPositionAndDirectionImp<AC, PC, DC> {
    private final DC directionCondition;

    protected ConditionOfAreaPositionAndDirection(AC ac, PC pc, DC dc) {
        super(ac, pc);
        directionCondition = dc;
    }

    public DC getDirectionCondition() {
        return directionCondition;
    }
}
