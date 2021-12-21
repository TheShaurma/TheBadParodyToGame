package game_logic.objects_on_location.conditions.with_past;

import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_on_location.conditions.PositionCondition;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.PositionConditionCannotUpdateImp;
import game_logic.objects_on_location.conditions.interfaces.with_past.PositionConditionWithPastImp;

public class PositionConditionWithPast extends PositionCondition implements PositionConditionWithPastImp {
    PositionCondition past;

    public PositionConditionWithPast(IntegerPos pos) {
        super(pos);
        past = new PositionCondition(pos);
    }

    public PositionConditionCannotUpdateImp getPast() {
        return past;
    }

    @Override
    public void updatePosition(IntegerPos pos) {
        super.updatePosition(pos);
        past.updatePosition(pos);
    }
}
