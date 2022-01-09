package game_logic.objects_in_area.conditions.single.has_past;

import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.single.can_update.PositionConditionCanUpdate;
import game_logic.objects_in_area.conditions.single.interfaces.SingleCondition;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.PositionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.single.interfaces.has_past.PositionConditionHasPastImp;

public class PositionConditionHasPast<P extends Position<?>> extends PositionConditionCanUpdate<P> implements PositionConditionHasPastImp<P> {

    private PositionConditionCanUpdateImp<P> pastCondition;

    public PositionConditionHasPast(P startPos) {
        super(startPos);

        pastCondition = new PositionConditionCanUpdate<P>(startPos);
    }

    @Override
    public void setValue(P pos) {
        pastCondition.setValue(getValue());

        super.setValue(pos);
    }

    public SingleCondition<P> getPastValue() {
        return pastCondition;
    }
}
