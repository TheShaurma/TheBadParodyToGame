package game_logic.objects_in_area.objects_abstractions.can_moving;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaAndPositionImp;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionCanUpdateImp;
import game_logic.objects_in_area.objects_abstractions.can_moving.exceptions.BusyPositionException;
import game_logic.objects_in_area.objects_abstractions.has_conditions.ObjectHasCondition;

public abstract class ObjectCanMovingInAreaToAssignedPosition<A extends Area<P>, P extends Position<?>>
        extends
        ObjectHasCondition<ConditionOfAreaAndPositionImp<AreaConditionImp<A>, PositionConditionCanUpdateImp<P>>> {

    protected ObjectCanMovingInAreaToAssignedPosition(
            ConditionOfAreaAndPositionImp<AreaConditionImp<A>, PositionConditionCanUpdateImp<P>> cond)
            throws PositionException {
        super(cond);

        A area = getCondition().getAreaCondition().getValue();
        P pos = getCondition().getPositionCondition().getValue();
        area.putObject(pos, this);
    }

    protected void moveToPos(P newPos) throws PositionException, BusyPositionException {
        A area = getCondition().getAreaCondition().getValue();
        P oldPos = getCondition().getPositionCondition().getValue();
        PositionConditionCanUpdateImp<P> posCond = getCondition().getPositionCondition();

        if (!area.posIsEmpty(newPos)) {
            throw new BusyPositionException(newPos);
        }

        // TODO: in future will be BIG problems with multithreading
        area.removeObject(oldPos);
        area.putObject(newPos, this);
        posCond.setValue(newPos);
    }
}
