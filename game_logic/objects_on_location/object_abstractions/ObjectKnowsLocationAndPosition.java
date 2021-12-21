package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.Location;
import game_logic.objects_on_location.conditions.PositionCondition;
import game_logic.objects_on_location.conditions.interfaces.PositionConditionCanUpdateImp;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.LocationConditionImp;

public abstract class ObjectKnowsLocationAndPosition extends ObjectKnowsLocation {
    private PositionConditionCanUpdateImp positionCondition;

    public ObjectKnowsLocationAndPosition(Location loc, IntegerPos pos) {
        super(loc);
        positionCondition = new PositionCondition(pos);
    }

    protected ObjectKnowsLocationAndPosition(LocationConditionImp locationCond,
            PositionConditionCanUpdateImp positionCond) {
        super(locationCond);
        positionCondition = positionCond;
    }

    protected PositionConditionCanUpdateImp getPositionCondition() {
        return positionCondition;
    }
}
