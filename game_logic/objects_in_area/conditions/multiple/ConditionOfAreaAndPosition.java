package game_logic.objects_in_area.conditions.multiple;

import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaAndPositionImp;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionImp;

public class ConditionOfAreaAndPosition<AC extends AreaConditionImp<?>, PC extends PositionConditionImp<?>>
        implements ConditionOfAreaAndPositionImp<AC, PC> {
    private final AC areaCondition;
    private final PC positionCondition;

    public ConditionOfAreaAndPosition(AC ac, PC pc) {
        areaCondition = ac;
        positionCondition = pc;
    }

    public AC getAreaCondition() {
        return areaCondition;
    }

    public PC getPositionCondition() {
        return positionCondition;
    }
}
