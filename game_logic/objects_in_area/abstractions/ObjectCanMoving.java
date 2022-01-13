package game_logic.objects_in_area.abstractions;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.abstractions.exceptions.BusyPositionException;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaAndPositionImp;
import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.single.interfaces.SingleConditionImp;

public abstract class ObjectCanMoving<A extends Area<P>, P extends Position<?>, C extends ConditionOfAreaAndPositionImp<? extends SingleConditionImp<A>, ? extends SingleConditionCanUpdateImp<P>>>
        extends ObjectHasCondition<C> {

    protected ObjectCanMoving(C cond) {
        super(cond);
    }

    protected void moveToPosition(P newPos) throws PositionException, BusyPositionException {
        A area = getCondition().getAreaCondition().getValue();

        if (!area.posIsEmpty(newPos)) {
            throw new BusyPositionException(newPos);
        }

        P oldPos = getCondition().getPositionCondition().getValue();

        area.removeObject(oldPos);
        area.putObject(newPos, this);
    }
}