package game_logic.objects_in_area.conditions.multiple;

import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaAndPositionImp;
import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionImp;

public class ConditionOfAreaAndPosition<AC extends SingleConditionImp<Area<?>>, PC extends SingleConditionImp<Position<?>>>
        implements ConditionOfAreaAndPositionImp<AC, PC> {
    private AC areaCondition;
    private PC positionCondition;

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
