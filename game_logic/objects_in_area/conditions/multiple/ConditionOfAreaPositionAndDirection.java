package game_logic.objects_in_area.conditions.multiple;

import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaPositionAndDirectionImp;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.DirectionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionCanUpdateImp;

public class ConditionOfAreaPositionAndDirection<AC extends AreaConditionImp<?>, PC extends PositionConditionCanUpdateImp<?>, DC extends DirectionConditionCanUpdateImp>
        extends ConditionOfAreaAndPosition<AC, PC> implements ConditionOfAreaPositionAndDirectionImp<AC, PC, DC> {
    private final DC directionCondition;

    public ConditionOfAreaPositionAndDirection(AC ac, PC pc, DC dc) {
        super(ac, pc);
        directionCondition = dc;
    }

    public DC getDirectionCondition() {
        return directionCondition;
    }
}
