package game_logic.objects_in_area.conditions.single.has_past;

import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.single.can_update.DirectionConditionCanUpdate;
import game_logic.objects_in_area.conditions.single.interfaces.SingleCondition;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.DirectionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.single.interfaces.has_past.DirectionConditionHasPastImp;

public class DirectionConditionHasPast extends DirectionConditionCanUpdate implements DirectionConditionHasPastImp {
    private DirectionConditionCanUpdateImp pastCondition;

    public DirectionConditionHasPast(Direction dir) {
        super(dir);

        pastCondition = new DirectionConditionCanUpdate(dir);
    }

    @Override
    public SingleCondition<Direction> getPastValue() {
        return pastCondition;
    }

}
