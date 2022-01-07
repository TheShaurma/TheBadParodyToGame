package game_logic.objects_in_area.conditions.multiple;

import game_logic.objects_in_area.conditions.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.interfaces.PositionConditionImp;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaAndPositionImp;

public class ConditionOfAreaAndPosition<AC extends AreaConditionImp, PC extends PositionConditionImp>
        implements ConditionOfAreaAndPositionImp<AC, PC> {
    private final AC areaCondition;
    private final PC positionCondition;

    protected ConditionOfAreaAndPosition(AC ac, PC pc) {
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
