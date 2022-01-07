package game_logic.objects_in_area.objects_abstractions.can_moving;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_in_area.conditions.multiple.ConditionOfAreaAndPosition;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaAndPositionImp;
import game_logic.objects_in_area.conditions.single.AreaCondition;
import game_logic.objects_in_area.conditions.single.PositionConditionCanUpdate;
import game_logic.objects_in_area.objects_abstractions.can_moving.exceptions.BusyPositionException;
import game_logic.objects_in_area.objects_abstractions.has_conditions.ObjectHasCondition;

public abstract class ObjectCanMovingCheckeredAreaToAssignedPosition
        extends
        ObjectHasCondition<ConditionOfAreaAndPositionImp<AreaCondition<CheckeredArea>, PositionConditionCanUpdate<IntegerPos>>> {

    public ObjectCanMovingCheckeredAreaToAssignedPosition(CheckeredArea area, IntegerPos pos) throws PositionException {
        super(new ConditionOfAreaAndPosition<AreaCondition<CheckeredArea>, PositionConditionCanUpdate<IntegerPos>>(
                new AreaCondition<CheckeredArea>(area), new PositionConditionCanUpdate<IntegerPos>(pos)));

        area.putObject(pos, this);
    }

    protected void moveToPos(IntegerPos newPos) throws PositionException, BusyPositionException {
        CheckeredArea area = getCondition().getAreaCondition().getValue();
        IntegerPos oldPos = getCondition().getPositionCondition().getValue();
        PositionConditionCanUpdate<IntegerPos> posCond = getCondition().getPositionCondition();

        if (!area.posIsEmpty(newPos)) {
            throw new BusyPositionException(newPos);
        }

        // TODO: in future will be BIG peoblims with multithreading
        area.removeObject(oldPos);
        area.putObject(newPos, this);
        posCond.setValue(newPos);
    }
}
