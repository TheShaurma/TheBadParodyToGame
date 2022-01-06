package game_logic.objects_in_area.conditions.object_abstractions;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.ObjectInArea;
import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.AreaCondition;
import game_logic.objects_in_area.conditions.interfaces.cannot_update.AreaConditionImp;
import game_logic.objects_in_area.conditions.interfaces.with_past.DirectionConditionWithPastImp;
import game_logic.objects_in_area.conditions.interfaces.with_past.PositionConditionWithPastImp;
import game_logic.objects_in_area.conditions.with_past.DirectionConditionWithPast;
import game_logic.objects_in_area.conditions.with_past.PositionConditionWithPast;

public abstract class ObjectWithFoolConditionWithPast implements ObjectInArea {
    private final AreaConditionImp locationCondition;
    private final PositionConditionWithPastImp positionCondition;
    private final DirectionConditionWithPastImp directionCondition;

    public ObjectWithFoolConditionWithPast(CheckeredArea loc, IntegerPos pos, Direction dir) throws PositionException {
        locationCondition = new AreaCondition(loc);
        positionCondition = new PositionConditionWithPast(pos);
        directionCondition = new DirectionConditionWithPast(dir);

        loc.putObject(pos, this);
    }

    protected AreaConditionImp getLocationCondition() {
        return locationCondition;
    }

    protected PositionConditionWithPastImp getPositionCondition() {
        return positionCondition;
    }

    protected DirectionConditionWithPastImp getDirectionCondition() {
        return directionCondition;
    }
}
