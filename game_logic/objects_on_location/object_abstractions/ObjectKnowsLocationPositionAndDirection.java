package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.conditions.Direction;
import game_logic.objects_on_location.conditions.interfaces.LocationConditionImp;
import game_logic.objects_on_location.conditions.interfaces.PositionConditionImp;
import game_logic.objects_on_location.conditions.interfaces.DirectionConditionImp;
import game_logic.objects_on_location.conditions.DirectionCondition;

public abstract class ObjectKnowsLocationPositionAndDirection extends ObjectKnowsLocationAndPosition {
    private DirectionConditionImp directionCondition;

    public ObjectKnowsLocationPositionAndDirection(Location loc, IntegerPos pos, Direction dir) {
        super(loc, pos);
        directionCondition = new DirectionCondition(dir);
    }

    protected ObjectKnowsLocationPositionAndDirection(LocationConditionImp locationCond,
            PositionConditionImp positionCond, DirectionConditionImp directionCond) {
        super(locationCond, positionCond);
        directionCondition = directionCond;
    }

    protected DirectionConditionImp getDirectionCondition() {
        return directionCondition;
    }
}
