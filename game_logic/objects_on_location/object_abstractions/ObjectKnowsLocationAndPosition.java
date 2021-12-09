package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.Location;
import game_logic.objects_on_location.conditions.ConditionOfPosition;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfLocationImp;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfPositionImp;

public abstract class ObjectKnowsLocationAndPosition extends ObjectKnowsLocation {
    private ConditionOfPositionImp positionCondition;

    public ObjectKnowsLocationAndPosition(Location loc, IntegerPos pos) {
        super(loc);
        positionCondition = new ConditionOfPosition(pos);
    }

    protected ObjectKnowsLocationAndPosition(ConditionOfLocationImp locationCond, ConditionOfPositionImp positionCond) {
        super(locationCond);
        positionCondition = positionCond;
    }

    protected ConditionOfPositionImp getPositionCondition() {
        return positionCondition;
    }
}
