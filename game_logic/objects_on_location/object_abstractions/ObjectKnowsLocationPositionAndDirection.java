package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.conditions.Direction;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfLocationImp;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfPositionImp;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfDirectionImp;
import game_logic.objects_on_location.conditions.ConditionOfDirection;

public abstract class ObjectKnowsLocationPositionAndDirection extends ObjectKnowsLocationAndPosition {
    private ConditionOfDirectionImp directionCondition;

    public ObjectKnowsLocationPositionAndDirection(Location loc, IntegerPos pos, Direction dir) {
        super(loc, pos);
        directionCondition = new ConditionOfDirection(dir);
    }

    protected ObjectKnowsLocationPositionAndDirection(ConditionOfLocationImp locationCond,
            ConditionOfPositionImp positionCond, ConditionOfDirectionImp directionCond) {
        super(locationCond, positionCond);
        directionCondition = directionCond;
    }

    protected ConditionOfDirectionImp getDirectionCondition() {
        return directionCondition;
    }
}
