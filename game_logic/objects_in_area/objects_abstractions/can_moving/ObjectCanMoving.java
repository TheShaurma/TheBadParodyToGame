package game_logic.objects_in_area.objects_abstractions.can_moving;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaAndPositionImp;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionCanUpdateImp;
import game_logic.objects_in_area.objects_abstractions.can_moving.exceptions.BusyPositionException;
import game_logic.objects_in_area.objects_abstractions.has_conditions.ObjectHasCondition;

public abstract class ObjectCanMoving<A extends Area<P>, P extends Position<?>, C extends ConditionOfAreaAndPositionImp<AreaConditionImp<A>, PositionConditionCanUpdateImp<P>>>
        extends ObjectHasCondition<C> {

    protected ObjectCanMoving(C cond) throws PositionException {
        super(cond);

        A area = getCondition().getAreaCondition().getValue();
        P pos = getCondition().getPositionCondition().getValue();
        area.putObject(pos, this);
    }

    protected void moveToPosition(P newPos) throws PositionException, BusyPositionException {
        A area = getCondition().getAreaCondition().getValue();
        P oldPos = getCondition().getPositionCondition().getValue();

        if (!area.posIsEmpty(newPos)) {
            throw new BusyPositionException(newPos);
        }

        // TODO: can be problems with multithreading
        area.removeObject(oldPos);
        area.putObject(newPos, this);
    }
}
