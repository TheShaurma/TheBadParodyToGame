package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.ObjectOnLocation;
import game_logic.objects_on_location.conditions.Direction;
import game_logic.objects_on_location.conditions.LocationCondition;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.LocationConditionImp;
import game_logic.objects_on_location.conditions.interfaces.with_past.DirectionConditionWithPastImp;
import game_logic.objects_on_location.conditions.interfaces.with_past.PositionConditionWithPastImp;
import game_logic.objects_on_location.conditions.with_past.DirectionConditionWithPast;
import game_logic.objects_on_location.conditions.with_past.PositionConditionWithPast;

public abstract class ObjectWithFoolConditionWithPast implements ObjectOnLocation {
    private final LocationConditionImp locationCondition;
    private final PositionConditionWithPastImp positionCondition;
    private final DirectionConditionWithPastImp directionCondition;

    public ObjectWithFoolConditionWithPast(Location loc, IntegerPos pos, Direction dir) throws PositionException {
        locationCondition = new LocationCondition(loc);
        positionCondition = new PositionConditionWithPast(pos);
        directionCondition = new DirectionConditionWithPast(dir);

        loc.putObject(pos, this);
    }

    protected LocationConditionImp getLocationCondition() {
        return locationCondition;
    }

    protected PositionConditionWithPastImp getPositionCondition() {
        return positionCondition;
    }

    protected DirectionConditionWithPastImp getDirectionCondition() {
        return directionCondition;
    }
}
