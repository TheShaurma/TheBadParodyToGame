package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.conditions.Direction;
import game_logic.objects_on_location.conditions.interfaces.PositionConditionCanUpdateImp;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.LocationConditionImp;
import game_logic.objects_on_location.conditions.interfaces.DirectionConditionCanUpdateImp;
import game_logic.objects_on_location.conditions.DirectionCondition;

public abstract class ObjectKnowsLocationPositionAndDirection extends ObjectKnowsLocationAndPosition {
    private DirectionConditionCanUpdateImp directionCondition;

    public ObjectKnowsLocationPositionAndDirection(Location loc, IntegerPos pos, Direction dir) {
        super(loc, pos);
        directionCondition = new DirectionCondition(dir);
    }

    protected ObjectKnowsLocationPositionAndDirection(LocationConditionImp locationCond,
            PositionConditionCanUpdateImp positionCond, DirectionConditionCanUpdateImp directionCond) {
        super(locationCond, positionCond);
        directionCondition = directionCond;
    }

    protected DirectionConditionCanUpdateImp getDirectionCondition() {
        return directionCondition;
    }
}
