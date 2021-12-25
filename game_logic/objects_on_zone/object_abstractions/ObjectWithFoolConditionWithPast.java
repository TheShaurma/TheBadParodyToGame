package game_logic.objects_on_zone.object_abstractions;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.Zone;
import game_logic.objects_on_zone.conditions.Direction;
import game_logic.objects_on_zone.conditions.LocationCondition;
import game_logic.objects_on_zone.conditions.interfaces.cannot_update.LocationConditionImp;
import game_logic.objects_on_zone.conditions.interfaces.with_past.DirectionConditionWithPastImp;
import game_logic.objects_on_zone.conditions.interfaces.with_past.PositionConditionWithPastImp;
import game_logic.objects_on_zone.conditions.with_past.DirectionConditionWithPast;
import game_logic.objects_on_zone.conditions.with_past.PositionConditionWithPast;
import game_logic.abstractions.interfaces.ObjectOnLocation;

public abstract class ObjectWithFoolConditionWithPast implements ObjectOnLocation {
    private final LocationConditionImp locationCondition;
    private final PositionConditionWithPastImp positionCondition;
    private final DirectionConditionWithPastImp directionCondition;

    public ObjectWithFoolConditionWithPast(Zone loc, IntegerPos pos, Direction dir) throws PositionException {
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
